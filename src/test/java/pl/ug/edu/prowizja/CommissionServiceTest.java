package pl.ug.edu.prowizja;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.LocalDate;

import junit.framework.TestCase;
import pl.ug.edu.prowizja.dao.commission.CommissionDao;
import pl.ug.edu.prowizja.dao.policy.PolicyDao;
import pl.ug.edu.prowizja.domain.commission.CommissionEntity;
import pl.ug.edu.prowizja.domain.commission.CommissionFilter;
import pl.ug.edu.prowizja.domain.commission.Wojewodztwo;
import pl.ug.edu.prowizja.domain.policy.InsurancePackage;
import pl.ug.edu.prowizja.domain.policy.PolicyEntity;
import pl.ug.edu.prowizja.domain.policy.PolicyFilter;
import pl.ug.edu.prowizja.services.commission.CommissionService;

public class CommissionServiceTest extends TestCase {

	private PolicyDao policyDao = new PolicyDao();
	private CommissionDao commissionDao = new CommissionDao();
	private CommissionService commissionService = new CommissionService();
	private String policyNumber1 = "QWE123";
	private String policyNumber2 = "ASD456", policyNumber3 = "ZXC789";

	private void deletePolicy(String policyNumber) throws SQLException {
		List<PolicyEntity> policies = policyDao.select(new PolicyFilter(policyNumber, null));
		for (PolicyEntity policy : policies) {

			List<CommissionEntity> commissions = commissionDao.select(new CommissionFilter(null, policy.getId()));
			for (CommissionEntity commission : commissions) {
				commissionDao.delete(commission);
			}

			policyDao.delete(policy);
		}
	}

	private PolicyEntity createPolicy(InsurancePackage insurancePackage, String policyNumber, BigMoney premium,
			LocalDate protectionOn, LocalDate protectionOff) throws SQLException {
		PolicyEntity policy = new PolicyEntity();
		policy.setInsurancePackage(insurancePackage);
		policy.setPolicyNumber(policyNumber);
		policy.setPremium(premium);
		policy.setProtectionOn(protectionOn);
		policy.setProtectionOff(protectionOff);
		policyDao.create(policy);
		return policy;
	}

	@Override
	protected void setUp() throws Exception {
		deletePolicy(policyNumber1);
		deletePolicy(policyNumber2);
		deletePolicy(policyNumber3);
	}

	public void testAddCommision() throws SQLException {
		PolicyEntity policy = createPolicy(InsurancePackage.CAR, policyNumber1,
				BigMoney.of(CurrencyUnit.of("PLN"), BigDecimal.valueOf(1000000)), LocalDate.now(),
				LocalDate.now().plusYears(1));

		commissionService.calculateCommission(policyNumber1, Wojewodztwo.POMORSKIE);

		List<CommissionEntity> commissions = commissionDao
				.select(new CommissionFilter(Wojewodztwo.POMORSKIE, policy.getId()));
		assertNotNull(commissions);
		assertEquals(1, commissions.size());

		CommissionEntity commission = commissions.iterator().next();
		assertEquals(policy.getId(), commission.getPolisaId());
		assertEquals(Wojewodztwo.POMORSKIE, commission.getWojewodztwo());
		assertEquals(BigDecimal.valueOf(20000), commission.getWartosc());
	}

	public void testCommissionSum() throws SQLException {
		createPolicy(InsurancePackage.CAR, policyNumber1,
				BigMoney.of(CurrencyUnit.of("PLN"), BigDecimal.valueOf(1000000)), LocalDate.now(),
				LocalDate.now().plusYears(1));

		createPolicy(InsurancePackage.HOUSE, policyNumber2,
				BigMoney.of(CurrencyUnit.of("PLN"), BigDecimal.valueOf(2000000)), LocalDate.now(),
				LocalDate.now().plusYears(1));

		commissionService.calculateCommission(policyNumber1, Wojewodztwo.MAZOWIECKIE);
		commissionService.calculateCommission(policyNumber2, Wojewodztwo.MAZOWIECKIE);

		Money sum = commissionService.calculateProvinceSum(Wojewodztwo.MAZOWIECKIE);

		assertNotNull(sum);
		assertEquals(Money.of(CurrencyUnit.of("PLN"), 85000), sum);
	}
}

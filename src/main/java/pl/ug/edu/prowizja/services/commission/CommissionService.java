package pl.ug.edu.prowizja.services.commission;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import pl.ug.edu.prowizja.dao.commission.CommissionDao;
import pl.ug.edu.prowizja.dao.policy.PolicyDao;
import pl.ug.edu.prowizja.domain.commission.CommissionEntity;
import pl.ug.edu.prowizja.domain.commission.CommissionFilter;
import pl.ug.edu.prowizja.domain.commission.Wojewodztwo;
import pl.ug.edu.prowizja.domain.policy.InsurancePackage;
import pl.ug.edu.prowizja.domain.policy.PolicyEntity;
import pl.ug.edu.prowizja.domain.policy.PolicyFilter;

public class CommissionService {

	private PolicyDao policyDao = new PolicyDao();
	private CommissionDao commissionDao = new CommissionDao();
	private Log log = LogFactory.getLog(CommissionService.class);

	public void calculateCommission(String policyNumber, Wojewodztwo wojewodztwo) throws SQLException {
		List<PolicyEntity> policies = policyDao.select(new PolicyFilter(policyNumber, null));
		for (PolicyEntity policy : policies) {
			Money commission = calculate(policy.getInsurancePackage(), wojewodztwo, policy.getPremium().toMoney());

			CommissionEntity commissionEntity = new CommissionEntity();
			commissionEntity.setPolisaId(policy.getId());
			commissionEntity.setWojewodztwo(wojewodztwo);
			commissionEntity.setWartosc(commission.getAmount());

			commissionDao.create(commissionEntity);
		}
	}

	public Money calculateProvinceSum(Wojewodztwo wojewodztwo) throws SQLException {
		Money provinceCommissionPln = Money.of(CurrencyUnit.of("PLN"), 0.0);

		List<CommissionEntity> commissions = commissionDao.select(new CommissionFilter(wojewodztwo, null));
		for (CommissionEntity commission : commissions) {
			provinceCommissionPln = provinceCommissionPln.plus(commission.getWartosc());
		}

		Money provinceCommissionEur = provinceCommissionPln.convertedTo(CurrencyUnit.of("EUR"),
				BigDecimal.valueOf(1 / 4.38639), RoundingMode.HALF_UP);

		log.info("Prowizja w wojewodztwie " + wojewodztwo.getCode() + " wynosi " + provinceCommissionPln + " lub "
				+ provinceCommissionEur);

		return provinceCommissionPln;
	}

	public Money calculate(InsurancePackage insurancePackage, Wojewodztwo wojewodztwo, Money premium) {
		double rate = 0.0;
		switch (insurancePackage) {
		case CAR:
			switch (wojewodztwo) {
			case POMORSKIE:
				rate = 0.02;
				break;
			case MAZOWIECKIE:
				rate = 0.025;
				break;
			default:
				rate = 0.018;
				break;
			}
			break;
		case HOUSE:
			switch (wojewodztwo) {
			case POMORSKIE:
				rate = 0.015;
				break;
			case MAZOWIECKIE:
				rate = 0.03;
				break;
			default:
				rate = 0.08;
				break;
			}
			break;
		case FURNITURE:
			switch (wojewodztwo) {
			case POMORSKIE:
				rate = 0.056;
				break;
			case MAZOWIECKIE:
				rate = 0.06;
				break;
			default:
				rate = 0.0635;
				break;
			}
			break;
		}
		return premium.multipliedBy(rate, RoundingMode.HALF_UP);
	}
}

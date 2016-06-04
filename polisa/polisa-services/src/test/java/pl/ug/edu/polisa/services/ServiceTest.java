package pl.ug.edu.polisa.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.ug.edu.polisa.dao.insured.InsuredDao;
import pl.ug.edu.polisa.dao.policy.PolicyDao;
import pl.ug.edu.polisa.dao.risk.RiskDao;
import pl.ug.edu.polisa.domain.core.BigMoneyHelper;
import pl.ug.edu.polisa.domain.insured.InsuredEntity;
import pl.ug.edu.polisa.domain.policy.InsurancePackage;
import pl.ug.edu.polisa.domain.policy.PolicyEntity;
import pl.ug.edu.polisa.domain.policy.PolicyFilter;
import pl.ug.edu.polisa.domain.risk.Insurance;
import pl.ug.edu.polisa.domain.risk.RiskEntity;
import pl.ug.edu.polisa.services.policy.PolicyService;

/**
 * Klasa testowa DAO RISK
 *
 */
public class ServiceTest extends TestCase {

	private PolicyDao policydao;

	private RiskDao riskdao;

	private InsuredDao insuredDao;
	
	private PolicyService policyService;

	public ServiceTest(String testName) throws Exception {
		super(testName);
		policydao = new PolicyDao();
		riskdao = new RiskDao();
		insuredDao = new InsuredDao();
		policyService = new PolicyService();
	}

	public static Test suite() {
		return new TestSuite(ServiceTest.class);
	}

	/**
	 * Test utworzenia polisy
	 * 
	 * @throws SQLException
	 */
	public void testPolicyEntity() throws SQLException {
		LocalDate protectionOn = LocalDate.now();
		LocalDate protectionOff = LocalDate.now().plusYears(1);
		
		PolicyEntity policy = new PolicyEntity();
		policy.setPremium(BigMoneyHelper.of("1.13"));
		policy.setProtectionOn(protectionOn);
		policy.setProtectionOff(protectionOff);
		policy.setInsurancePackage(InsurancePackage.CAR);
		
		RiskEntity risk1 = new RiskEntity();
		risk1.setInsurance(Insurance.OC);
		risk1.setPremium(BigMoneyHelper.of("0.13"));
		risk1.setProtectionOn(protectionOn);
		risk1.setProtectionOff(protectionOff);
		policy.addRisk(risk1);

		RiskEntity risk2 = new RiskEntity();
		risk2.setInsurance(Insurance.AC);
		risk2.setPremium(BigMoneyHelper.of("0.23"));
		risk2.setProtectionOn(protectionOn);
		risk2.setProtectionOff(protectionOff);
		policy.addRisk(risk2);
		
		InsuredEntity insured = new InsuredEntity();
		insured.setAge(18);
		insured.setFirstName("Jurek");
		insured.setSecondName("Owsiak");
		policy.addInsured(insured);
		
		policy = policyService.create(policy);
		
		PolicyFilter filter = new PolicyFilter();
		filter.setPolicyNumber(policy.getPolicyNumber());
		List<PolicyEntity> result = new ArrayList<PolicyEntity>();
		result = policydao.select(filter);
		
		assertNotNull(result);
		assertEquals(result.isEmpty(), false);
//		policy = result.iterator().next();
//		Integer policyId = policy.getId();
//		policydao.delete(policy);
//		policy = policydao.retrieve(policyId);
//		assertEquals(policy == null, true);
	}
	
	public void testCalculatePolicyEntity() throws SQLException {
		LocalDate protectionOn = LocalDate.now();
		LocalDate protectionOff = LocalDate.now().plusYears(1);
		
		PolicyEntity policy = new PolicyEntity();
		policy.setPremium(BigMoneyHelper.of("0"));
		policy.setProtectionOn(protectionOn);
		policy.setProtectionOff(protectionOff);
		policy.setInsurancePackage(InsurancePackage.CAR);
		
		RiskEntity risk1 = new RiskEntity();
		risk1.setInsurance(Insurance.OC);
		risk1.setPremium(BigMoneyHelper.of("0.13"));
		risk1.setProtectionOn(protectionOn);
		risk1.setProtectionOff(protectionOff);
		policy.addRisk(risk1);

		RiskEntity risk2 = new RiskEntity();
		risk2.setInsurance(Insurance.AC);
		risk2.setPremium(BigMoneyHelper.of("0.23"));
		risk2.setProtectionOn(protectionOn);
		risk2.setProtectionOff(protectionOff);
		policy.addRisk(risk2);
		
		InsuredEntity insured = new InsuredEntity();
		insured.setAge(18);
		insured.setFirstName("Jurek");
		insured.setSecondName("Owsiak");
		policy.addInsured(insured);
		
		policy = policyService.create(policy);
		
		PolicyFilter filter = new PolicyFilter();
		filter.setPolicyNumber(policy.getPolicyNumber());
		List<PolicyEntity> result = new ArrayList<PolicyEntity>();
		result = policydao.select(filter);
		policy = result.iterator().next();
		
		System.out.println(policy);
		
		policyService.calculate(policy);
		
		System.out.println("Premium: " + policy.getPremium());
		for(RiskEntity re : policy.getRisks()) {
			System.out.println("Ryzyko: " + re.getInsurance().getCode() + " " + re.getPremium()); 
		}
		
//		assertNotNull(result);
//		assertEquals(result.isEmpty(), false);
//		policy = result.iterator().next();
//		Integer policyId = policy.getId();
//		policydao.delete(policy);
//		policy = policydao.retrieve(policyId);
//		assertEquals(policy == null, true);
	}


}

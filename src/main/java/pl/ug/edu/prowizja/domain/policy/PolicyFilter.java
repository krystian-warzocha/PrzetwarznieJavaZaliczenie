package pl.ug.edu.prowizja.domain.policy;

import pl.ug.edu.prowizja.domain.core.Filter;

/**
 * Filtr dla polis
 *
 */
public class PolicyFilter implements Filter {

	public PolicyFilter() {
		super();
	}

	public PolicyFilter(String policyNumber, InsurancePackage insurancePackage) {
		super();
		this.policyNumber = policyNumber;
		this.insurancePackage = insurancePackage;
	}

	/** Numer polisy */
	private String policyNumber;

	/** Pakiet ubezpieczeniowy */
	private InsurancePackage insurancePackage;

	/**
	 * @return the policyNumber
	 */
	public String getPolicyNumber() {
		return policyNumber;
	}

	/**
	 * @param policyNumber
	 *            the policyNumber to set
	 */
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	/**
	 * @return the insurancePackage
	 */
	public InsurancePackage getInsurancePackage() {
		return insurancePackage;
	}

	/**
	 * @param insurancePackage
	 *            the insurancePackage to set
	 */
	public void setInsurancePackage(InsurancePackage insurancePackage) {
		this.insurancePackage = insurancePackage;
	}

}

package pl.ug.edu.prowizja.domain.policy;

import org.joda.money.BigMoney;
import org.joda.time.LocalDate;

import pl.ug.edu.prowizja.domain.core.BaseEntity;
import pl.ug.edu.prowizja.domain.core.Entity;

/**
 * Encja polisy
 */
@Entity(tableName = "POLISA")
public class PolicyEntity extends BaseEntity {

	/** Numer polisy */
	private String policyNumber;

	/** Suma skłądki na polisie */
	private BigMoney premium;

	/** Data ubezpieczenia Od */
	private LocalDate protectionOn;

	/** Data ubezpieczenia Do */
	private LocalDate protectionOff;

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
	 * @return the premium
	 */
	public BigMoney getPremium() {
		return premium;
	}

	/**
	 * @param premium
	 *            the premium to set
	 */
	public void setPremium(BigMoney premium) {
		this.premium = premium;
	}

	/**
	 * @return the protectionOn
	 */
	public LocalDate getProtectionOn() {
		return protectionOn;
	}

	/**
	 * @param protectionOn
	 *            the protectionOn to set
	 */
	public void setProtectionOn(LocalDate protectionOn) {
		this.protectionOn = protectionOn;
	}

	/**
	 * @return the protectionOff
	 */
	public LocalDate getProtectionOff() {
		return protectionOff;
	}

	/**
	 * @param protectionOff
	 *            the protectionOff to set
	 */
	public void setProtectionOff(LocalDate protectionOff) {
		this.protectionOff = protectionOff;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see pl.ug.edu.polisa.domain.core.BaseEntity#displayable()
	 */
	@Override
	public String displayable() {
		StringBuilder sb = new StringBuilder();
		sb.append(getId()).append(" ").append(getPolicyNumber());
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PolicyEntity [policyNumber=" + policyNumber + ", premium=" + premium + ", protectionOn=" + protectionOn
				+ ", protectionOff=" + protectionOff + ", insurancePackage=" + insurancePackage + "]";
	}
}

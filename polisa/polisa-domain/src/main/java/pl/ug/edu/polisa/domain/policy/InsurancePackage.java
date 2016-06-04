package pl.ug.edu.polisa.domain.policy;

import pl.ug.edu.polisa.domain.core.EnumByCodeString;
import pl.ug.edu.polisa.domain.core.EnumUtil;

/**
 * Enum z pakietami ubezpieczeniowymi
 */
public enum InsurancePackage implements EnumByCodeString<String> {

	CAR("C"),

	HOUSE("H"),

	FURNITURE("F")

	;

	private String code;

	private InsurancePackage(String code) {
		this.code = code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pl.ug.edu.polisa.domain.core.EnumByCodeString#getCode()
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Metoda zwraca instancje enuma po kodzie
	 * 
	 * @param code
	 *            kod enuma
	 * @return
	 */
	public static InsurancePackage byCode(String code) {
		return EnumUtil.byCode(code, InsurancePackage.values());
	}

}

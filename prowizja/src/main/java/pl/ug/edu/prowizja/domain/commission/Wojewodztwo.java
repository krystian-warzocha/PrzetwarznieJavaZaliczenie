package pl.ug.edu.prowizja.domain.commission;

import pl.ug.edu.prowizja.domain.core.EnumByCodeString;
import pl.ug.edu.prowizja.domain.core.EnumUtil;

public enum Wojewodztwo implements EnumByCodeString<String> {
	
	POMORSKIE, MAZOWIECKIE, MALOPOLSKIE;

	public String getCode() {
		return this.name();
	}
	
	public static Wojewodztwo byCode(String code) {
		return EnumUtil.byCode(code, Wojewodztwo.values());
	}

}

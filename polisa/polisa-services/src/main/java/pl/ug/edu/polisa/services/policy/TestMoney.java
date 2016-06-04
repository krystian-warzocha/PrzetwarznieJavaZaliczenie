package pl.ug.edu.polisa.services.policy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class TestMoney {

	public static void main(String[] args) {
		BigDecimal bd1 = new BigDecimal("1.13");
		
		BigDecimal kwota = bd1.multiply(new BigDecimal("2.5"));
		System.out.println(kwota);
		
		System.out.println(kwota.setScale(2, RoundingMode.DOWN));
		System.out.println(kwota.setScale(2, RoundingMode.HALF_DOWN));

		System.out.println(kwota.setScale(2, RoundingMode.UP));
		System.out.println(kwota.setScale(2, RoundingMode.HALF_UP));

		Money money = Money.of(CurrencyUnit.of("PLN"), 1.13);
		System.out.println("Money: " + money);
		System.out.println("Money: " + money.multipliedBy(2.5, RoundingMode.HALF_UP));
		System.out.println("BigDecimal: " + bd1.divide(new BigDecimal("3.3"), 2, RoundingMode.HALF_UP));
		System.out.println("Money: " + money.dividedBy(3.3, RoundingMode.HALF_UP));
	}
}

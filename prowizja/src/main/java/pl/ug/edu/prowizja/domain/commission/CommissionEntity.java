package pl.ug.edu.prowizja.domain.commission;

import java.math.BigDecimal;
import pl.ug.edu.prowizja.domain.core.BaseEntity;
import pl.ug.edu.prowizja.domain.core.Entity;

@Entity(tableName="PROWIZJA")
public class CommissionEntity extends BaseEntity {

	private Integer polisaId;
	private Wojewodztwo wojewodztwo;
	private BigDecimal wartosc;

	public Integer getPolisaId() {
		return polisaId;
	}

	public void setPolisaId(Integer polisaId) {
		this.polisaId = polisaId;
	}

	public Wojewodztwo getWojewodztwo() {
		return wojewodztwo;
	}

	public void setWojewodztwo(Wojewodztwo wojewodztwo) {
		this.wojewodztwo = wojewodztwo;
	}

	public BigDecimal getWartosc() {
		return wartosc;
	}

	public void setWartosc(BigDecimal wartosc) {
		this.wartosc = wartosc;
	}

	@Override
	public String displayable() {
		StringBuilder sb = new StringBuilder();
		sb.append(getId());
		return sb.toString();
	}

	@Override
	public String toString() {
		return "CommissionEntity [polisaId=" + polisaId + ", wojewodztwo=" + wojewodztwo + ", wartosc=" + wartosc
				+ ", getId()=" + getId() + "]";
	}

}

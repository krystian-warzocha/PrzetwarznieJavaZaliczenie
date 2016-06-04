package pl.ug.edu.prowizja.domain.commission;

import pl.ug.edu.prowizja.domain.core.Filter;

public class CommissionFilter implements Filter {
	
	public CommissionFilter() {
		super();
	}

	public CommissionFilter(Wojewodztwo wojewodztwo, Integer policyId) {
		super();
		this.wojewodztwo = wojewodztwo;
		this.policyId = policyId;
	}

	private Wojewodztwo wojewodztwo;
	
	private Integer policyId;

	public Wojewodztwo getWojewodztwo() {
		return wojewodztwo;
	}

	public void setWojewodztwo(Wojewodztwo wojewodztwo) {
		this.wojewodztwo = wojewodztwo;
	}

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

}

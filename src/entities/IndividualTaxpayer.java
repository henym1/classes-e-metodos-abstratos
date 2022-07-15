package entities;

public class IndividualTaxpayer extends Taxpayer {

	private Double healthExpenditures;
	
	public IndividualTaxpayer() {
	}
	
	public IndividualTaxpayer(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		if(this.annualIncome < 20000) {
			return (annualIncome * 0.15) - (healthExpenditures * 0.5);
		} else {
			return (annualIncome * 0.25) - (healthExpenditures * 0.5);
		}
	}

	@Override
	public String toString() {
		return this.name
				+ ": $ "
				+ String.format("%.2f", this.tax());
	}
}

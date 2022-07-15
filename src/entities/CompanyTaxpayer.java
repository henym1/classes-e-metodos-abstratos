package entities;

public class CompanyTaxpayer extends Taxpayer{

	private Integer numberOfEmployees;
	
	public CompanyTaxpayer() {
	}
	
	public CompanyTaxpayer(String name, Double annualIncome, Integer numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double tax() {
		if(numberOfEmployees <= 10) {
			return (annualIncome * 0.16);
		} else {
			return (annualIncome * 0.14);
		}
	}

	@Override
	public String toString() {
		return this.name
				+ ": $ "
				+ String.format("%.2f", this.tax());
	}
	
}

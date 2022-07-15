package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Taxpayer;
import entities.IndividualTaxpayer;
import entities.CompanyTaxpayer;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Taxpayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of taxpayers: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new IndividualTaxpayer(name, annualIncome, healthExpenditures));
				System.out.println();
			}
			else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new CompanyTaxpayer(name, annualIncome, numberOfEmployees));
				System.out.println();
			}	
		}
		
		System.out.println("TAXES PAID:");
		for (Taxpayer taxpayer : list) {
			System.out.println(taxpayer);
		}
		
		double sum = 0;
		for (Taxpayer taxpayer : list) {
			sum += taxpayer.tax();
		}
		
		System.out.println();
		System.out.print("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}

}

package Tuition;

import java.util.Scanner;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class TuitionVariables {
	
	
	private double term;
	private double tuitionCost;
	private double percentIncrease;
	private double APR;

	
	
	// Getters and Setters
	
	public void setTerm(double term) {
		this.term = term;
	}
	public double getTerm() {
		return term;
	}
	public void setTuitionCost(double tuitionCost) {
		this.tuitionCost = tuitionCost;
	}
	public double getTuitionCost() {
		return tuitionCost;
	}
	public void setPercentIncrease(double percentIncrease) {
		this.percentIncrease = percentIncrease;
	}
	public double getPercentIncrease() {
		return percentIncrease;
	}
	public void setAPR(double APR) {
		this.APR = APR;
	}
	public double getAPR() {
		return APR;
	}
	
	
	
	// Constructor
	
	public TuitionVariables(double term, double tuitionCost, double percentIncrease, double APR) {
	
		this.term = term;
		this.tuitionCost = tuitionCost;
		this.percentIncrease = percentIncrease;
		this.APR = APR;
	}
	
	// Methods
	
	public double getTuitionTotal(double t, double rate) {
		double increase = t * rate;
		for (int i = 0; i<3; i++){
			t += increase;
			increase = increase * rate;
			
		}
		return t;
	}
	
	// Main

	public static void main(String[] args) {
		
	double sc;
	Scanner scanner = new Scanner(System.in);
	TuitionVariables tuition = new TuitionVariables(0, 0, 0, 0);
	
		
	System.out.println("What is the initial cost of tuition?: ");
	sc = scanner.nextDouble();
	tuition.setTuitionCost(sc);
	
	
	System.out.println("What percent does tuition rise each year? : ");
	sc = scanner.nextDouble();
	sc = 1 + (sc / 100);
	tuition.setPercentIncrease(sc);
	
	
	System.out.println("What is the repayment APR?: ");
	sc = scanner.nextDouble();
	sc = sc / 100;
	tuition.setAPR(sc);
	
	
	System.out.println("How many years do you expect to pay it off?: ");
	sc = scanner.nextDouble();
	tuition.setTerm(sc);
	
	double total;
	total = tuition.getTuitionTotal(tuition.getTuitionCost(), tuition.getPercentIncrease());
	System.out.println("The total cost of four years is $ " + total);
	
	double FV; 
	
	FV = FinanceLib.fv(tuition.getAPR(), tuition.getTerm(), 0, total, true);
	FV *= -1;
	System.out.println("The total cost of your loan with interest is $ " + FV);
	
	double monthly;
	monthly = FV / (tuition.getTerm() * 12);
	System.out.println("You can expect to pay monthly $ " + monthly);
	
	
	
	
	}
}

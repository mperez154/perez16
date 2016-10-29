package application;

public class Loan {
  private double annualInterestRate;
  private int numberOfYears;
  private double loanAmount;
  private double downPayment = 0;
  private double title_tag = 500.00;
  private double gap = 500.00;
  private double dealerFees = 500.00;
  
  
  public void setDownPayment(double downPayment) {
	this.downPayment = downPayment;
}

private java.util.Date loanDate;

  /** Default constructor */
  public Loan() {
    this(2.5, 1, 1000, 500);
  }

  /** Construct a loan with specified annual interest rate,
      number of years, and loan amount
    */
  public Loan(double annualInterestRate, int numberOfYears,
      double loanAmount, double down) {
    this.annualInterestRate = annualInterestRate;
    this.numberOfYears = numberOfYears;
    this.loanAmount = loanAmount;
    this.downPayment = down;
    loanDate = new java.util.Date();
  }

  /** Return annualInterestRate */
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /** Set a new annualInterestRate */
  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  /** Return numberOfYears */
  public int getNumberOfYears() {
    return numberOfYears;
  }

  /** Set a new numberOfYears */
  public void setNumberOfYears(int numberOfYears) {
    this.numberOfYears = numberOfYears;
  }

  /** Return loanAmount */
  public double getLoanAmount() {
    return loanAmount;
  }

  /** Set a newloanAmount */
  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  /** Find monthly payment */
  public double getMonthlyPayment() {
	
	double tax = loanAmount * .07;
    double monthlyInterestRate = annualInterestRate / 1200;
    double monthlyPayment = (loanAmount + tax + dealerFees + title_tag + gap - downPayment) * monthlyInterestRate / (1 -
      (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
    return monthlyPayment;    
  }

  public void setTitle_tag(double title_tag) {
	this.title_tag = title_tag;
}

public void setGap(double gap) {
	this.gap = gap;
}

public void setDealerFees(double dealerFees) {
	this.dealerFees = dealerFees;
}

/** Find total payment */
  public double getTotalPayment() {
    double totalPayment = getMonthlyPayment() * numberOfYears * 12;
    return totalPayment;    
  }

  /** Return loan date */
  public java.util.Date getLoanDate() {
    return loanDate;
  }
}

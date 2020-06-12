package co.scotiabank.customermortage.models;

public class MortagePaymentRequest {

    private double downPayment;
    private double propertyPurchasePrice;
    private double annualInterestRate;
    private int lengthLoan;

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double getPropertyPurchasePrice() {
        return propertyPurchasePrice;
    }

    public void setPropertyPurchasePrice(double propertyPurchasePrice) {
        this.propertyPurchasePrice = propertyPurchasePrice;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getLengthLoan() {
        return lengthLoan;
    }

    public void setLengthLoan(int lengthLoan) {
        this.lengthLoan = lengthLoan;
    }
}

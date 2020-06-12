package co.scotiabank.customermortage.services;
import co.scotiabank.customermortage.models.MortagePaymentRequest;
import co.scotiabank.customermortage.models.MortagePaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class MortagePaymentService {

    static final int MONTHS_YEAR = 12;
    static final int MAX_LOAN_YEARS = 30;
    static final double MIN_PERCENTAGE_DOWN_PAYMENT = 10;

    /**
     * Validate Business Rules in Request Data
     * @param request
     * @throws Exception
     */
    public void validateBusinessRules(MortagePaymentRequest request) throws Exception {
        if (request.getDownPayment() <= 0) {
            throw  new Exception("Down Payment only numerical and positive values accepted");
        }

        if (request.getPropertyPurchasePrice() <= 0) {
            throw  new Exception("Property Purchase Price only numerical and positive values accepted");
        }

        if (request.getLengthLoan() > MAX_LOAN_YEARS) {
            throw  new Exception("Length Loan cannot be more than "+MAX_LOAN_YEARS+" years");
        }

        if (request.getAnnualInterestRate()  <= 0) {
            throw  new Exception("Annual Interest Rate only numerical and positive values accepted");
        }
        double validDownPayment = (request.getPropertyPurchasePrice() * (MIN_PERCENTAGE_DOWN_PAYMENT / 100));
        if (request.getDownPayment() > validDownPayment) {
            throw new Exception("Down Payment cannot be higher than "+MIN_PERCENTAGE_DOWN_PAYMENT+"% of the property purchase price");
        }
    }

    /**
     * Calculate Mortage Payment value
     * @param request
     * @return
     * @throws Exception
     */
    public MortagePaymentResponse calculateValue(MortagePaymentRequest request) throws Exception {

        this.validateBusinessRules(request);

        double initPayment = request.getDownPayment();
        double housePrice = request.getPropertyPurchasePrice();
        double percentRate = (request.getAnnualInterestRate() / 100);

        int months = MONTHS_YEAR;
        int n = request.getLengthLoan() * months;
        double r = (percentRate / months);
        double P = housePrice - initPayment;

        double M =  P * (( ( Math.pow((r+1), n) ) * r ) / ( (Math.pow(1+r, n)) - 1));

        MortagePaymentResponse mortagePaymentResponse = new MortagePaymentResponse();
        mortagePaymentResponse.setMortagePaymentValue(M);
        return mortagePaymentResponse;
    }

}

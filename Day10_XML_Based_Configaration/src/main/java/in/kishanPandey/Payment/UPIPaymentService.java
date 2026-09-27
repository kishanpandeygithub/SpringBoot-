package in.kishanPandey.Payment;

public class UPIPaymentService implements PaymentService {

    @Override
    public void pay() {
        System.out.println("paying with the UPI");
    }
}

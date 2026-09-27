package in.kishanPandey.Payment;

public class CardPaymentService implements PaymentService{

    @Override
    public void pay() {
        System.out.println("Paying with the card");
    }
}

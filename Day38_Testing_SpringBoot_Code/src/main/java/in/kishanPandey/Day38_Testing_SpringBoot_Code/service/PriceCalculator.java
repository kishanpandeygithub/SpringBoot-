package in.kishanPandey.Day38_Testing_SpringBoot_Code.service;

public class PriceCalculator {
    public  double calculatePrice(double price , double discount){
        if(price<0){
            throw new IllegalArgumentException("Price can not be negative");
        }
        if(discount< 0 || discount>100){
            throw new IllegalArgumentException("Discount should be between 0 ot 100");
        }
        return price-((price*discount)/100);
    }
}

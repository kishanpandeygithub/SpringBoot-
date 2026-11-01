package in.kishanPandey.Day38_Testing_SpringBoot_Code.service;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PriceCalculatorTest {
    private PriceCalculator priceCalculator ;

    @BeforeEach
    void setup(){
        priceCalculator =new PriceCalculator();
    }

//    @AfterEach

    @Test
    void shoudApplyDiscountToPrice(){
        //arrangemt -> initial input
        double price = 1000;
        double discount = 20;
        //act --> action performed
        double actualPrice =
                priceCalculator.calculatePrice(price ,discount);
        //assrtion --> expacted output
        assertEquals(800 , actualPrice);
//        assertTrue();
//        assertFalse();
//        assertNull();
//        assertNotNull();
    }

    @Test
    void shouldRejectDiscountAboveHundred(){
        //arrangemt -> initial input
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class ,
                        ()-> priceCalculator.calculatePrice(1000 , 120));

        assertEquals("Discount should be between 0 ot 100" ,
                exception.getMessage());

    }
}

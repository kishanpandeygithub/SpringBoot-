package in.kishanPandey;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        PaymentService service = new PaymentService();
//        OrderService order =new OrderService(service);
//        order.placeOrder();

        //it say to up the ioc based container using the anotation based configaration and  the rule are met at the AppConfig.class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

//        User user = context.getBean(User.class);
//        System.out.println(user.getName());
//
//        CartService cart = context.getBean(CartService.class);
//        cart.addToCart();
//        PaymentService payment = context.getBean(PaymentService.class);
//        payment.pay();

//
//        CartService cs = new CartService();
//        cs.addToCart();



//        Student s1 =new Student();

        //in the java has a class which name is the class
        //cq1 is not the object is the refrence variable
        //which have the meta deta of the student
        /*
        class Name : Student
        fields: name  ,age and its datatype
        constructor : srudent()
        Mehtods-> getAttandance() , print()
         */
//        Class<Student> c1 = Student.class;
    }
}


//this code is written to understand the reflection api

//class Student {
//    private String name;
//    private int age;
//
//    public Student(){
//
//    }
//    public void getAttandance(){
//
//    }
//    public void Print(){
//
//    }
//}
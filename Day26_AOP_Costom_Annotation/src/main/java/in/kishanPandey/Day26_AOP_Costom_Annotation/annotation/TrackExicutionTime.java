package in.kishanPandey.Day26_AOP_Costom_Annotation.annotation;

import java.lang.annotation.*;
//Marker annotation : is the annotation which has no extra information it is just used for the marking the class

//Configure Annotation : is the annotation which has extra information as well  ,like properties by methods
@Target(ElementType.METHOD)//where the annotation can be used
@Retention(RetentionPolicy.RUNTIME)//default
@Documented
public @interface TrackExicutionTime {
    long warnAfter() default 2000;//anotation declatetion it is also called property

    String operation() default "";
}

package in.kishanPandey.Day25_AOP_PointCut.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {
    @Pointcut("within(in.kishanPandey.Day25_AOP_PointCut.controller..*)")
    public void controllerLayer() {

    }

    @Pointcut("within(in.kishanPandey.Day25_AOP_PointCut.service..*)")
    public void serviceLayer() {

    }

    //all public layer
    @Pointcut("within(in.kishanPandey.Day25_AOP_PointCut..*)")
    public void publicMethod() {
    }

    @Pointcut("serviceLayer() && publicMethod()")
    public void publicServiceMethod(){

    }
}



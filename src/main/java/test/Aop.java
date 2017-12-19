package test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aop {
    @Before("execution(* test.Test.hello())")
    public void before() {
        System.out.println("before");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.hello();
    }
}

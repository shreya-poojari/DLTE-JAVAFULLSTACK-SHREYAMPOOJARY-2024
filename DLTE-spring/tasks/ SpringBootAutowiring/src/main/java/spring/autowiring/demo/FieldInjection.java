package spring.autowiring.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FieldInjection {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        applicationContext.scan("wire.io.autowiring");
        applicationContext.refresh();
        MyBank myBank=applicationContext.getBean(MyBank.class);
        System.out.println(myBank.callFindAll().toString());
    }
}

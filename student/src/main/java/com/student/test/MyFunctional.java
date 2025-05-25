package com.student.test;
@FunctionalInterface
public interface MyFunctional {
    int save(int a,int b);

    default void sum1(){
       System.out.println("Default method....");
   }

    default void sum2(){
        System.out.println("Default method....");
    }
    default void sum3(){
        System.out.println("Default method....");
    }

    static void sum22(){
       System.out.println("Static method....");
   }
    static void sum33(){
        System.out.println("Static method....");
    }
}

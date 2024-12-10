package com.codePractice.lambdas;

public class RunnablelambdaExample {
    public static void main(String[] args) {
/**
 * prior java 8
 */
       Runnable runnable= new Runnable() {

           @Override
           public void run() {
               System.out.println("inside runnable 1");
           }
       };
        new Thread(runnable).start();

        /*
        * java 8 lambda
        */

        //  ()->{};
     Runnable  runnableLambda= ()->{System.out.println("inside runnable 2");};
     new Thread(runnableLambda).start();

//    ******************************************

     new Thread(new Runnable() {

         @Override
         public void run() {
             System.out.println("inside runnable 3.1");
         }
     }).start();

//  **********************************
     new Thread(()->System.out.println("inside runnable 4")).start();
    }
}

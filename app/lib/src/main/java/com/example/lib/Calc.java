package com.example.lib;

public class Calc {

   public int kiranAdd(int a, int b){
        return  a+b;
    }

    public void meerajAdd(int a, int b, MobilePhone phno){
        try {
            Thread.sleep(5000); //i don't know when meeraj will return the result

            phno.afterAdding(a+b);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

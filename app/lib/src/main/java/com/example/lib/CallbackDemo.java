package com.example.lib;

public class CallbackDemo {
    public static void main(String[] args) {
        MeTrainer phnum = new MeTrainer();
        Calc calc = new Calc();
        int kiranResult = calc.kiranAdd(10,20);
        System.out.println("kiran's result is "+kiranResult);

        calc.meerajAdd(30,40,phnum);
    }
}
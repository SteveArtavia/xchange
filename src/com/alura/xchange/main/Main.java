package com.alura.xchange.main;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        CurrencyExchange exchange = new CurrencyExchange();

        Scanner teclado = new Scanner(System.in);

        System.out.println("Type your base currency:");
        String base = teclado.nextLine().toUpperCase();

        System.out.println("Type your target currency:");
        String target = teclado.nextLine().toUpperCase();

        System.out.println("Type an amount:");
        double amount = teclado.nextDouble();
        try{
            exchange.currencyConversion(base, target, amount);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage() + e.getCause());
        }
    }
}
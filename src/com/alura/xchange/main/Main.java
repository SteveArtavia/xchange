package com.alura.xchange.main;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        CurrencyExchange exchange = new CurrencyExchange();
        double amount = 0;

        Scanner teclado = new Scanner(System.in);

        exchange.mostrarMenu();
        boolean ejecutar = true;

        while(ejecutar){
            int opcion = teclado.nextInt();
            if(opcion == 1){
                System.out.println("Elige el monto en Dolares que deseas convertir a Colones:");
                amount = teclado.nextInt();
                exchange.currencyConversion("usd", "crc", amount);
                System.out.println("Deseas realizar otra accion? (SI = 8 | NO = 7)");

            }else if(opcion == 2){
                System.out.println("Elige el monto en Colones que deseas convertir a Dolares:");
                amount = teclado.nextInt();
                exchange.currencyConversion("crc", "usd", amount);
                System.out.println("Deseas realizar otra accion? (SI = 8 | NO = 7)");

            } else if(opcion == 3){
                System.out.println("Elige el monto en Dolares que deseas convertir a Pesos Mexicanos:");
                amount = teclado.nextInt();
                exchange.currencyConversion("usd", "mxn", amount);
                System.out.println("Deseas realizar otra accion? (SI = 8 | NO = 7)");

            } else if(opcion == 4){
                System.out.println("Elige el monto en Pesos Mexicanos que deseas convertir a Dolares:");
                amount = teclado.nextInt();
                exchange.currencyConversion("mxn", "usd", amount);
                System.out.println("Deseas realizar otra accion? (SI = 8 | NO = 7)");

            } else if(opcion == 5){
                System.out.println("Elige el monto en Dolares que deseas convertir a Euros:");
                amount = teclado.nextInt();
                exchange.currencyConversion("usd", "eur", amount);
                System.out.println("Deseas realizar otra accion? (SI = 8 | NO = 7)");

            } else if(opcion == 6){
                System.out.println("Elige el monto en Euros que deseas convertir a Dolares:");
                amount = teclado.nextInt();
                exchange.currencyConversion("eur", "usd", amount);
                System.out.println("Deseas realizar otra accion? (SI = 8 | NO = 7)");

            }else if(opcion == 7){
                System.out.println("Muchas gracias por usar XChange!");
                ejecutar = false;

            } else if(opcion == 8){
                exchange.mostrarMenu();
            }else{
                System.out.println("Ingresa un valor valido");
                exchange.mostrarMenu();
            }
        }
        teclado.close();
    }
}
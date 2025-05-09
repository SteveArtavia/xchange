package com.alura.xchange.main;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class CurrencyExchange {
    String apikey = "bca2ffc251b66cb67937c41e";
    List<Conversion> conversionList = new ArrayList<>();

    public Conversion currencyConversion(String base, String target, double amount){
        String url = "https://v6.exchangerate-api.com/v6/" + apikey + "/pair/"+base+"/"+target+"/"+amount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() != 200){
                throw new RuntimeException("Error: " + response.statusCode());
            } else{

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Conversion conversion = gson.fromJson(response.body(), Conversion.class);

                File file = new File("conversions.json");

                if (file.exists() && file.length() > 0) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        Type listType = new TypeToken<ArrayList<Conversion>>() {}.getType();
                        conversionList = gson.fromJson(reader, listType); // Convertir JSON en lista
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                conversionList.add(conversion);

                try (FileWriter writer = new FileWriter("conversions.json")) {
                    writer.write(gson.toJson(conversionList));
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(base.toUpperCase() + " =>> " + target.toUpperCase());
                System.out.println("Tipo de cambio: " + conversion.conversion_rate());
                System.out.println(base.toUpperCase() + " " + amount + " = " + target.toUpperCase() + " " + conversion.conversion_result());
                return conversion;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarMenu(){
        System.out.println("""
                ****************************************************************
                Sea bienvenido/a a XChange tu Conversor de Monedas
                Elije la accion que deseas realizar:
                
                1) Dolar =>> Colon Costarricense
                2) Colon Costarricense =>> Dolar
                3) Dolar =>> Peso Mexicano
                4) Peso Mexicano =>> Dolar
                5) Dolar =>> Euro
                6) Euro =>> Dolar
                7) Salir
                 
                ****************************************************************
                """);
    }
}

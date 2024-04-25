package desafio.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import desafio.exception.InvalidJsonException;
import desafio.model.CurrencyConversionRate;
import desafio.model.CurrencyType;

public class JsonConverter {
    public static double getConversionRate(String json, CurrencyType currencyType) {
        try {
            validateJson(json);
        } catch (InvalidJsonException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando programa...");
            System.exit(0);
        }
        Gson gson = new GsonBuilder().create();

        CurrencyConversionRate response = gson.fromJson(json, CurrencyConversionRate.class);

        String currencyCode = currencyType.name();
        return response.getConversionRate(currencyCode);
    }

    private static void validateJson(String body) throws InvalidJsonException {
        if (!body.contains("conversion_rates")) {
            throw new InvalidJsonException();
        }
    }
}

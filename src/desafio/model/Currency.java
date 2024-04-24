package desafio.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import desafio.exception.InvalidJsonException;

import java.util.Map;

public class Currency {
    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRate;

    public double getConversionRate(String currencyCode) {
        return conversionRate.get(currencyCode);
    }

    public static double getConversionRate(String json, CurrencyType currencyType) {
        try {
            validateJson(json);
        } catch (InvalidJsonException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando programa...");
            System.exit(0);
        }
        Gson gson = new GsonBuilder().create();

        Currency response = gson.fromJson(json, Currency.class);

        String currencyCode = currencyType.name();
        return response.getConversionRate(currencyCode);
    }

    private static void validateJson(String body) throws InvalidJsonException {
        if (!body.contains("conversion_rates")) {
            throw new InvalidJsonException();
        }
    }
}

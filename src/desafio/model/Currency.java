package desafio.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Currency {
    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRate;

    public double getConversionRate(String currencyCode) {
        return conversionRate.get(currencyCode);
    }

    public static double getConversionRate(String body, CurrencyType currencyType) throws ClassNotFoundException {
        validateBody(body);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Currency response = gson.fromJson(body, Currency.class);

        String currencyCode = currencyType.name();
        return response.getConversionRate(currencyCode);
    }

    private static void validateBody(String body) throws ClassNotFoundException {
        if (!body.contains("conversion_rates")) {
            throw new ClassNotFoundException();
        }
    }
}

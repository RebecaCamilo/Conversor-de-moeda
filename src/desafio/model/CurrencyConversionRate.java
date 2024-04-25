package desafio.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import desafio.exception.InvalidJsonException;

import java.util.Map;

public class CurrencyConversionRate {
    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRate;

    public double getConversionRate(String currencyCode) {
        return conversionRate.get(currencyCode);
    }

}

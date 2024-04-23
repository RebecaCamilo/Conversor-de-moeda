package desafio;

import java.util.Map;

class Moeda {
    private Map<String, Double> conversionRates;

    public double getConversionRate(String currencyCode) {
        return conversionRates.get(currencyCode);
    }
}


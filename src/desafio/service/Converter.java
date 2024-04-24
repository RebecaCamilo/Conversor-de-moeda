package desafio.service;

import desafio.model.CurrencyType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Converter {

    public static double getConversionValue(Scanner sc, String baseCurrency, String finalCurrency) {
        System.out.println("Quantos " + baseCurrency + " gostaria de converter para " + finalCurrency + "?" );
        try {
            return sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Finalizando programa...");
            System.exit(0);
        }
        return 0.0;
    }

    public static double covert(Scanner sc, double rate, CurrencyType baseCurrency, CurrencyType finalCurrency) {
        var value = getConversionValue(sc, baseCurrency.getDescription(), finalCurrency.getDescription());
        return (value * rate);
    }
}

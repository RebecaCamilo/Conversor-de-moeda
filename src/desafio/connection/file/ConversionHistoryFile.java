package desafio.connection.file;

import desafio.model.ConversionHistoryItem;

import java.io.FileWriter;
import java.io.IOException;

public class ConversionHistoryFile {

    public static void save(double baseValue, String baseCurrency, double convertedValue, String finalCurrency) {
        String nomeArquivo = "CurrencyConversionHistory.txt";
        ConversionHistoryItem item = new ConversionHistoryItem(baseValue, baseCurrency, convertedValue, finalCurrency);

        FileWriter escrita = null;
        try {
            escrita = new FileWriter(nomeArquivo, true);
            String itemToSave = item.toString();

            escrita.write(itemToSave);
            escrita.write("\n");
            System.out.println("Dados da conversão foram adicionados ao arquivo " + nomeArquivo + " com sucesso!");
        } catch (IOException e) {
            System.out.println("Dados da conversão não foram adicionados ao arquivo " + nomeArquivo + "!");
        } finally {
            if (escrita != null) {
                try {
                    escrita.close();
                } catch (IOException e) {
                    System.out.println("FileWriter pode ser finalizado.");
                }
            }
        }
//
//
//        FileWriter escrita = new FileWriter("filmes.txt");
//        escrita.write(gson.toJson(titulos));
//        escrita.close();
//
//        System.out.println("O programa finalizou corretamente!");
    }

}

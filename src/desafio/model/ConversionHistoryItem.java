package desafio.model;

import java.time.LocalDateTime;

public class ConversionHistoryItem {

     private LocalDateTime date;
     private double baseValue;
     private String baseCurrency;
     private double finalValue;
     private String finalCurrency;

     public ConversionHistoryItem(double baseValue, String baseCurrency, double finalValue, String finalCurrency) {
          this.date = LocalDateTime.now();
          this.baseValue = baseValue;
          this.baseCurrency = baseCurrency;
          this.finalValue = finalValue;
          this.finalCurrency = finalCurrency;
     }

     @Override
     public String toString() {
          return "[" + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear() + " " +
                  date.getHour() + ":" + date.getMinute() + "] " +
                  baseValue + " " + baseCurrency + " -> " + finalValue + " " + finalCurrency;
     }
}

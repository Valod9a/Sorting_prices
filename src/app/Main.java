package app;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    static int count;
    static double[] prices;

    public static void main(String[] args) {

        outputUnsorted(input());
        outputSortedWithAVG(sortingPrices(prices));
    }
    public static double[] input(){

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        System.out.println("Enter amount of days: ");
        int days = sc.nextInt();

        prices = new double[days];

        System.out.println("Enter " + days + " prices for each day: ");
        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextDouble();
        }
        sc.close();
        return prices;
    }
    public static double[] sortingPrices(double[] sortedPrices) {
        for (int i = 0; i < sortedPrices.length; i++) {
            for (int j = 1; j < (sortedPrices.length - i); j++) {
                if (sortedPrices[j - 1] > sortedPrices[j]) {

                    double temp = sortedPrices[j - 1];
                    sortedPrices[j - 1] = sortedPrices[j];
                    sortedPrices[j] = temp;
                }
            }
        }
        return sortedPrices;
    }
    public static double averagePrice() {
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }
    public static void outputUnsorted(double[] prices){
        count = 1;
        System.out.println("\nUnsorted prices:");
        for (double price : prices ) {
            System.out.println(count + ") " + price + " EUR.");
            count++;
        }
    }
    public static void outputSortedWithAVG(double[] sortedPrices){
        count = 1;
        System.out.println("\nSorted prices:");
        for (double price : sortedPrices ) {
            System.out.println(count + ") " + price + " EUR.");
            count++;
        }
        System.out.printf("%nAverage price: %.2f EUR. ", averagePrice());
    }
}

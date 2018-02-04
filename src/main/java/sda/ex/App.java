package sda.ex;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        IMachine vendingMachine = new VendingMachine();

        //================== List of products & codes=======================
        Map<String, Dispenser> choicesMap = vendingMachine.getContainer().getStock();
        for (String key : choicesMap.keySet()) {
            Product product = choicesMap.get(key).getProduct();
            System.out.println(key + " " + product.getName() + " " + formatNumber(product.getPrice()));
        }
        //===========================================================================

        System.out.println("Chose product");
        String choice = reader.readLine();
        vendingMachine.readChoice(choice);
        int productPrice = vendingMachine.getPaymentAmount();
        System.out.println("Price to pay: " + formatNumber(productPrice));

        System.out.println("Pay for product");
        boolean paid = false;
        while (!paid) {
            String coin = reader.readLine();
            int amount = Integer.parseInt(coin);
            vendingMachine.insertCoin(getCoin(coin));
            paid = vendingMachine.isEnough();
        }
        System.out.println("Wydano product");

        vendingMachine.prepareRest();




        //TODO: wydanie reszty
    }

    private static Coins getCoin(String coin) {
        //TODO: implementation for all coins
        return Coins.TWENTY_GR;
    }

    private static String formatNumber(int number) {
        return String.format("%.2f zł", (double) number / 100);
    }
}

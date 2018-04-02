package sda.ex;


import sda.ex.machine.IMachine;
import sda.ex.machine.VendingMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
        System.out.println("Give out product");

        vendingMachine.prepareRest();


        //TODO: give the change
    }

    private static Coins getCoin(String coin) {
        //TODO: implementation for all coins

        Map<String, Coins> temp = new HashMap<>();
        temp.put("1", Coins.ONE_GR);
        temp.put("2", Coins.TWO_GR);
        temp.put("5", Coins.FIVE_GR);
        temp.put("10", Coins.TEN_GR);
        temp.put("20", Coins.TWENTY_GR);
        temp.put("50", Coins.FIFTY_GR);
        temp.put("100", Coins.ONE_PLN);
        temp.put("200", Coins.TWO_PLN);
        temp.put("500", Coins.FIVE_PLN);
        temp.put("1000", Coins.TEN_PLN);
        temp.put("2000", Coins.TWENTY_PLN);
        temp.put("5000", Coins.FIFTY_PLN);
        temp.put("10000", Coins.HUNDRED_PLN);
        temp.put("20000", Coins.TWO_HUNDRED_PLN);
        temp.put("50000", Coins.FIVE_HUNDRED_PLN);


//        for (HashMap<String, Coins> t : temp) {
//
//        }


//        return Coins.values()[Integer.parseInt(coin)];
        return Coins.TWENTY_GR;
    }

    private static String formatNumber(int number) {
        return String.format("%.2f zł", (double) number / 100);
    }
}

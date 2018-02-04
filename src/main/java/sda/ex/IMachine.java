package sda.ex;

import java.util.Map;

public interface IMachine {
    void readChoice(String choice);

    IContainer getContainer();

    int getPaymentAmount();

    void insertCoin(Coins coin);

    boolean isEnough();

    Map<Coins, Integer> prepareRest();
}

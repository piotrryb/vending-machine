package sda.ex;

import java.util.Map;

public interface IWallet {
    Map<Coins, Integer> getRest(int amount, int productPrice);
}

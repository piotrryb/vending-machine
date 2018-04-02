package sda.ex.wallet;

import sda.ex.Coins;

import java.util.Map;

public interface IWallet {
    Map<Coins, Integer> getRest(int amount, int productPrice);
}

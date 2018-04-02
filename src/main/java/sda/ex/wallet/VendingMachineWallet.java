package sda.ex.wallet;

import sda.ex.Coins;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineWallet implements IWallet {
    Map<Coins, Integer> vault;

    public VendingMachineWallet() {
        this.vault = createVault();
    }

    private Map<Coins, Integer> createVault() {
        Map<Coins,Integer> temp = new HashMap<>();
        temp.put(Coins.ONE_GR, 20);
        temp.put(Coins.TWENTY_GR, 10);
        temp.put(Coins.ONE_PLN, 30);
        return temp;
    }

    @Override
    public Map<Coins, Integer> getRest(int amount, int productPrice) {
        return null;
    }
}

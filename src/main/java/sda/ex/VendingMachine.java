package sda.ex;

import java.util.Map;

public class VendingMachine implements IMachine {

    private String choice;

    private IContainer container;

    private int money = 0;

    public VendingMachine() {
        container = new VendingMachineContainer();
    }

    @Override
    public void readChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public IContainer getContainer() {
        return container;
    }

    @Override
    public int getPaymentAmount() {
        return container.getStock().get(choice).getProduct().getPrice();
    }

    @Override
    public void insertCoin(Coins coin) {
        this.money += coin.getCents();
    }

    @Override
    public boolean isEnough() {
        return this.money >= getPaymentAmount();
    }

    @Override
    public Map<Coins, Integer> prepareRest() {
        IWallet wallet = new VendingMachineWallet();
        return null;
    }
}

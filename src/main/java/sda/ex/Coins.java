package sda.ex;

public enum Coins {
    ONE_GR(1), TWO_GR(2), FIVE_GR(5), TEN_GR(10), TWENTY_GR(20), FIFTY_GR(50), ONE_PLN(100),
    TWO_PLN(200), FIVE_PLN(500), TEN_PLN(1000), TWENTY_PLN(2000), FIFTY_PLN(5000),
    HUNDRED_PLN(10000), TWO_HUNDRED_PLN(20000), FIVE_HUNDRED_PLN(50000);

    int cents;

    Coins(int cents) {
        this.cents = cents;
    }

    public int getCents() {
        return this.cents;
    }
}

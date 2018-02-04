package sda.ex;

import java.util.Map;

public interface IContainer {
    int getPriceOfProduct(String id);

    Map<String, Dispenser> getStock();
}

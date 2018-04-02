package sda.ex.container;

import sda.ex.Dispenser;
import java.util.Map;

public interface IContainer {

    int getPriceOfProduct(String id);

    Map<String, Dispenser> getStock();
}

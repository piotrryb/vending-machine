package sda.ex;

import java.util.LinkedHashMap;
import java.util.Map;

public class VendingMachineContainer implements IContainer {

    Map<String, Dispenser> stock;

    public VendingMachineContainer() {
        this.stock = createStock();
    }

    private Map<String, Dispenser> createStock() {
        Map<String, Dispenser> stockMap = new LinkedHashMap<>();
        stockMap.put("4F", new Dispenser(new Product("Coca cola", 250, ProductType.DRINK), 10));
        stockMap.put("22", new Dispenser(new Product("Coca cola light", 300, ProductType.DRINK), 10));
        stockMap.put("5A", new Dispenser(new Product("Sprite", 250, ProductType.DRINK), 10));
        stockMap.put("3D", new Dispenser(new Product("Fanta", 250, ProductType.DRINK), 10));
        stockMap.put("31", new Dispenser(new Product("Snickers", 230, ProductType.SWEET), 10));
        stockMap.put("1B", new Dispenser(new Product("Mars", 200, ProductType.SWEET), 10));
        return stockMap;
    }

    @Override
    public int getPriceOfProduct(String id) {
        return stock.get(id).getProduct().getPrice();
    }

    @Override
    public Map<String, Dispenser> getStock() {
        return stock;
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }
    
    public void add(Product ci) {
        for (Product product : items) {
            if (ci.getId() == product.getId()) {
                product.setNumber(product.getNumber() + 1);
                return;
            }    
        }
        items.add(ci);
    }

    public void remove(int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                items.remove(product);
                return;
            }
        }
    }

    public double getAmount() {
        double s = 0;
        for (Product product : items) {
            s += product.getPrice() * product.getNumber();
        }

        return Math.round(s * 100.0) / 100.0;
    }

    public List<Product> getItems() {
        return items;
    }
}

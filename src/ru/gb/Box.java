package ru.gb;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> box = new ArrayList();


    public float getWeight() {
        float weight = 0.0f;
        for (T o : box) {
            weight += o.getWeight();
        }
        return weight;
    }

    public boolean compare(Box another) {
        if (getWeight() == another.getWeight()) {
            return true;
        }
        return false;
    }

    public void putTo(Box<T> another) {
        another.box.addAll(box);
        box.clear();
    }

    public void addFruit(T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            box.add(fruit);
        }
    }
}

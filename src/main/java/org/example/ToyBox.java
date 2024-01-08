package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyBox {

    private List<Toy> toys = new ArrayList<>();
    private Random random = new Random();

    public void putToy(Toy toy) {
        toys.add(toy);
    }
    public Toy getPrizeToy() {
        if (!toys.isEmpty()) {
            int totalProbability = toys.stream().mapToInt(Toy::getProbability).sum();
            int value = random.nextInt(totalProbability);
            for (Toy toy : toys) {
                value -= toy.getProbability();
                if (value <= 0) {
                    toys.remove(toy);
                    return toy;
                }
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Toy toy : toys) {
            result.append(toy).append("\n");
        }
        return result.toString();
    }
}
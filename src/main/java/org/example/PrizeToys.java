package org.example;

import java.util.Queue;
import java.util.LinkedList;

public class PrizeToys {

    Queue<Toy> toyQueue = new LinkedList<>();

    public void addToQueue(Toy prizeToy) {
        toyQueue.add(prizeToy);
    }

    public Toy getToyFromQueue() {
        if (toyQueue.isEmpty()) {
            return null;
        }
        return toyQueue.poll();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Toy toy : toyQueue) {
            result.append(toy).append("\n");
        }
        return result.toString();
    }
}
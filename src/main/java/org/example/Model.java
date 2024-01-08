package org.example;

public class Model {
    private ToyBox currentToyBox;
    private PrizeToys prizeBoxQueue;

    public Model() {
        currentToyBox = new ToyBox();
        prizeBoxQueue = new PrizeToys();
    }

    public ToyBox getCurrentToyBox() {
        return this.currentToyBox;
    }

    public PrizeToys getPrizeBoxQueue() {
        return this.prizeBoxQueue;
    }
}
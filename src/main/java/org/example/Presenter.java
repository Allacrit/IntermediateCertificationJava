package org.example;

public class Presenter {

    private Model model;
    private ConsoleView view;

    public Presenter(ConsoleView view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void addToy() {
        view.consoleClear();
        model.getCurrentToyBox()
                .putToy(new Toy(view.getToyName(),
                        view.getToyProbability()));
        view.showSuccessAddinMess();
        view.userWaiting();
    }

    public void getPrizeToy() {
        view.consoleClear();
        Toy prizeToy = model.getCurrentToyBox().getPrizeToy();
        if (prizeToy == null) {
            view.showEmptyBoxMess();
            view.userWaiting();
        } else {
            view.showSuccessDrawingMess();
            view.display(prizeToy.toString());
            model.getPrizeBoxQueue().addToQueue(prizeToy);
            view.showAddinToPrizeBoxMess();
            view.userWaiting();
        }
    }

    public void getPrizeToyFromQueue() {
        view.consoleClear();
        Toy prizeToy = model.getPrizeBoxQueue().getToyFromQueue();
        if (prizeToy == null) {
            view.showEmptyQueueMess();
            view.userWaiting();
        } else {
            view.showPrizeToyMess();
            view.display(prizeToy.toString());
            view.display(prizeToy.exportToFile());
            view.userWaiting();
        }
    }


    public void exitApp() {
        view.consoleClear();
        view.showGoobyeMess();
    }

    public void unknownCommand() {
        view.consoleClear();
        view.showUnknownCommMess();
        view.userWaiting();
    }

    public String showMenu() {
        view.consoleClear();
        return view.showMenu();
    }

    public void printToysFromBox() {
        view.consoleClear();
        view.display(model.getCurrentToyBox().toString());
        view.userWaiting();
    }

    public void printPrizeToys() {
        view.consoleClear();
        view.display(model.getPrizeBoxQueue().toString());
        view.userWaiting();
    }
}
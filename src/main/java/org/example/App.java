package org.example;

public class App {

    static ConsoleView view = new ConsoleView();
    static Model model = new Model();
    static Presenter presenter = new Presenter(view, model);


    public static void startButtonClick() {

        boolean runStatus = true;

        while (runStatus) {
            String userChoice = presenter.showMenu();

            switch (userChoice) {
                case "1" -> presenter.addToy();
                case "2" -> presenter.printToysFromBox();
                case "3" -> presenter.getPrizeToy();
                case "4" -> presenter.printPrizeToys();
                case "5" -> presenter.getPrizeToyFromQueue();
                case "0" -> {
                    runStatus = false;
                    presenter.exitApp();
                }
                default -> presenter.unknownCommand();
            }

        }

    }

}
package ua.training;

import ua.training.controller.Controller;
import ua.training.model.entity.SaladImpl;
import ua.training.view.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new SaladImpl(), new View());

        controller.processUser();
    }

}

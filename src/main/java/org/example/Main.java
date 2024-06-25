package org.example;

import org.example.controller.MainController;
import org.example.model.Client;
import org.example.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Doe", "John", "0123456789");
        ConsoleView view = new ConsoleView();
        MainController controller = new MainController(client, view);
        controller.demarrerApplication();
    }
}

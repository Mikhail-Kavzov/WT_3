package by.bsuir.lab03.server.main;

import by.bsuir.lab03.server.service.ServerLogic;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerLogic serverLogic = new ServerLogic();
        serverLogic.startConnection();
    }

}

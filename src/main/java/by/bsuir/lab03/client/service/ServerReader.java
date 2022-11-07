package by.bsuir.lab03.client.service;

import by.bsuir.lab03.client.clientPanel.CommandPrinter;

import java.io.IOException;

public class ServerReader extends Thread {
    Client client;
    String data;
    CommandPrinter commandPrinter;
    ClientLogic clientLogic;

    public ServerReader(Client client, ClientLogic clientLogic) {
        this.clientLogic = clientLogic;
        this.client = client;
        data = "";
        commandPrinter = new CommandPrinter();
    }

    public void run() {
        try {
            while (!data.equals("STOP")) {
                data = client.getData();
                commandPrinter.print(data);
            }
            client.sendCommand("STOP");
            client.close();
            clientLogic.setNonEnable();
            commandPrinter.print("Break with the server" + System.lineSeparator() +
                    "Enter any character");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

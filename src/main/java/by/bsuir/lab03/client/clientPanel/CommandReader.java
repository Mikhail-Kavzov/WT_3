package by.bsuir.lab03.client.clientPanel;

import java.util.Scanner;

public class CommandReader {
    Scanner scan;
    public CommandReader(){
        scan = new Scanner(System.in);
    }
    public String getCommand(){
        return scan.nextLine();
    }
}

package br.com.aula.compasso;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //boolean var that keep the menu's loop.
        boolean menu = true;
        Scanner scanner = new Scanner(System.in);
        Phrase phrase = new Phrase();

        do {
            System.out.println("\n=========( Welcome )=========\n" +
                    "      SELECT AN OPTION:      \n" +
                    "1 -> Input Phrase\n" +
                    "0 -> Exit\n" +
                    "==============()==============\n");

            String inputMenu = scanner.nextLine();

            switch (inputMenu){

                case "1":

                    System.out.println("Type your phrase: ");
                    String inputPhrase = scanner.nextLine();
                    phrase.validation(inputPhrase);
                    break;

                case "0":

                    //If the exit option is selected, the exit message is displayed and menu's loop end.
                    System.out.println("\nExiting Option Selected\nExiting Program!!!");
                    menu = !menu;
                    break;

                default:

                    //If an invalid option is selected, the error message is displayed.
                    System.out.println("\nInvalid Option");
            }

        } while (menu);
    }
}
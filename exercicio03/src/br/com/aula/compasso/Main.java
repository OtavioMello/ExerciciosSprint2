package br.com.aula.compasso;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //boolean var that keep the menu's loop.
        boolean menu = true;
        Scanner scanner = new Scanner(System.in);

        //Creating a Phrase reference to get class methods.
        Phrase phrase = new Phrase();

        do {
            System.out.println("\n=========( Welcome )=========\n" +
                    "      SELECT AN OPTION:      \n" +
                    "1 -> Input Phrase\n" +
                    "0 -> Exit\n" +
                    "==============()==============\n");

            //Getting the menu option.
            String inputMenu = scanner.nextLine();

            switch (inputMenu){

                case "1":

                    //Getting the user input.
                    System.out.println("Type your phrase: ");
                    String inputPhrase = scanner.nextLine();

                    //Validating the inputPhrase using the validation() method.
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
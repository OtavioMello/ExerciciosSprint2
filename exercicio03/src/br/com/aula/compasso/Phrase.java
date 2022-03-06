package br.com.aula.compasso;

public class Phrase {

    private String happyFace = ":-)";
    private String sadFace = ":-(";

    //Method validation, thar will get the inputPhrase as an argument.
    public void validation(String inputPhrase){

        int happyFaceCount = 0;
        int sadFaceCount = 0;

        //For which will loop thought the entire string and pass the index to the substring() method,
        //that will slice the string from the index to end. The startsWith() method will check if,
        // from the current index to the end, there is a string corresponding to the comparison attribute,
        // if there is, it returns true the counter++.
        for (int i = 0; i < inputPhrase.length(); i++) {
            if(inputPhrase.substring(i).startsWith(happyFace)){
                happyFaceCount++;
            }else if(inputPhrase.substring(i).startsWith(sadFace)){
                sadFaceCount++;
            }
        }

        //If that compares the values of the counters.
        if(happyFaceCount > sadFaceCount){
            System.out.println("\n==============================\n" +
                    "Output: Feliz :D\n" +
                    "==============================\n");
        }else if(happyFaceCount == sadFaceCount){
            System.out.println("\n==============================\n" +
                    "Output: Neutro :|\n" +
                    "==============================\n");
        }else {
            System.out.println("\n==============================\n" +
                    "Output: Chateado ;-;\n" +
                    "==============================\n");
        }
    }
}

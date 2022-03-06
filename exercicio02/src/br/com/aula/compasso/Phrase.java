package br.com.aula.compasso;

public class Phrase {

    private String happyFace = ":-)";
    private String sadFace = ":-(";


    public void validation(String string){

        int happyFaceCount = 0;
        int sadFaceCount = 0;

        for (int i = 0; i < string.length(); i++) {
            if(string.substring(i).startsWith(happyFace)){
                happyFaceCount++;
            }else if(string.substring(i).startsWith(sadFace)){
                sadFaceCount++;
            }
        }

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

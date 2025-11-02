import java.util.HashMap;
import java.util.Map;

public class numberToWords {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(convert(999));
    }


    public static StringBuilder convert(int number) {
        StringBuilder convertedNumber = new StringBuilder();

        Map<Integer, String> map = new HashMap<>();

        // 0 - 16
        map.put(0, "zéro");
        map.put(1, "un");
        map.put(2, "deux");
        map.put(3, "trois");
        map.put(4, "quatre");
        map.put(5, "cinq");
        map.put(6, "six");
        map.put(7, "sept");
        map.put(8, "huit");
        map.put(9, "neuf");
        map.put(10, "dix");
        map.put(11, "onze");
        map.put(12, "douze");
        map.put(13, "treize");
        map.put(14, "quatorze");
        map.put(15, "quinze");
        map.put(16, "seize");

        // dizaines "simples"
        map.put(20, "vingt");
        map.put(30, "trente");
        map.put(40, "quarante");
        map.put(50, "cinquante");
        map.put(60, "soixante");

        // cas français particuliers
        map.put(70, "soixante-dix");      // 60 + 10
        map.put(80, "quatre-vingts");     // 4 x 20
        map.put(90, "quatre-vingt-dix");  // 80 + 10

        // tu peux ajouter quelques composés fréquents
        map.put(21, "vingt et un");
        map.put(31, "trente et un");
        map.put(41, "quarante et un");
        map.put(51, "cinquante et un");
        map.put(61, "soixante et un");
        map.put(71, "soixante et onze");
        map.put(81, "quatre-vingt-un");      // pas de “et”
        map.put(91, "quatre-vingt-onze");

        // borne haute
        map.put(100, "cent");


        if ( number <=16) {
            // Nombre inférieur à 16, le nombre est directement dans la hashmap
            convertedNumber.append(map.get(number));

        } else if (number < 100) {
            // Nombre inférieur a 100, on prend d'abord le chiffre des dizaines puis le dernier chiffre
            convertedNumber.append(map.get((number/10) *10));
            convertedNumber.append(map.get(number%10));


        } else if (number%100 > 10 && number%100 <=16) {
            convertedNumber.append(map.get((number/100) *100));
            convertedNumber.append(map.get(number%100));
        } else if (number%100 > 16){
            if(number/100 == 1) {
                convertedNumber.append(map.get((number/100) *100));
            } else {
                convertedNumber.append(map.get((number/100)));
                convertedNumber.append(map.get(100));
            }
            if ((number % 100) % 10 == 0){
                convertedNumber.append(map.get(number % 100));
            } else if ((number % 100) % 10 == 1){
                convertedNumber.append(map.get(number % 100));

            } else {
                convertedNumber.append(map.get(number%10 *10));
                convertedNumber.append(map.get(number%10));

            }

        }


        return convertedNumber;
    }
}

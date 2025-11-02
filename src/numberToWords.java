import java.util.HashMap;
import java.util.Map;

public class numberToWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert(111));
	}
	
	public static int[] intToDigits(int n) {
	    String s = String.valueOf(n);       
	    int[] digits = new int[s.length()];

	    for (int i = 0; i < s.length(); i++) {
	        digits[i] = s.charAt(i) - '0';  
	    }
	    return digits;
	}
	
	public static String convert(int number) {
		String convertedNumber = "";
		
	    int[] digits = intToDigits(number);
	    
	  
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
	        
	        
	        switch(number) {
	        	case 10:
	        	case 11:
	        	case 12:
	        	case 13:
	        	case 14:
	        	case 15:
	        	case 16:
	        	case 20:
	        	case 30:
	        	case 40:
	        	case 50:
	        	case 60:
	        	case 70:
	        	case 80:
	        	case 90:
	        		convertedNumber = map.get(number);
	        		break;
	        	default:
		        		        
			        if(digits.length<=1) {
			        	convertedNumber = map.get(number);		        
			        } else if (digits.length==2) {
			        	convertedNumber  = map.get(digits[0]*10);
			        	convertedNumber += "-" + map.get(digits[digits.length-1]);
			        	
			        } else if (digits.length>2) {				        	
			        	if(digits[0] != 1) convertedNumber  += map.get(digits[0]);
			        	convertedNumber  += "cent";
			        	convertedNumber  += map.get(digits[1]*10);
			        	
			        	String s = String.valueOf(digits[1] + digits[2]); // "1234"
			        	int result = Integer.parseInt(s); // 1234
			        	
			        	switch (result){
			        		case 10:
				        	case 11:
				        	case 12:
				        	case 13:
				        	case 14:
				        	case 15:
				        	case 16:
				        		
				        		
			        	}
			        	if (digits[digits.length-1] != 0) convertedNumber  += "-" + map.get(digits[digits.length-1]);
			        }
				    
	        }
	        
	        
	        
		return convertedNumber;
	}
}

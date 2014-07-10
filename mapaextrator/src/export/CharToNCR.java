package export;


public class CharToNCR {

	public static String escapeUnicodeString(String str, boolean escapeAscii) {
	String ostr = new String();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if (!escapeAscii && ((ch >= 0x0020) && (ch <= 0x007e)))
				ostr += ch ;
			else {
				ostr+="&#";
				String hex = Integer.toString(str.charAt(i) & 0xFFFF);
				if (hex.length() == 2)
					ostr += "00" ;
				ostr+=hex;
			}
			ostr+=";";
		}
	return (ostr);
	}
	
	public static String getTreatedString(String stringToTreat){
	  String valuedString [][] = 
	  {
	  {"ç",CharToNCR.escapeUnicodeString("ç",true)},
	  {"Ç",CharToNCR.escapeUnicodeString("Ç",true)},
	  {"á",CharToNCR.escapeUnicodeString("á",true)},
	  {"é",CharToNCR.escapeUnicodeString("é",true)},
	  {"í",CharToNCR.escapeUnicodeString("í",true)},
	  {"ó",CharToNCR.escapeUnicodeString("ó",true)},
	  {"ú",CharToNCR.escapeUnicodeString("ú",true)},
	  {"ý",CharToNCR.escapeUnicodeString("ý",true)},
	  {"Á",CharToNCR.escapeUnicodeString("Á",true)},
	  {"É",CharToNCR.escapeUnicodeString("É",true)},
	  {"Í",CharToNCR.escapeUnicodeString("Í",true)},
	  {"Ó",CharToNCR.escapeUnicodeString("Ó",true)},
	  {"Ú",CharToNCR.escapeUnicodeString("Ú",true)},
	  {"Ý",CharToNCR.escapeUnicodeString("Ý",true)},
	  {"à",CharToNCR.escapeUnicodeString("à",true)},
	  {"è",CharToNCR.escapeUnicodeString("è",true)},
	  {"ì",CharToNCR.escapeUnicodeString("ì",true)},
	  {"ò",CharToNCR.escapeUnicodeString("ò",true)},
	  {"ù",CharToNCR.escapeUnicodeString("ù",true)},
	  {"À",CharToNCR.escapeUnicodeString("À",true)},
	  {"È",CharToNCR.escapeUnicodeString("È",true)},
	  {"Ì",CharToNCR.escapeUnicodeString("Ì",true)},
	  {"Ò",CharToNCR.escapeUnicodeString("Ò",true)},
	  {"Ù",CharToNCR.escapeUnicodeString("Ù",true)},
	  {"ã",CharToNCR.escapeUnicodeString("ã",true)},
	  {"õ",CharToNCR.escapeUnicodeString("õ",true)},
	  {"ñ",CharToNCR.escapeUnicodeString("ñ",true)},
	  {"ä",CharToNCR.escapeUnicodeString("ä",true)},
	  {"ë",CharToNCR.escapeUnicodeString("ë",true)},
	  {"ï",CharToNCR.escapeUnicodeString("ï",true)},
	  {"ö",CharToNCR.escapeUnicodeString("ö",true)},
	  {"ü",CharToNCR.escapeUnicodeString("ü",true)},
	  {"ÿ",CharToNCR.escapeUnicodeString("ÿ",true)},
	  {"Ä",CharToNCR.escapeUnicodeString("Ä",true)},
	  {"Ë",CharToNCR.escapeUnicodeString("Ë",true)},
	  {"Ï",CharToNCR.escapeUnicodeString("Ï",true)},
	  {"Ö",CharToNCR.escapeUnicodeString("Ö",true)},
	  {"Ü",CharToNCR.escapeUnicodeString("Ü",true)},
	  {"Ã",CharToNCR.escapeUnicodeString("Ã",true)},
	  {"Õ",CharToNCR.escapeUnicodeString("Õ",true)},
	  {"Ñ",CharToNCR.escapeUnicodeString("Ñ",true)},
	  {"â",CharToNCR.escapeUnicodeString("â",true)},
	  {"ê",CharToNCR.escapeUnicodeString("ê",true)},
	  {"î",CharToNCR.escapeUnicodeString("î",true)},
	  {"ô",CharToNCR.escapeUnicodeString("ô",true)},
	  {"û",CharToNCR.escapeUnicodeString("û",true)},
	  {"Â",CharToNCR.escapeUnicodeString("Â",true)},
	  {"Ê",CharToNCR.escapeUnicodeString("Ê",true)},
	  {"Î",CharToNCR.escapeUnicodeString("Î",true)},
	  {"Ô",CharToNCR.escapeUnicodeString("Ô",true)},
	  {"Û",CharToNCR.escapeUnicodeString("Û",true)}};
	  
	  for (int i = 0 ; i < valuedString.length; i++){
		  stringToTreat = stringToTreat.replaceAll(valuedString[i][0], valuedString[i][1]);
	  }
		return stringToTreat;
	}
	
}

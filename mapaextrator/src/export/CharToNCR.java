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
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)},
	  {"�",CharToNCR.escapeUnicodeString("�",true)}};
	  
	  for (int i = 0 ; i < valuedString.length; i++){
		  stringToTreat = stringToTreat.replaceAll(valuedString[i][0], valuedString[i][1]);
	  }
		return stringToTreat;
	}
	
}

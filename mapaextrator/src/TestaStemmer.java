// http://www.wordwaldo.com/ending-with/izational

public class TestaStemmer extends MapaStemmer {

  public String stem(String str) {

    if (str.length() <= 2) {
      return str;
    }
    String stemmed = super.stem(str);
    while (!stemmed.equals(str)) {
      str = stemmed;
      stemmed = super.stem(stemmed);
    }
    return stemmed;
  }

  public static void main(String[] ops) {

	  TestaStemmer ts = new TestaStemmer();


    try {
        System.out.print(ts.stem("essencialmente"));
    	
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
    


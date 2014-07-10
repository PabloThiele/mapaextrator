
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if ( "Fee".matches( "Unisinos|Feevale|Ufrgs" ) ) {
			System.out.println( "ok" );
		} else {
			System.out.println( "não ok");
		}

	}

}

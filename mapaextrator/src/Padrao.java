import java.util.Vector;

import javax.swing.JOptionPane;


public class Padrao {
	
	String [] padraoDeBusca;
	
	String [] padraoGerado1;
	String [] padraoGerado2;
	String [] padraoGerado3;

	String [] triadeGerada1 = new String [3];
	String [] triadeGerada2 = new String [3];
	String [] triadeGerada3 = new String [3];
	
	String [] coringas;
	
	String coringaArmazenado = "?";
	
	public Padrao( String [] padraoDeBusca ) {
		this.padraoDeBusca = padraoDeBusca;
		this.coringaArmazenado = "?";
	}

	public Padrao( String [] padraoDeBusca, String [] padraoGerado1, String [] padraoGerado2, String [] padraoGerado3 ) {
		this.padraoDeBusca = padraoDeBusca;
		this.padraoGerado1 = padraoGerado1;
		this.padraoGerado2 = padraoGerado2;
		this.padraoGerado3 = padraoGerado3;
		this.coringaArmazenado = "?";
	}
	
	public static Vector populaPadroes ( Vector padroes ) {

		// ---------------- é um ------------------------		

		Padrao pSer1000 = new Padrao( new String [] { "ele|eles", "é|são", "um", "#2", "que", "tem|contém", "#3", ",", "#4" },
                new String [] { "#0", "é um", "#2" },
                new String [] { "#0", "tem", "#3" },
                null );
		padroes.add( pSer1000 );

		Padrao pSer1005 = new Padrao( new String [] { "ele|eles", "é|são", "um", "#2", "que", "tem|contém", "#3" },
                new String [] { "#0", "é um", "#2" },
                new String [] { "#0", "tem", "#3" },
                null );
		padroes.add( pSer1005 );
		
		Padrao pSer1010 = new Padrao( new String [] { "ele|eles", "é|são", "um", "#2", "com|contendo", "#3", "e", "#4", ",", "#5" },
                new String [] { "#0", "é um", "#2" },
                new String [] { "#0", "contém", "#3" },
                new String [] { "#0", "contém", "#4" } );
		padroes.add( pSer1010 );

		Padrao pSer1015 = new Padrao( new String [] { "ele|eles", "é|são", "um", "#2", "com|contendo", "#3", "e", "#4" },
                new String [] { "#0", "é um", "#2" },
                new String [] { "#0", "contém", "#3" },
                new String [] { "#0", "contém", "#4" } );
		padroes.add( pSer1015 );

		Padrao pSer1020 = new Padrao( new String [] { "ele|eles", "é|são", "um", "#2", "com|contendo", "#3" },
                new String [] { "#0", "é um", "#2" },
                new String [] { "#0", "contém", "#3" },
                null );
		padroes.add( pSer1020 );
		
		Padrao pSer1025 = new Padrao( new String [] { "ele|eles", "é|são", "um", "#2", "com|contendo", "#3", ",", "#4" },
                new String [] { "#0", "é um", "#2" },
                new String [] { "#0", "contém", "#3" },
                null );
		padroes.add( pSer1025 );
		
		Padrao pSer1030 = new Padrao( new String [] { "ele|eles", "é|são", "um", "#2" },
                new String [] { "#0", "é um", "#2" },
                null,
                null );
		padroes.add( pSer1030 );
		
		Padrao pSer1035 = new Padrao( new String [] { "ele|eles", "é|são", "um", "#2", ",", "#3" },
                new String [] { "#0", "é um", "#2" },
                null,
                null );
		padroes.add( pSer1035 );
		
		Padrao pSer1040 = new Padrao( new String [] { "#1", "é|são", "um", "#2", "que", "tem|contém", "#3" },
                new String [] { "#1", "é um", "#2" },
                new String [] { "#1", "tem", "#3" },
                null );
		padroes.add( pSer1040 );
		
		Padrao pSer1045 = new Padrao( new String [] { "#1", "é|são", "um", "#2", "que", "tem|contém", "#3", ",", "#4" },
                new String [] { "#1", "é um", "#2" },
                new String [] { "#1", "tem", "#3" },
                null );
		padroes.add( pSer1045 );
		
		Padrao pSer1050 = new Padrao( new String [] { "#1", "é|são", "um", "#2", "com", "#3", "e", "#4" },
                new String [] { "#1", "é um", "#2" },
                new String [] { "#1", "contém", "#3" },
                new String [] { "#1", "contém", "#4" } );
		padroes.add( pSer1050 );

		Padrao pSer1055 = new Padrao( new String [] { "#1", "é|são", "um", "#2", "com", "#3", "e", "#4", ",", "#5" },
                new String [] { "#1", "é um", "#2" },
                new String [] { "#1", "contém", "#3" },
                new String [] { "#1", "contém", "#4" } );
		padroes.add( pSer1055 );

		Padrao pSer1060 = new Padrao( new String [] { "#1", "é|são", "um", "#2", "com", "#3" },
                new String [] { "#1", "é um", "#2" },
                new String [] { "#1", "contém", "#3" },
                null );
		padroes.add( pSer1060 );
		
		Padrao pSer1065 = new Padrao( new String [] { "#1", "é|são", "um", "#2", "com", "#3", ",", "#4" },
                new String [] { "#1", "é um", "#2" },
                new String [] { "#1", "contém", "#3" },
                null );
		padroes.add( pSer1065 );
		
		Padrao pSer1070 = new Padrao( new String [] { "#1", "é|são", "um", "#2" },
				                new String [] { "#1", "é um", "#2" },
				                null,
				                null );
		padroes.add( pSer1070 );

		Padrao pSer1075 = new Padrao( new String [] { "#1", "é|são", "um", "#2", ",", "#3"  },
                new String [] { "#1", "é um", "#2" },
                null,
                null );
		padroes.add( pSer1075 );
		
		// ---------------- é uma ------------------------		
		
		Padrao pSer2000 = new Padrao( new String [] { "ela|elas", "é|são", "uma", "#2", "que", "tem|contém", "#3" },
                new String [] { "#0", "é uma", "#2" },
                new String [] { "#0", "tem", "#3" },
                null );
		padroes.add( pSer2000 );
		
		Padrao pSer2005 = new Padrao( new String [] { "ela|elas", "é|são", "uma", "#2", "que", "tem|contém", "#3", ",", "#4" },
                new String [] { "#0", "é uma", "#2" },
                new String [] { "#0", "tem", "#3" },
                null );
		padroes.add( pSer2005 );
		
		Padrao pSer2010 = new Padrao( new String [] { "ela|elas", "é|são", "uma", "#2", "com|contendo", "#3", "e", "#4" },
                new String [] { "#0", "é uma", "#2" },
                new String [] { "#0", "contém", "#3" },
                new String [] { "#0", "contém", "#4" } );
		padroes.add( pSer2010 );

		Padrao pSer2015 = new Padrao( new String [] { "ela|elas", "é|são", "uma", "#2", "com|contendo", "#3", "e", "#4", ",", "#5" },
                new String [] { "#0", "é uma", "#2" },
                new String [] { "#0", "contém", "#3" },
                new String [] { "#0", "contém", "#4" } );
		padroes.add( pSer2015 );

		Padrao pSer2020 = new Padrao( new String [] { "ela|elas", "é|são", "uma", "#2", "com|contendo", "#3" },
                new String [] { "#0", "é uma", "#2" },
                new String [] { "#0", "contém", "#3" },
                null );
		padroes.add( pSer2020 );
		
		Padrao pSer2025 = new Padrao( new String [] { "ela|elas", "é|são", "uma", "#2", "com|contendo", "#3", ",", "#4" },
                new String [] { "#0", "é uma", "#2" },
                new String [] { "#0", "contém", "#3" },
                null );
		padroes.add( pSer2025 );
		
		Padrao pSer2030 = new Padrao( new String [] { "ela|elas", "é|são", "uma", "#2" },
                new String [] { "#0", "é uma", "#2" },
                null,
                null );
		padroes.add( pSer2030 );
		
		Padrao pSer2035 = new Padrao( new String [] { "ela|elas", "é|são", "uma", "#2", ",", "#3" },
                new String [] { "#0", "é uma", "#2" },
                null,
                null );
		padroes.add( pSer2035 );
		
		Padrao pSer2040 = new Padrao( new String [] { "#1", "é|são", "uma", "#2", "que", "tem|contém", "#3" },
                new String [] { "#1", "é uma", "#2" },
                new String [] { "#1", "tem", "#3" },
                null );
		padroes.add( pSer2040 );
		
		Padrao pSer2045 = new Padrao( new String [] { "#1", "é|são", "uma", "#2", "que", "tem|contém", "#3", ",", "#4" },
                new String [] { "#1", "é uma", "#2" },
                new String [] { "#1", "tem", "#3" },
                null );
		padroes.add( pSer2045 );
		
		Padrao pSer2050 = new Padrao( new String [] { "#1", "é|são", "um", "#2", "com", "#3", "e", "#4" },
                new String [] { "#1", "é uma", "#2" },
                new String [] { "#1", "contém", "#3" },
                new String [] { "#1", "contém", "#4" } );
		padroes.add( pSer2050 );

		Padrao pSer2055 = new Padrao( new String [] { "#1", "é|são", "um", "#2", "com", "#3", "e", "#4", ",", "#5" },
                new String [] { "#1", "é uma", "#2" },
                new String [] { "#1", "contém", "#3" },
                new String [] { "#1", "contém", "#4" } );
		padroes.add( pSer2055 );

		Padrao pSer2060 = new Padrao( new String [] { "#1", "é|são", "uma", "#2", "com", "#3" },
                new String [] { "#1", "é uma", "#2" },
                new String [] { "#1", "contém", "#3" },
                null );
		padroes.add( pSer2060 );
		
		Padrao pSer2065 = new Padrao( new String [] { "#1", "é|são", "uma", "#2", "com", "#3", ",", "#4" },
                new String [] { "#1", "é uma", "#2" },
                new String [] { "#1", "contém", "#3" },
                null );
		padroes.add( pSer2065 );
		
		Padrao pSer2070 = new Padrao( new String [] { "#1", "é|são", "uma", "#2" },
				                new String [] { "#1", "é uma", "#2" },
				                null,
				                null );
		padroes.add( pSer2070 );

		Padrao pSer2075 = new Padrao( new String [] { "#1", "é|são", "uma", "#2", ",", "#3" },
                new String [] { "#1", "é uma", "#2" },
                null,
                null );
		padroes.add( pSer2075 );

		// ---------------- o nome ------------------------		
		
		Padrao pSer3000 = new Padrao( new String [] { "o", "nome|termo", "#1", "refere-se", "a", "#2" },
                new String [] { "#1", "se refere a", "#2" },
                null,
                null );
		padroes.add( pSer3000 );

		Padrao pSer3001 = new Padrao( new String [] { "o", "nome|termo", "#1", "refere-se", "#2" },
                new String [] { "#1", "se refere a", "#2" },
                null,
                null );
		padroes.add( pSer3001 );
		
		Padrao pSer3010 = new Padrao( new String [] { "o", "nome|termo", "#1", "serve", "para", "#2" },
                new String [] { "#1", "denota", "#2" },
                null,
                null );
		padroes.add( pSer3010 );
		
		// ---------------- serve para ------------------------		
		
		Padrao pSer4000 = new Padrao( new String [] { "#1", "serve", "para", "#2" },
                new String [] { "#1", "serve para", "#2" },
                null,
                null );
		padroes.add( pSer4000 );

		// ---------------- outras alternativas ------------------------		
		
		Padrao pSer8000 = new Padrao( new String [] { "#1", "é|são", "#2", "por|pelo|pela", "#3" },
                new String [] { "#1", "+é ", "+#2", " por", "#3" },
                null,
                null );
		padroes.add( pSer8000 );

		// ---------------- outras alternativas ------------------------		
		
		Padrao pSer9000 = new Padrao( new String [] { "que", "possui|possuem", "#2", "e", "possuem", "#3"  },
                new String [] { "#0", "possui", "#2" },
                new String [] { "#0", "possui", "#3" },
                null );
		padroes.add( pSer9000 );

		Padrao pSer9005 = new Padrao( new String [] { "que", "possui|possuem", "#2" },
                new String [] { "#0", "possui", "#2" },
                null,
                null );
		padroes.add( pSer9005 );

		Padrao pSer9010 = new Padrao( new String [] { "e", "possui|possuem", "#2" },
                new String [] { "#0", "possui", "#2" },
                null,
                null );
		padroes.add( pSer9010 );
		
		// ---------------- finais ------------------------		
		
		Padrao pSer100000 = new Padrao( new String [] { "ele|ela", "é", "#2", ",", "#3" },
                new String [] { "#0", "é", "#2" },
                null,
                null );
		padroes.add( pSer100000 );

		Padrao pSer100002 = new Padrao( new String [] { "ele|ela", "é", "#2" },
                new String [] { "#0", "é", "#2" },
                null,
                null );
		padroes.add( pSer100002 );
		
		Padrao pSer100005 = new Padrao( new String [] { "#1", "é", "#2", ",", "#3" },
                new String [] { "#1", "é", "#2" },
                null,
                null );
		padroes.add( pSer100005 );

		Padrao pSer100007 = new Padrao( new String [] { "#1", "é", "#2" },
                new String [] { "#1", "é", "#2" },
                null,
                null );
		padroes.add( pSer100007 );
		
		Padrao pSer100010 = new Padrao( new String [] { "ele|ela", "tem", "#2", ",", "#3" },
                new String [] { "#0", "tem", "#2" },
                null,
                null );
		padroes.add( pSer100010 );

		Padrao pSer100012 = new Padrao( new String [] { "ele|ela", "tem", "#2" },
                new String [] { "#0", "tem", "#2" },
                null,
                null );
		padroes.add( pSer100012 );

		Padrao pSer100015 = new Padrao( new String [] { "#1", "tem", "#2", ",", "#3" },
                new String [] { "#1", "tem", "#2" },
                null,
                null );
		padroes.add( pSer100015 );

		Padrao pSer100017 = new Padrao( new String [] { "#1", "tem", "#2" },
                new String [] { "#1", "tem", "#2" },
                null,
                null );
		padroes.add( pSer100017 );

		Padrao pSer100020 = new Padrao( new String [] { "ele|ela", "contém", "#2", ",", "#3" },
                new String [] { "#0", "contém", "#2" },
                null,
                null );
		padroes.add( pSer100020 );

		Padrao pSer100022 = new Padrao( new String [] { "ele|ela", "contém", "#2" },
                new String [] { "#0", "contém", "#2" },
                null,
                null );
		padroes.add( pSer100022 );
		
		Padrao pSer100025 = new Padrao( new String [] { "#1", "contém", "#2", ",", "#3" },
                new String [] { "#1", "contém", "#2" },
                null,
                null );
		padroes.add( pSer100025 );

		Padrao pSer100027 = new Padrao( new String [] { "#1", "contém", "#2" },
                new String [] { "#1", "contém", "#2" },
                null,
                null );
		padroes.add( pSer100027 );
		
		
		return padroes;
	}

	public void alimentaTriadesGeradas() {

		System.out.println( "coringas[0]       = " + coringas[0] );
		System.out.println( "coringas[1]       = " + coringas[1] );		
		System.out.println( "coringaArmazenado = " + coringaArmazenado );		
		
		int ponteiroGerado = 0;
		int indiceDaTriade = 0;
		
		if ( padraoGerado1 != null ) {
			
			while ( ponteiroGerado < padraoGerado1.length ) {

				if ( padraoGerado1[ ponteiroGerado ].charAt( 0 ) == '#' ) {
					
					int coringa = Integer.parseInt( padraoGerado1[ ponteiroGerado ].substring(1) );

					if ( coringa == 0 ) {
						triadeGerada1[ indiceDaTriade ] = coringaArmazenado.trim();
					} else {
						triadeGerada1[ indiceDaTriade ] = coringas[ coringa ].trim();
					}

				} else if ( padraoGerado1[ ponteiroGerado ].charAt( 0 ) == '+' ) {
					StringBuilder sb = new StringBuilder();
					while ( padraoGerado1[ ponteiroGerado ].charAt( 0 ) == '+' ) {
						if ( padraoGerado1[ ponteiroGerado ].charAt( 1 ) == '#' ) {
							int coringa2 = Integer.parseInt( padraoGerado1[ ponteiroGerado ].substring(2) );
							sb.append( coringas[ coringa2 ].trim() );
						} else {
							sb.append( padraoGerado1[ ponteiroGerado ].substring(1) );
						}
						ponteiroGerado++;
					}
					if ( padraoGerado1[ ponteiroGerado ].charAt( 0 ) == '#' ) {
						int coringa3 = Integer.parseInt( padraoGerado1[ ponteiroGerado ].substring(1) );
						sb.append( coringas[ coringa3 ].trim() );
					} else {
						sb.append( padraoGerado1[ ponteiroGerado ].substring(0) );
					}
					triadeGerada1[ indiceDaTriade ] = sb.toString();
				} else {
					triadeGerada1[ indiceDaTriade ] = padraoGerado1[ ponteiroGerado ];
				}
				indiceDaTriade++;	
				ponteiroGerado++;
			}
		}
		
		if ( triadeGerada1[0] != null ) {
			triadeGerada1[0] = RemovedorDeStopWords.removeStopWords( triadeGerada1[0] );
		}
		
		ponteiroGerado = 0;
		indiceDaTriade = 0;
		
		if ( padraoGerado2 != null ) {
			
			while ( ponteiroGerado < padraoGerado2.length ) {

				if ( padraoGerado2[ ponteiroGerado ].charAt( 0 ) == '#' ) {
					
					int coringa = Integer.parseInt( padraoGerado2[ ponteiroGerado ].substring(1) );

					if ( coringa == 0 ) {
						triadeGerada2[ indiceDaTriade ] = coringaArmazenado.trim();
					} else {
						triadeGerada2[ indiceDaTriade ] = coringas[ coringa ].trim();
					}
					
				} else if ( padraoGerado2[ ponteiroGerado ].charAt( 0 ) == '+' ) {
					StringBuilder sb = new StringBuilder();
					while ( padraoGerado2[ ponteiroGerado ].charAt( 0 ) == '+' ) {
						if ( padraoGerado2[ ponteiroGerado ].charAt( 1 ) == '#' ) {
							int coringa2 = Integer.parseInt( padraoGerado2[ ponteiroGerado ].substring(2) );
							sb.append( coringas[ coringa2 ].trim() );
						} else {
							sb.append( padraoGerado2[ ponteiroGerado ].substring(1) );
						}
						ponteiroGerado++;
					}
					if ( padraoGerado2[ ponteiroGerado ].charAt( 0 ) == '#' ) {
						int coringa3 = Integer.parseInt( padraoGerado2[ ponteiroGerado ].substring(1) );
						sb.append( coringas[ coringa3 ].trim() );
					} else {
						sb.append( padraoGerado2[ ponteiroGerado ].substring(0) );
					}
					triadeGerada2[ indiceDaTriade ] = sb.toString();
				} else {
					triadeGerada2[ indiceDaTriade ] = padraoGerado2[ ponteiroGerado ];
				}
				indiceDaTriade++;	
				ponteiroGerado++;
			}
		}
		

		if ( triadeGerada2[0] != null ) {
			triadeGerada2[0] = RemovedorDeStopWords.removeStopWords( triadeGerada2[0] );
		}
			
		ponteiroGerado = 0;
		indiceDaTriade = 0;
		
		if ( padraoGerado3 != null ) {
			
			while ( ponteiroGerado < padraoGerado3.length ) {

				if ( padraoGerado3[ ponteiroGerado ].charAt( 0 ) == '#' ) {
					
					int coringa = Integer.parseInt( padraoGerado3[ ponteiroGerado ].substring(1) );

					if ( coringa == 0 ) {
						triadeGerada3[ indiceDaTriade ] = coringaArmazenado.trim();
					} else {
						triadeGerada3[ indiceDaTriade ] = coringas[ coringa ].trim();
					}
					
				} else if ( padraoGerado3[ ponteiroGerado ].charAt( 0 ) == '+' ) {
					StringBuilder sb = new StringBuilder();
					while ( padraoGerado3[ ponteiroGerado ].charAt( 0 ) == '+' ) {
						if ( padraoGerado3[ ponteiroGerado ].charAt( 1 ) == '#' ) {
							int coringa2 = Integer.parseInt( padraoGerado3[ ponteiroGerado ].substring(2) );
							sb.append( coringas[ coringa2 ].trim() );
						} else {
							sb.append( padraoGerado3[ ponteiroGerado ].substring(1) );
						}
						ponteiroGerado++;
					}
					if ( padraoGerado3[ ponteiroGerado ].charAt( 0 ) == '#' ) {
						int coringa3 = Integer.parseInt( padraoGerado3[ ponteiroGerado ].substring(1) );
						sb.append( coringas[ coringa3 ].trim() );
					} else {
						sb.append( padraoGerado3[ ponteiroGerado ].substring(0) );
					}
					triadeGerada3[ indiceDaTriade ] = sb.toString();
				} else {
					triadeGerada3[ indiceDaTriade ] = padraoGerado3[ ponteiroGerado ];
				}
				indiceDaTriade++;	
				ponteiroGerado++;
			}
		}

		if ( triadeGerada3[0] != null ) {
			triadeGerada3[0] = RemovedorDeStopWords.removeStopWords( triadeGerada3[0] );
		}

	}
	
	public void atualizaCoringaArmazenado() {
		System.out.println( "vou atualizar = " + coringas[1] );
		if ( coringas[1] != null ) {
			if ( !coringas[1].matches( "ele|ela" ) ) {
				coringaArmazenado = coringas[1];
			}
		}
	}
	
	public String consultaPadraoBusca() {
		StringBuilder sb = new StringBuilder();
		for ( int i=0; i<padraoDeBusca.length; i++ ) {
			sb.append( padraoDeBusca[ i ] );
			sb.append( " " );
		}
		return sb.toString();
	}
	
	public String[] getPadraoDeBusca() {
		return padraoDeBusca;
	}

	public void setPadraoDeBusca(String[] padraoDeBusca) {
		this.padraoDeBusca = padraoDeBusca;
	}

	public String[] getPadraoGerado1() {
		return padraoGerado1;
	}

	public void setPadraoGerado1(String[] padraoGerado1) {
		this.padraoGerado1 = padraoGerado1;
	}

	public String[] getPadraoGerado2() {
		return padraoGerado2;
	}

	public void setPadraoGerado2(String[] padraoGerado2) {
		this.padraoGerado2 = padraoGerado2;
	}

	public String[] getPadraoGerado3() {
		return padraoGerado3;
	}

	public void setPadraoGerado3(String[] padraoGerado3) {
		this.padraoGerado3 = padraoGerado3;
	}
	
	public String[] getCoringas() {
		return coringas;
	}

	public void setCoringas(String[] coringas) {
		this.coringas = coringas;
	}

	public String[] getTriadeGerada1() {
		return triadeGerada1;
	}

	public void setTriadeGerada1(String[] triadeGerada1) {
		this.triadeGerada1 = triadeGerada1;
	}

	public String[] getTriadeGerada2() {
		return triadeGerada2;
	}

	public void setTriadeGerada2(String[] triadeGerada2) {
		this.triadeGerada2 = triadeGerada2;
	}


	public String[] getTriadeGerada3() {
		return triadeGerada3;
	}

	public void setTriadeGerada3(String[] triadeGerada3) {
		this.triadeGerada3 = triadeGerada3;
	}

	public String getCoringaArmazenado() {
		return coringaArmazenado;
	}

	public void setCoringaArmazenado(String coringaArmazenado) {
		this.coringaArmazenado = coringaArmazenado;
	}

}

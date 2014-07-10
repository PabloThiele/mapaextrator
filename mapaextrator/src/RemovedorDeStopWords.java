

/*
 * $Id: RemovedorDeStopWords.java,v 1.5 2011/06/02 12:01:25 ricardo Exp $
 * 
 * Portions copyright (C) 2008 Pablo Thiele
 * Portions copyright (C) 2008 Ricardo Ferreira de Oliveira
 * 
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program; if not, write to the Free Software
 *   Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */
 

/**
 * Classe: RemovedorDeStopWords
 * 
 * Esta classe remove Stop Words de trechos identificados como coringas
 *  
 * @author Pablo Thiele.
 * @author Ricardo Ferreira de Oliveira
 *  
 * @see MapaExtrator
 * 
 * @version 1.0.0
 */
public class RemovedorDeStopWords {

	public static final int T_STOPWORD			= 0;
	public static final int T_MAINWORD			= 1;
	public static final int T_NUMBER			= 2;
	public static final int T_SIMBOL			= 3;

	public static final int T_FINAL				= 98;
	public static final int T_NULO				= 99;

	private static String  	lexema;
	private static String  	ultimoLexema;
	private static int 		token;
	private static int 		ultimoToken;
	private static char		lookahead;
	private static String	textoInteiro;
	private static int		posicaoNoTexto;
	private static String  	brancos;	
	
    private static StringBuilder textoSemStopWords;
    
    public static void main( String [] args ) {
    	System.out.println( removeStopWords( "a menina é uma menina quando ela chora muito" ) );
    }
	
	public static String removeStopWords( String texto ) {
		
		textoSemStopWords = new StringBuilder();

		textoInteiro 	 	= texto;
		posicaoNoTexto	 	= 0;
		token  			 	= T_NULO;
		lookahead			= ' ';

		StringBuffer whites = new StringBuffer();
		whites.append( ' ' );
		whites.append( (char) 9 );
		whites.append( (char) 10 );
		whites.append( (char) 12 );
		whites.append( (char) 13 );
		
		brancos = whites.toString();

		while ( token != T_FINAL ) {
			textoSemStopWords.append( buscaProximoToken() );
			textoSemStopWords.append( " " );
		}
		
		return textoSemStopWords.toString().trim();
	}

	private static void moveLookahead() {
		if ( posicaoNoTexto >= textoInteiro.length() ) {
			lookahead = (char) 26;
		} else {	
			lookahead = textoInteiro.charAt( posicaoNoTexto );
			posicaoNoTexto++;
		}
	}

	private static String buscaProximoToken() {

		lexema = "";
		
		StringBuffer esteToken = new StringBuffer();

		while( brancos.toString().indexOf( lookahead ) >= 0 ) {
			moveLookahead();
		}
		
		if( isAlpha( lookahead ) ) {
			
			while( isAlpha( lookahead ) ||
				   isDigit( lookahead ) ) {

					esteToken.append( lookahead );
					moveLookahead();
			}
			
			lexema = esteToken.toString().toLowerCase();

			if( lexema.equals( "a" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "as" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "o" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "as" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "um" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "uns" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "uma" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "umas" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "meu" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "teu" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "seu" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "vosso" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "pelo" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "pela" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "até" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "isso" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "ela" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "ele" ) ) {
				token = T_STOPWORD;
			} else if( lexema.equals( "também" ) ) {
				token = T_STOPWORD;
			} else {
				token = T_MAINWORD;
			}
			
			lexema = esteToken.toString();

		} else if( isDigit( lookahead ) ) { 

			StringBuffer sb = new StringBuffer();
			
			while ( lookahead != '.' && isDigit( lookahead ) ) {
				sb.append( lookahead );				
				moveLookahead();
				token = T_NUMBER;			
			}
			
			if ( lookahead == '.' ) {
				sb.append( lookahead );				
				moveLookahead();
				while ( isDigit( lookahead ) ) {
					sb.append( lookahead );				
					moveLookahead();
				}
				token = T_NUMBER;			
			}
			lexema = sb.toString();

		} else if ( lookahead == (char) 26 ){	
			token = T_FINAL;
		} else {
			token = T_SIMBOL;			
			lexema = esteToken.toString();		
			moveLookahead();

		}
		
		if ( token != T_STOPWORD ) {
			return lexema;
		} else {
			return "";
		}
	}

	private static boolean isDigit( char chr ) {
		return ( chr >= '0' && chr <= '9' );
	}

	private static boolean isAlpha( char chr ) {
		return ( ( chr >= 'A' && chr <= 'Z' ) || 
				 ( chr >= 'a' && chr <= 'z' ) || 
				 ( chr == '_' )               || 
				 ( chr == 'ã' )               || 
				 ( chr == 'á' )               || 
				 ( chr == 'â' )               || 
				 ( chr == 'é' )               || 
				 ( chr == 'ê' )               || 
				 ( chr == 'í' )               || 
				 ( chr == 'ó' )               || 
				 ( chr == 'ô' )               || 
				 ( chr == 'ú' )               || 
				 ( chr == 'ç' ) );
	} 

	public String getLexema() {
		return lexema;
	}

	public int getToken() {
		return token;
	}

	public String getUltimoLexema() {
		return ultimoLexema;
	}

	public int getUltimoToken() {
		return ultimoToken;
	}

}

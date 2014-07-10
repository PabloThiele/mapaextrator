package utils;
/*
 * $Id: TeclaListener.java,v 1.2 2008/04/24 12:01:25 ricardo Exp $
 * 
 * Portions copyright (C) 2008 Alexandre de Oliveira Zamberlam
 * Portions copyright (C) 2008 Ana Carolina S. S. Jaskulski
 * Portions copyright (C) 2008 Carlos Sérgio Schneider
 * Portions copyright (C) 2008 Fernando Oscar Korndorfer
 * Portions copyright (C) 2008 Mariana Kreisig
 * Portions copyright (C) 2008 Paulo Roberto Ferreira Jr.
 * Portions copyright (C) 2008 Ricardo Ferreira de Oliveira
 * Portions copyright (C) 2008 Thiago Glaser
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;

/** 
 * Classe TeclaListener
 * 
 * @version 1.0.0
 */
public class TeclaListener implements KeyListener {

	JTextArea textEditor = null;
	
	public TeclaListener( JTextArea textEditor ) {
		super();
		this.textEditor = textEditor; 
	}
	
	
	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

		int posicaoAtual;
		int ponteiro;
		int posicaoRetorno;
		String adicao = null;
		String posAdicao = null;
		String lexema = null;
		
		if( arg0.isControlDown() ) {
			if ( arg0.getKeyChar() == KeyEvent.VK_SPACE ) {
			
				posicaoAtual = textEditor.getCaret().getMark();
				ponteiro = posicaoAtual-1;
				StringBuffer token = new StringBuffer();
				
				System.out.println( "ponteiro no inicio = " + ponteiro );

				if ( ponteiro < 0 ) {
					lexema = "";
				} else {
					if ( ponteiro == 0 ) {
						token.insert( 0, textEditor.getText().substring( 0, 1 ) );
					} else {
						while ( isAlpha( textEditor.getText().substring( ponteiro, ponteiro+1 ).charAt( 0 ) ) && ponteiro > 0 ) {
							token.insert( 0, textEditor.getText().substring( ponteiro, ponteiro+1 ) ); 
							ponteiro--;
						}
						if ( ponteiro == 0 ) {
							token.insert( 0, textEditor.getText().substring( 0, 1 ) );
						}
					}
					lexema = token.toString();
					
					try {
						int tamanhoLexema = lexema.length();
						if ( tamanhoLexema >= 2 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "inteiro".substring( 0, lexema.length() ) ) ) {
							adicao = "inteiro".substring( lexema.length(), 7 );
						} else {
							if ( tamanhoLexema >= 1 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "repita".substring( 0, lexema.length() ) ) ) {
								adicao = "repita {\n".substring( lexema.length(), 9 );
							} else {
								if ( tamanhoLexema >= 2 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "enquanto ( ".substring( 0, lexema.length() ) ) ) {
									adicao = "enquanto ( ".substring( lexema.length(), 11 );
									posAdicao = " )";							
								} else {
									if ( tamanhoLexema >= 2 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "escreva (".substring( 0, lexema.length() ) ) ) {
										adicao = "escreva (".substring( lexema.length(), 9 );
										posAdicao = " );";							
									} else {
										if ( tamanhoLexema != 2 && tamanhoLexema >= 1 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "funcao".substring( 0, lexema.length() ) ) ) {
											adicao = "funcao".substring( lexema.length(), 6 );
										} else {
											if ( tamanhoLexema >= 1 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "leia (".substring( 0, lexema.length() ) ) ) {
												adicao = "leia (".substring( lexema.length(), 6 );
												posAdicao = " );";							
											} else {
												if ( tamanhoLexema >= 2 && tamanhoLexema <= 4 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "para".substring( 0, lexema.length() ) ) ) {
													adicao = "para".substring( lexema.length(), 4 );
												} else {
													if ( tamanhoLexema >= 1 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "ApagaTela;\n".substring( 0, lexema.length() ) ) ) {
														adicao = "ApagaTela;\n".substring( lexema.length(), 11 );
													} else {
														if ( tamanhoLexema >= 5 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "paraInteiro ( ".substring( 0, lexema.length() ) ) ) {
															adicao = "paraInteiro ( ".substring( lexema.length(), 14 );
															posAdicao = " );";
														} else {
															if ( tamanhoLexema >= 1 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "caracter".substring( 0, lexema.length() ) ) ) {
																adicao = "caracter".substring( lexema.length(), 8 );
															} else {
																if ( tamanhoLexema >= 1 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "booleano".substring( 0, lexema.length() ) ) ) {
																	adicao = "booleano".substring( lexema.length(), 8 );
																} else {
																	if ( tamanhoLexema >= 2 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "principal".substring( 0, lexema.length() ) ) ) {
																		adicao = "principal() {\n\t".substring( lexema.length(), 15 );
																		posAdicao = "\n}";
																	} else {
																		if ( lexema.equalsIgnoreCase( "fu" ) ) {
																			adicao = "funcao inteiro principal() {\n\t".substring( lexema.length(), 30 );
																			posAdicao = "\n}\n";
																		} else {
																			if ( tamanhoLexema >= 5 && lexema.substring( 0, lexema.length() ).equalsIgnoreCase( "paraCaracter ( ".substring( 0, lexema.length() ) ) ) {
																				adicao = "paraCaracter ( ".substring( lexema.length(), 15 );
																			} else {
																				// futuras palavras reservadas	
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					
					} catch (Exception e ) {
						
					}
				}
	
				if ( adicao != null ) {
					StringBuffer novoTexto = new StringBuffer();
					novoTexto.append( textEditor.getText().substring( 0, posicaoAtual ) );
					novoTexto.append( adicao );
					posicaoRetorno = novoTexto.length();
					if ( posAdicao != null ) {
						novoTexto.append( posAdicao );
					}
					novoTexto.append( textEditor.getText().substring( posicaoAtual ) );
					textEditor.setText( novoTexto.toString() );
					textEditor.setCaretPosition( posicaoRetorno );
				}
			} 
		}
	}
	
	private boolean isAlpha( char chr ) {
		return ( ( chr >= 'A' && chr <= 'Z' ) || ( chr >= 'a' && chr <= 'z' ) || ( chr == '_' ) );
	} 
	
}

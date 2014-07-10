package utils;
/*
 * $Id: LicencaNuvola.java,v 1.2 2008/04/07 17:36:50 ricardo Exp $
 * 
 * Portions copyright (C) 2011 Ricardo Ferreira de Oliveira
 * Portions copyright (C) 2011 PabloThiele
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Classe: Licenca Nuvola
 * 
 * @see LicencaGnu
 * 
 * @version 1.0.0
 */
public class LicencaNuvola extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3201364902925137936L;
	public JTextArea textGnu;
	public JScrollPane textGnuSB;

	public JLabel imagem; 
	public JDesktopPane oFundo; 
	public ImageIcon iconeCanto; 
	
	public LicencaNuvola() {
	
		super( "Licença Nuvola" );
		
		StringBuilder bufferRotina = new StringBuilder();

		textGnu = new JTextArea();
		JScrollPane textGnuSB = new JScrollPane( textGnu );
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );	
		setDefaultLookAndFeelDecorated( true );
		
		Container container = getContentPane(); 
		container.setLayout(new BorderLayout()); 
		       
		oFundo = new JDesktopPane(); 
		container.setBackground( new Color ( 235, 245, 255 ) ); 
		container.add( oFundo ); 
		
		textGnu.setText( "" );
		
		try {
			BufferedReader in = new BufferedReader( new InputStreamReader( getClass().getClassLoader().getResourceAsStream( "licenca/nuvola.txt" ) ) );
			try {
				String s;
				bufferRotina.append( "\n" );
				while( ( s = in.readLine() ) != null ) {
					bufferRotina.append( (String) s + "\n" );
				}
			} finally {
				textGnu.setText( bufferRotina.toString() );
				textGnu.setCaretPosition(0);
				in.close();
			}
		} catch( Exception e ) {
			textGnu.setText( "licença Gnu LGPL não encontrada! Recurso: licenca/nuvola.txt\n" + e.getMessage() );
		}

		container.add( textGnuSB, BorderLayout.CENTER ); 
		  
		Image icone = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource( "imagens/nuvola22.png" )); 
		setIconImage(icone); 
		
		this.setLocation( 100, 50 );
		setSize(600,500); 
		setVisible(true); 
	}
	
}
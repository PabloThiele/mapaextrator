package utils;
/*
 * $Id: LicencaGnu.java,v 1.2 2008/04/07 17:36:50 mariana Exp $
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
 * Classe: Licenca Gnu
 */
public class LicencaGnu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9170700792061101093L;
	public JTextArea textGnu;
	public JScrollPane textGnuSB;

	public JLabel imagem; 
	public JDesktopPane oFundo; 
	public ImageIcon iconeCanto; 
	
	public LicencaGnu() {
	
		super( "Licença Gnu" );
		
		StringBuffer bufferRotina = new StringBuffer();

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
			BufferedReader in = new BufferedReader( new InputStreamReader( getClass().getClassLoader().getResourceAsStream( "licenca/COPYING.txt" ) ) );
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
			textGnu.setText( "licença Gnu não encontrada! Recurso: licenca/COPYING.txt\n" + e.getMessage() );
		}

		container.add( textGnuSB, BorderLayout.CENTER ); 
		  
		Image icone = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource( "imagens/gnu.png" )); 
		setIconImage(icone); 
		
		this.setLocation( 100, 50 );
		setSize(600,500); 
		setVisible(true); 
	}
	
}
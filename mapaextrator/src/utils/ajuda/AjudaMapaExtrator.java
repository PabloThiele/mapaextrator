	package utils.ajuda;
/*
 * $Id: AjudaVerto.java,v 1.13 2008/04/24 12:01:25 ricardo Exp $
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
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.JTextComponent;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.Position;
import javax.swing.text.View;

/**
 * Classe: AjudaMapaExtrator
 */
public class AjudaMapaExtrator extends JFrame {

	private static final long serialVersionUID = 7204110966094688955L;
	
	private JPanel painelAjuda;
	private JLabel lblTitulo;
	private JEditorPane textoAjuda;
	private JScrollPane scpAjuda;
	
	public AjudaMapaExtrator() {
	
		super( "Ajuda do MapaExtrator - 1.0.0" );
		
		StringBuilder sbTitulo = new StringBuilder();
		StringBuilder sbAjuda  = new StringBuilder();
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );	
		setDefaultLookAndFeelDecorated( true );
		
		sbTitulo.append( "<html>" );
		sbTitulo.append( "<font color=blue size=+2>Ajuda do MapaExtrator 1.0.0</font>" );
		sbTitulo.append( "</html>" );
		
		lblTitulo = new JLabel( sbTitulo.toString() ); 
		
		lblTitulo.setBorder( BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(""),
                BorderFactory.createEmptyBorder(5,10,10,10)) );
		
		sbAjuda.append( "<html>" );
		sbAjuda.append( "<body bgcolor=\"#D6D9DF\">" );
		sbAjuda.append( "<font color=green size=+1>1 - Descrição da Ferramenta</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O MapaExtrator é uma ferramenta desenvolvida para o apoio pedagógico<br>" );
		sbAjuda.append( "das ...<br>" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2 - Sintaxe dos Comandos</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.1 - Corpo do Programa</<font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Um programa Verto tem a seguinte estrutura:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "[Declaração de Variáveis]<br />" );
		sbAjuda.append( "[Declaração de Prototipos]<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "funcao inteiro principal() {<br />" );
		sbAjuda.append( "    [comandos]<br />" );
		sbAjuda.append( "}<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "[Declaração de outras funções]<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.2 - Declaração de Variáveis</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "As variáveis no Verto podem ser de 3 tipos: inteiro, logico e caracter.<br />" );
		sbAjuda.append( "Uma declaração de variáveis inicia-se com o tipo e segue-se com uma<br />" );
		sbAjuda.append( "lista de nomes de variáveis, terminada com um ponto e vírgula. <br />" );
		sbAjuda.append( "O exemplo abaixo ilustra uma declaração de variáveis típica:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "inteiro a, b, c;<br />" );
		sbAjuda.append( "caracter m, n;<br />" );
		sbAjuda.append( "logico l;<br />" );
		sbAjuda.append( "inteiro i, j;<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.2.1 - Declaração de Constantes</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Uma estrutura de dado usada para guardar um objeto,<br />" );
		sbAjuda.append( "sendo que o mesmo não poderá ser modificado.<br />" );
		sbAjuda.append( "Sua declaração é feita da mesma forma que as variáveis,<br />" );
		sbAjuda.append( "mas adicionando a palavra reservada \"constante\". <br />" );
		sbAjuda.append( "O exemplo abaixo ilustra uma declaração de constantes típica:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "constante inteiro a, b, c;<br />" );
		sbAjuda.append( "constante caracter m, n;<br />" );
		sbAjuda.append( "constante logico l;<br />" );
		sbAjuda.append( "constante inteiro i, j;<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />");
		sbAjuda.append( "<br />");
		sbAjuda.append( "<font color=green size=+1>2.2.2 - Declaração de Vetores</font>");
		sbAjuda.append( "<br />");
		sbAjuda.append( "<br />");
		sbAjuda.append( "<font color=blue size=+1>");
		sbAjuda.append( "Conhecido também como array é uma estrutura de dados,<br />");
		sbAjuda.append( "com tamanho pré-definido, que armazena uma seqüência consecutiva<br />");
		sbAjuda.append( "de objetos na memória. Seus dados podem ser acessados informando sua posição,<br />");
		sbAjuda.append( "que é um índice normalmente utilizando valores inteiros. <br />");
		sbAjuda.append( "O exemplo abaixo ilustra uma declaração de vetores típica:<br />");
		sbAjuda.append( "</font>");
		sbAjuda.append( "<br />");
		sbAjuda.append( "<font color=red size=+1>");
		sbAjuda.append( "inteiro  a[10];<br />");
		sbAjuda.append( "caracter m[5];<br />");
		sbAjuda.append( "</font>");
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.3 - Comando de Atribuição</<font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando de atribuição em Verto é similar ao da linguagem C.<br />" );
		sbAjuda.append( "Sua forma sintática é:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "{variavel} = {expressao}" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Exemplos de atribuições são ilustrados abaixo:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "a = 9;<br />" );
		sbAjuda.append( "l = a > b;<br />" );
		sbAjuda.append( "x = 10 - 3 * 4;<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.3.1 - Atribuição de Vetores</<font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Exemplos de atribuições são ilustrados abaixo:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "a[2] = 9;<br />" );
		sbAjuda.append( "x = 1;<br />" );
		sbAjuda.append( "a[x] = b[2] + 1;<br />" );
		sbAjuda.append( "a[1+2] = x + 1;<br />" );
		sbAjuda.append( "a[1+2] = b[x] + a[1];<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.4 - Comando de Leitura</<font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando de leitura no Verto é peculiar. Isto se deve ao fato da máquina<br />" );
		sbAjuda.append( "Cesar ter somente uma linha de visor com 32 posições.<br />" );
		sbAjuda.append( "Suas formas sintáticas são:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		
		sbAjuda.append( "<table border=1 bordercolorlight = ffffff bordercolordark = ff00CC>" );

		sbAjuda.append( "<tr>" );
		sbAjuda.append( "<td width=350>" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "leia( {inteiro|variavel inteira}, {variavel} )" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "</td>" );
		sbAjuda.append( "<td width=250>" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "leia( a );<br />leia( 9, a );<br />leia( b, a );" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "</td>" );
		sbAjuda.append( "</tr>" );
		
		sbAjuda.append( "<tr>" );
		sbAjuda.append( "<td>" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "leia( {texto}, {variavel} )" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "</td>" );
		sbAjuda.append( "<td>" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "leia( \"variavel = \", a );" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "</td>" );
		sbAjuda.append( "</tr>" );

		sbAjuda.append( "</table>" );
		
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.5 - Comando de Escrita</<font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando de escrita no Verto é peculiar. Isto se deve ao fato da máquina<br />" );
		sbAjuda.append( "Cesar ter somente uma linha de visor com 32 posições.<br />" );
		sbAjuda.append( "Suas formas sintáticas são:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		
		sbAjuda.append( "<table border=1 bordercolorlight = ffffff bordercolordark = ff00CC>" );

		sbAjuda.append( "<tr>" );
		sbAjuda.append( "<td width=350>" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "escreva( {inteiro|variavel inteira}, comando )" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "</td>" );
		sbAjuda.append( "<td width=250>" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "escreva( 9, a );<br />escreva( b, a );" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "</td>" );
		sbAjuda.append( "</tr>" );
		
		sbAjuda.append( "<tr>" );
		sbAjuda.append( "<td>" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "escreva( comando )" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "</td>" );
		sbAjuda.append( "<td>" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "escreva( \"inicio\" );" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "</td>" );
		sbAjuda.append( "</tr>" );

		sbAjuda.append( "</table>" );
		
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.6 - Comando de Seleção - seA</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando de seleção 'se' é um comando de seleção bidirecional.<br />" );
		sbAjuda.append( "É semelhante a sintaxe da linguagem C.<br />" );
		sbAjuda.append( "Sua forma sintática é:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "se ( condicao ) entao comando" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Um exemplo de Seleção 'se' esta ilustrado abaixo:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "se ( x < y ) {<br />" );
		sbAjuda.append( "escreva( x );<br />" );
		sbAjuda.append( "}<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		
// Samuel begin
		
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.7 - Comando de Laço Enquanto</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando de Laço Enquanto.<br />" );
		sbAjuda.append( "É semelhante a sintaxe da linguagem C.<br />" );
		sbAjuda.append( "Sua forma sintática é:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "enquanto ( condicao ) comando" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Um exemplo de Laço Enquanto esta ilustrado abaixo:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "enquanto( a = b ){<br />" );
		sbAjuda.append( "escreva( a );<br />" );
		sbAjuda.append( "a = a + 1 ;<br />" );
		sbAjuda.append( "}<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.8 - Comando de Laço Para</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando de Laço Para.<br />" );
		sbAjuda.append( "É semelhante a sintaxe da linguagem C.<br />" );
		sbAjuda.append( "Sua forma sintática é:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "para variavel = expressão ate expressão comando" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Um exemplo de Laço Para esta ilustrado abaixo:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "para i = 0 ate 20 {<br />" );
		sbAjuda.append( "escreva ( i );<br />" );
		sbAjuda.append( "}<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.9 - Comando de Laço Repita-Até</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando de Laço Repete-Até.<br />" );
		sbAjuda.append( "É semelhante a sintaxe da linguagem C.<br />" );
		sbAjuda.append( "Sua forma sintática é:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "repita comando ate ( condicao )" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Um exemplo de Laço Repita Ate esta ilustrado abaixo:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "repita {<br />" );
		sbAjuda.append( "k = k - 1;<br />" );
		sbAjuda.append( "} ate ( k = w );<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.10 - Comando de Laço Repita-Enquanto</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando de repeta - Enquanto.<br />" );
		sbAjuda.append( "É semelhante a sintaxe da linguagem C.<br />" );
		sbAjuda.append( "Sua forma sintática é:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "repita comando enquanto ( condicao )" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Um exemplo de Laço Repita Enquanto esta ilustrado abaixo:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "repita {<br />" );
		sbAjuda.append( "escreva ( i );<br />" );
		sbAjuda.append( "escreva ( j );<br />" );
		sbAjuda.append( "j = j + 1;<br />" );
		sbAjuda.append( "} enquanto (j = i );<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.11 - Comando de Apaga Tela</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando Apaga Tela.<br />" );
		sbAjuda.append( "É semelhante a sintaxe da linguagem C.<br />" );
		sbAjuda.append( "Sua forma sintática é:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Um exemplo de Apaga Tela esta ilustrado abaixo:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "apagaTela;<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.12 - Comando Para Inteiro</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando Para Inteiro.<br />" );
		sbAjuda.append( "É semelhante a sintaxe da linguagem C.<br />" );
		sbAjuda.append( "Sua forma sintática é:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "paraInteiro ( expressao_caracter )" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Um exemplo de Para Inteiro esta ilustrado abaixo:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "paraInteiro( c );<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=green size=+1>2.13 - Comando Va Para </font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "O comando Va Para.<br />" );
		sbAjuda.append( "É semelhante a sintaxe da linguagem C.<br />" );
		sbAjuda.append( "Sua forma sintática é:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "va para #rotulo" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=blue size=+1>" );
		sbAjuda.append( "Um exemplo de Va Para esta ilustrado abaixo:<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<font color=red size=+1>" );
		sbAjuda.append( "#rotulo;<br />" );
		sbAjuda.append( "x = x + 1;<br />" );
		sbAjuda.append( "se(x &lt; 3) entao{<br />" );
		sbAjuda.append( "va para #rotulo;<br />" );
		sbAjuda.append( "}<br />" );
		sbAjuda.append( "</font>" );
		sbAjuda.append( "<br />" );
		
		
		// Samuel end
		
		
		sbAjuda.append( "<br />" );
		sbAjuda.append( "<br />" );
		sbAjuda.append( "</html>" );
		
		textoAjuda = new JEditorPane();
		textoAjuda.setBorder(BorderFactory.createEmptyBorder());
		textoAjuda.setContentType("text/html");
		textoAjuda.setText(sbAjuda.toString());
		textoAjuda.setEditable(false);
		
		scpAjuda = new JScrollPane(textoAjuda, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,  
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);  
		
		scpAjuda.setBorder( BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Ajuda Verto"),
                BorderFactory.createEmptyBorder(0,10,0,0)) );

		
		Container container = getContentPane();
		
		painelAjuda = new JPanel();
		painelAjuda.setLayout( new BorderLayout() );
		painelAjuda.add( lblTitulo, BorderLayout.NORTH );
		painelAjuda.add( scpAjuda, BorderLayout.CENTER );
		painelAjuda.setBorder( BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5,10,10,10) ) );
		
		
		container.add( painelAjuda );

		Image icone = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource( "imagens/mp.png" )); 
		setIconImage(icone); 
		
		this.setLocation( 100, 50 );
		setSize(800,600);
		final WordSearcher searcher = new WordSearcher(textoAjuda);
		
		textoAjuda.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F){
					String palavra  = JOptionPane.showInputDialog("Palavra desejada:");
					if(palavra !=null && palavra.length()>0){
						
			        int offset = searcher.search(palavra.trim());
			        if (offset != -1) {
			          try {
			        	  textoAjuda.scrollRectToVisible(textoAjuda
			                .modelToView(offset));
			          } catch (BadLocationException x) {
			          }
			        }
					}
				}
				
			}
		});
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				textoAjuda.scrollRectToVisible(new Rectangle(0,0));
			}
		});
		setVisible(true);
	}	
	
		  public static String word;

		  public static Highlighter highlighter = new UnderlineHighlighter(null);
}

		// A simple class that searches for a word in
		// a document and highlights occurrences of that word

		class WordSearcher {
		  public WordSearcher(JTextComponent comp) {
		    this.comp = comp;
		    this.painter = (HighlightPainter) new UnderlineHighlighter.UnderlineHighlightPainter(Color.yellow);
		  }

		  // Search for a word and return the offset of the
		  // first occurrence. Highlights are added for all
		  // occurrences found.
		  public int search(String word) {
		    int firstOffset = -1;
		    Highlighter highlighter = comp.getHighlighter();

		    // Remove any existing highlights for last word
		    Highlighter.Highlight[] highlights = highlighter.getHighlights();
		    for (int i = 0; i < highlights.length; i++) {
		      Highlighter.Highlight h = highlights[i];
		      if (h.getPainter() instanceof UnderlineHighlighter.UnderlineHighlightPainter) {
		        highlighter.removeHighlight(h);
		      }
		    }

		    if (word == null || word.equals("")) {
		      return -1;
		    }

		    // Look for the word we are given - insensitive search
		    String content = null;
		    try {
		      Document d = comp.getDocument();
		      content = d.getText(0, d.getLength()).toLowerCase();
		    } catch (BadLocationException e) {
		      // Cannot happen
		      return -1;
		    }

		    word = word.toLowerCase();
		    int lastIndex = 0;
		    int wordSize = word.length();

		    while ((lastIndex = content.indexOf(word, lastIndex)) != -1) {
		      int endIndex = lastIndex + wordSize;
		      try {
		        highlighter.addHighlight(lastIndex, endIndex, painter);
		      } catch (BadLocationException e) {
		        // Nothing to do
		      }
		      if (firstOffset == -1) {
		        firstOffset = lastIndex;
		      }
		      lastIndex = endIndex;
		    }

		    return firstOffset;
		  }

		  protected JTextComponent comp;

		  protected Highlighter.HighlightPainter painter;

		}

		class UnderlineHighlighter extends DefaultHighlighter {
		  public UnderlineHighlighter(Color c) {
		    painter = (HighlightPainter) (c == null ? sharedPainter : new UnderlineHighlightPainter(c));
		  }

		  // Convenience method to add a highlight with
		  // the default painter.
		  public Object addHighlight(int p0, int p1) throws BadLocationException {
		    return addHighlight(p0, p1, painter);
		  }

		  public void setDrawsLayeredHighlights(boolean newValue) {
		    // Illegal if false - we only support layered highlights
		    if (newValue == false) {
		      throw new IllegalArgumentException(
		          "UnderlineHighlighter only draws layered highlights");
		    }
		    super.setDrawsLayeredHighlights(true);
		  }

		  // Painter for underlined highlights
		  public static class UnderlineHighlightPainter extends
		      LayeredHighlighter.LayerPainter {
		    public UnderlineHighlightPainter(Color c) {
		      color = c;
		    }

		    public void paint(Graphics g, int offs0, int offs1, Shape bounds,
		        JTextComponent c) {
		      // Do nothing: this method will never be called
		    }

		    public Shape paintLayer(Graphics g, int offs0, int offs1, Shape bounds,
		        JTextComponent c, View view) {
		      g.setColor(color == null ? c.getSelectionColor() : color);

		      Rectangle alloc = null;
		      if (offs0 == view.getStartOffset() && offs1 == view.getEndOffset()) {
		        if (bounds instanceof Rectangle) {
		          alloc = (Rectangle) bounds;
		        } else {
		          alloc = bounds.getBounds();
		        }
		      } else {
		        try {
		          Shape shape = view.modelToView(offs0,
		              Position.Bias.Forward, offs1,
		              Position.Bias.Backward, bounds);
		          alloc = (shape instanceof Rectangle) ? (Rectangle) shape
		              : shape.getBounds();
		        } catch (BadLocationException e) {
		          return null;
		        }
		      }

		      FontMetrics fm = c.getFontMetrics(c.getFont());
		      int baseline = alloc.y + alloc.height - fm.getDescent() + 1;
		      g.drawLine(alloc.x, baseline, alloc.x + alloc.width, baseline);
		      g.drawLine(alloc.x, baseline + 1, alloc.x + alloc.width,
		          baseline + 1);
		      g.fill3DRect(alloc.x,baseline-18, alloc.width, alloc.height, true);

		      return alloc;
		    }

		    protected Color color; // The color for the underline
		  }

		  // Shared painter used for default highlighting
		  protected static final Highlighter.HighlightPainter sharedPainter = new UnderlineHighlightPainter(
		      null);

		  // Painter used for this highlighter
		  protected Highlighter.HighlightPainter painter;
}

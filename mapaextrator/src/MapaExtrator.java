import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

import ui.LineNumberedBorder;
import utils.BasicGraphEditor;
import utils.GraphEditor;
import utils.LicencaGnu;
import utils.LicencaNuvola;
import utils.TeclaListener;
import utils.ajuda.AjudaMapaExtrator;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;


public class MapaExtrator extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu 						menuArquivo;
	private static String 				TITULO = "MapaExtrator 1.0.0"; 
	private static MapaExtrator 		mySelf;
	private JTabbedPane 				pastasAbas;
	private JTextArea 					textEditor;
	private JTextArea 					textSentencas;
	private JTextArea 					textTriades;
	private JTextArea 					textMapaConceitual;
	private JTextField             	 	txtConceitoGeral;
	private Hashtable<String, Vertice> 	tabelaVertices;
	private int 						proximaLinha;
	private int                         proximaColuna;

	// Vetor de Padrões para identificação
	@SuppressWarnings("rawtypes")
	public Vector padroes;

	// Vetor de Padrões para identificação
	@SuppressWarnings("rawtypes")
	public Vector triades;

	// Variaveis publicas criadas pelo Pablo
	public JPanel panelMapaConceitual =  new GraphEditor();
	
	private String [] sentencas;
	
	EditorListener editorListener = new EditorListener();
	
	private static CompoundBorder LINE_BORDER= BorderFactory.createCompoundBorder(
			new LineNumberedBorder(LineNumberedBorder.LEFT_SIDE,LineNumberedBorder.LEFT_JUSTIFY),
            javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, Color.LIGHT_GRAY)
            );
	

	public MapaExtrator() {
		
		super( TITULO );
		
		Image icone = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource( "imagens/mp.png" )); 
		setIconImage(icone); 
	
		mySelf = this;
		
		setJMenuBar( getMenuMapaExtrator() );
		
		Container container = getContentPane();
		container.setLayout( new BorderLayout() );
		
//		container.add( getPainelTopo(), BorderLayout.NORTH );
		pastasAbas = (JTabbedPane) getPainelCentral();
		container.add( pastasAbas, BorderLayout.CENTER );
		container.add( getPainelSul(), BorderLayout.SOUTH );
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		setSize( 1000, 750 );
		setLocationRelativeTo(null); 
		
		
	}
	
	public static void main( String args[] ) {
		/*	Futura mudança no layout para deixar com
		 *  cara de Windows
		 */
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		mxConstants.SHADOW_COLOR = Color.LIGHT_GRAY;
		mxConstants.W3C_SHADOWCOLOR = "#D3D3D3";
		MapaExtrator v = new MapaExtrator();
		v.setVisible( true );
	}
	
	private JMenuBar getMenuMapaExtrator() {

	    JMenuBar menubar = new JMenuBar();
	    menuArquivo = new JMenu( "Arquivo" );

	    carregaMenuArquivo( menubar );
	    
	    JMenu ajuda = new JMenu("Ajuda");
	    menubar.add(ajuda);
	    
	    ajuda.add( criaItemMenuTeclaChave( "Ajuda do MapaExtrator", "Ajuda",'A', new ImageIcon( getClass().getClassLoader().getResource( "imagens/ajudaG.png" ) ) ) );
        ajuda.insertSeparator(1);
	    ajuda.add( criaItemMenuTeclaChave( "Sobre o MapaExtrator", "SobreMapaExtrator",'S', new ImageIcon( getClass().getClassLoader().getResource( "imagens/sobreG.png" ) ) ) );
	    ajuda.add( criaItemMenuTeclaChave( "Licença GNU", "Gnu",'G', new ImageIcon( getClass().getClassLoader().getResource( "imagens/gnuG.png" ) ) ) );
	    ajuda.add(criaItemMenuTeclaChave("Licença Nuvola", "Nuvola", 'N',
				new ImageIcon(getClass().getClassLoader().getResource(
						"imagens/nuvollaG.png"))));    
	    return menubar;	
	}
	
	private void carregaMenuArquivo( JMenuBar menubar ) {
		
		menuArquivo.removeAll();
		menuArquivo.add( criaItemMenu( "Novo", "Novo",'N', new ImageIcon( getClass().getClassLoader().getResource( "imagens/novo.png" ) ) ) );
//		menuArquivo.add( criaItemMenu( "Abrir", "Abrir",'A', new ImageIcon( getClass().getClassLoader().getResource( "imagens/arquivoG.png" ) ) ) );
//		menuArquivo.add( criaItemMenu( "Salvar", "Salvar",'S', new ImageIcon( getClass().getClassLoader().getResource( "imagens/salvarG.png" ) )  ) );
//		menuArquivo.add( criaItemMenu( "Salvar Como", "SalvarComo",'C', new ImageIcon( getClass().getClassLoader().getResource( "imagens/salvarcomoG.png" ) ) ) );
	    menuArquivo.add( criaItemMenu( "Finalizar", "Finalizar",'F', new ImageIcon( getClass().getClassLoader().getResource( "imagens/sairG.png" ) ) ) );
    	
	    menubar.add(menuArquivo, 0);
	}
	
	private Component criaItemMenu( String titulo, String acao ) {

		JMenuItem it = new JMenuItem( titulo );
		it.setActionCommand( acao );
		it.addActionListener( this );
		
		return it;
	}

	private Component criaItemMenu( String titulo, String acao, char teclaAtalho, ImageIcon icone  ) {

		JMenuItem it = new JMenuItem( titulo, teclaAtalho );
		it.setIcon( icone );
		it.setActionCommand( acao );
		it.addActionListener( this );
		
		return it;
	}

	private Component criaItemMenu( String titulo, String acao, ImageIcon icone  ) {

		JMenuItem it = new JMenuItem( titulo );
		it.setIcon( icone );
		it.setActionCommand( acao );
		it.addActionListener( this );
		
		return it;
	}
	
	private Component criaItemMenuTeclaChave( String titulo, String acao, char teclaAtalho ) {

		JMenuItem it = new JMenuItem( titulo );
		it.setAccelerator(KeyStroke.getKeyStroke(teclaAtalho,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));		
		it.setActionCommand( acao );
		it.addActionListener( this );
		
		return it;
	}

	private Component criaItemMenuTeclaChave( String titulo, String acao, char teclaAtalho, ImageIcon icone  ) {

		JMenuItem it = new JMenuItem( titulo );
		it.setAccelerator(KeyStroke.getKeyStroke(teclaAtalho,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));		
		it.setIcon( icone );
		it.setActionCommand( acao );
		it.addActionListener( this );
		
		return it;
	}

	private Component getPainelTopo() {

		JToolBar painelTopo = new JToolBar();
		painelTopo.setFloatable( false );

//		JButton btnNovo = new JButton( new ImageIcon( getClass().getClassLoader().getResource( "imagens/novo_small.png" ) ) );
//		btnNovo.setToolTipText( "Novo" );
//		btnNovo.setActionCommand( "Novo" );
//		
//		btnNovo.addActionListener( this );
//		painelTopo.add( btnNovo );
//		
//		JButton btn = new JButton( new ImageIcon( getClass().getClassLoader().getResource( "imagens/arquivo.png" ) ) );
//		btn.setToolTipText( "Abrir arquivo" );
//		btn.setActionCommand( "Abrir" );
//		
//		btn.addActionListener( this );
//		painelTopo.add( btn );
//		
//		JButton btn1 = new JButton( new ImageIcon( getClass().getClassLoader().getResource( "imagens/salvar.png" ) ) );
//		btn1.setToolTipText( "Salvar" );
//		btn1.setActionCommand( "Salvar" );
//		
//		btn1.addActionListener( this );
//		painelTopo.add( btn1 );
//
//		JButton btn2 = new JButton( new ImageIcon( getClass().getClassLoader().getResource( "imagens/salvarcomo.png" ) ) );
//		btn2.setToolTipText( "Salvar Como" );
//		btn2.setActionCommand( "SalvarComo" );
//		
//		btn2.addActionListener( this );
//		painelTopo.add( btn2 );
		
		JButton btn3 = new JButton( new ImageIcon( getClass().getClassLoader().getResource( "imagens/ajuda.png" ) ) );
		btn3.setToolTipText( "Exibe Tela de Ajuda" );
		btn3.setActionCommand( "Ajuda" );
		
		btn3.addActionListener( this );
		painelTopo.add( btn3 );
		
		JButton btn4 = new JButton( new ImageIcon( getClass().getClassLoader().getResource( "imagens/sobre.png" ) ) );
		btn4.setToolTipText( "Exibe créditos do MapaExtrator" );
		btn4.setActionCommand( "SobreMapaExtrator" );
		
		btn4.addActionListener( this );
		painelTopo.add( btn4 );

		JButton btn5 = new JButton( new ImageIcon( getClass().getClassLoader().getResource( "imagens/gnu.png" ) ) );
		btn5.setToolTipText( "Exibe Licença GNU" );
		btn5.setActionCommand( "Gnu" );
		
		btn5.addActionListener( this );
		painelTopo.add( btn5 );

		JButton btn6 = new JButton( new ImageIcon( getClass().getClassLoader().getResource( "imagens/sair.png" ) ) );
		btn6.setToolTipText( "Sair do Ambiente" );
		btn6.setActionCommand( "Finalizar" );
		
		btn6.addActionListener( this );
		painelTopo.add( btn6 );

		return painelTopo;
	}


	private JComponent getPainelCentral() {

		JTabbedPane tabbedPane = new JTabbedPane();
		
        JComponent panelE = getAreaEditor();
        tabbedPane.addTab( "Editor", panelE );
        
        JComponent panelP = getAreaParametros();
        tabbedPane.addTab( "Parâmetros", panelP );
        
        JComponent panelS = getAreaSentencas();
        tabbedPane.addTab( "Sentenças", panelS );

        JComponent panelC = getAreaConceitosRelacionados();
        tabbedPane.addTab( "Conceitos Relacionados", panelC );

        JComponent panelM = getAreaMapaConceitual();
        tabbedPane.addTab( "Mapa Conceitual", panelM );
        
		return tabbedPane;
	}

	private JComponent getAreaParametros() {
		
		JPanel panel = new JPanel();
		panel.setLayout( null );
		
		JLabel lblConceitoGeral = new JLabel( "Conceito Principal" );
		lblConceitoGeral.setBounds( 10, 10, 200, 25 );
		panel.add( lblConceitoGeral );
		
		txtConceitoGeral = new JTextField();
		txtConceitoGeral.setBounds(10, 35, 200, 25);
		panel.add( txtConceitoGeral );
		
		return panel;
	}
	
	private JComponent getAreaEditor() {

		JPanel panel = new JPanel();
		panel.setLayout( null );
		textEditor = criaCodigoArea();
		textEditor.setFont( new Font( "Courier", Font.PLAIN, 12 ) );
		textEditor.setEditable( true );
		JScrollPane scroller = new JScrollPane( textEditor ); 

		textEditor.addFocusListener( editorListener );
		TeclaListener keyListener = new TeclaListener( textEditor );
		textEditor.addKeyListener( keyListener );

		JLabel descricao = new JLabel( "Texto para análise" );
		descricao.setBounds( 10, 10, 500, 30 );
		panel.add( descricao );
		
		scroller.setBounds(10, 40, 940, 500 );
		panel.add( scroller );
		
		return panel;
	}
	
	private JComponent getAreaSentencas() {

		JPanel panel = new JPanel();
		panel.setLayout( null );

		textSentencas = criaCodigoArea();
		textSentencas.setFont( new Font( "Courier", Font.PLAIN, 12 ) );
		textSentencas.setEditable( true );
		JScrollPane scroller = new JScrollPane( textSentencas ); 

		textSentencas.addFocusListener( editorListener );
		TeclaListener keyListener = new TeclaListener( textSentencas );
		textSentencas.addKeyListener( keyListener );

		JLabel descricao = new JLabel( "Sentenças" );
		descricao.setBounds( 10, 10, 500, 30 );
		
		panel.add( descricao );
		
		scroller.setBounds(10, 40, 940, 500 );
		
		panel.add( scroller );
		
		return panel;
	}
	
	private JComponent getAreaConceitosRelacionados() {

		JPanel panel = new JPanel();
		panel.setLayout( null );

		textTriades = criaCodigoArea();
		textTriades.setFont( new Font( "Courier", Font.PLAIN, 12 ) );
		textTriades.setEditable( true );
		JScrollPane scroller = new JScrollPane( textTriades ); 

		textTriades.addFocusListener( editorListener );
		TeclaListener keyListener = new TeclaListener( textTriades );
		textTriades.addKeyListener( keyListener );

		JLabel descricao = new JLabel( "Conceitos relacionados" );
		descricao.setBounds( 10, 10, 500, 30 );
		
		panel.add( descricao );
		
		scroller.setBounds(10, 40, 940, 500 );
		
		panel.add( scroller );
		
		return panel;
	}
	private JComponent getAreaMapaConceitual() {
        return panelMapaConceitual;
	}

	private JTextArea criaCodigoArea() {
		
		JTextArea tArea = new JTextArea( 30, 71 );
		tArea.setLineWrap( true );
		tArea.setEnabled( true );
		tArea.setAutoscrolls( true );
		tArea.setFocusable( true );
		tArea.setBorder(LINE_BORDER);
		return tArea;
	}
	
	
	private JComponent getPainelSul() {
		
		JPanel painel = new JPanel();
		painel.setPreferredSize(new Dimension(0,40));

		JButton btnGerarConceitos = new JButton( "Gerar Conceitos", new ImageIcon( getClass().getClassLoader().getResource( "imagens/salvar.png" ) ) );
		btnGerarConceitos.setPreferredSize(new Dimension(250,30));
		
		btnGerarConceitos.setActionCommand( "GerarConceitos" );
		btnGerarConceitos.addActionListener( this );
		
		JButton btnGerarMapas = new JButton( "Gerar Mapas Conceituais", new ImageIcon( getClass().getClassLoader().getResource( "imagens/mp.png" ) ) );
		btnGerarMapas.setPreferredSize(new Dimension(250,30));
		btnGerarMapas.setActionCommand( "GerarMapas" );
		btnGerarMapas.addActionListener( this );
		
		painel.add( btnGerarConceitos );
		painel.add( btnGerarMapas );
		
		return painel;
	}
	
	public static final BasicGraphEditor getEditor(Component[] listaComponentes)
	{
		BasicGraphEditor editor = null;
		for (int i = 0; i < listaComponentes.length; i++ ){

			if (listaComponentes[i] != null
					&& (listaComponentes[i] instanceof BasicGraphEditor))
				editor = (BasicGraphEditor) listaComponentes[i];
		}
		return editor;
	}
	
	public void actionPerformed( ActionEvent arg0 ) {

		if( arg0.getActionCommand().equals( "Abrir" ) ) {
			// abreArquivo();
		} else if ( arg0.getActionCommand().equals( "Salvar" ) ) {
			// salvaArquivo();
		} else if ( arg0.getActionCommand().equals( "GerarConceitos" ) ) {
			geraConceitos();
		} else if ( arg0.getActionCommand().equals( "GerarMapas" ) ) {
			geraMapa();
		} else if ( arg0.getActionCommand().equals( "Novo" ) ) {
			int resposta = JOptionPane.showConfirmDialog(this, "Deseja abrir um novo editor?", "Novo arquivo", JOptionPane.YES_NO_OPTION);
			if(resposta==JOptionPane.YES_OPTION){
				// novo();
			}
		} else if ( arg0.getActionCommand().equals( "SalvarComo" ) ) {
			// salvaArquivoComo();
		} else if ( arg0.getActionCommand().equals( "SobreMapaExtrator" ) ) {
			mostraSobreMapaExtrator();
		} else if ( arg0.getActionCommand().equals( "Ajuda" ) ) {
			abreAjuda();
		} else if ( arg0.getActionCommand().equals( "Gnu" ) ) {
			licencaGnu(); 
		} else if (arg0.getActionCommand().equals("Nuvola")) {
			licencaNuvola();			
		}else if( arg0.getActionCommand().equals( "Finalizar" ) ) {
			finaliza();
		}
	}
	
	
	/**
	 * Algoritmo principal
	 */
	private void geraConceitos() {
		geraSentencas();
		identificaPadroes();
		pastasAbas.setSelectedIndex(3);
	}
	
	/**
	 * Gera sentenças: Separa as sentenças do texto.
	 */
	private void geraSentencas() {
		boolean sentencaValida = false;
		
		if(textEditor.getText() != null && textEditor.getText().length() > 0){
		/*
		 *  Dentro da expressão pego tanto "." quanto ";" e o que mais for necessário, 
		 *  basta adicionar entre os colchetes.
		 */
			sentencas = textEditor.getText().split("[\\.;,]");
			sentencaValida = true;
		}else{
			JOptionPane.showMessageDialog( null, "Insira um texto antes de gerar sentenças.");
			sentencaValida = false;
		}
		if(sentencaValida){
			StringBuilder sb = new StringBuilder();
			if(sentencas != null && sentencas.length > 0){
				for ( int i=0; i < sentencas.length; i++ ) {
					sb.append( sentencas[ i ].trim().toLowerCase() );
					sb.append( ".\n" );
				}
				
				textSentencas.setText( sb.toString() );
			}else{
				JOptionPane.showMessageDialog( null, "Não puderam ser geradas sentenças\n " +
				"a partir do texto informado." );
			}
		}
	}

	/**
	 * Gera sentenças: Separa as sentenças do texto.
	 */
	private void identificaPadroes() {
		
		padroes = new Vector();
		triades = new Vector();
		StringBuilder sb = new StringBuilder();
		String coringaArmazenado = "?";
		
		Padrao.populaPadroes( padroes );
		
		if(sentencas != null && sentencas.length > 0 ){
			// Separador para console, facilitando o debug.
			System.out.println( "----------------------------------------------------------------------" );
			for ( int i=0; i< sentencas.length; i++ ) {
				
				Padrao pd = buscaPadraoQueEncaixa( sentencas[ i ], coringaArmazenado ); 
				
				if ( pd != null ) {

					coringaArmazenado = pd.getCoringaArmazenado();
					
					if ( pd.getTriadeGerada1()[0] != null && !pd.getTriadeGerada1()[0].trim().equalsIgnoreCase("") ) {
						triades.add( pd.getTriadeGerada1().clone() );
	
						sb.append( pd.getTriadeGerada1().clone()[0] );
						sb.append( "|" );
						sb.append( pd.getTriadeGerada1().clone()[1] );
						sb.append( "|" );
						sb.append( pd.getTriadeGerada1().clone()[2] );
						sb.append( "\n" );
					}
	
					if ( pd.getTriadeGerada2()[0] != null && !pd.getTriadeGerada2()[0].trim().equalsIgnoreCase("") ) {
						triades.add( pd.getTriadeGerada2().clone() );
	
						sb.append( pd.getTriadeGerada2().clone()[0] );
						sb.append( "|" );
						sb.append( pd.getTriadeGerada2().clone()[1] );
						sb.append( "|" );
						sb.append( pd.getTriadeGerada2().clone()[2] );
						sb.append( "\n" );
					}

					if ( pd.getTriadeGerada3()[0] != null && !pd.getTriadeGerada3()[0].trim().equalsIgnoreCase("") ) {
						triades.add( pd.getTriadeGerada3().clone() );
	
						sb.append( pd.getTriadeGerada3().clone()[0] );
						sb.append( "|" );
						sb.append( pd.getTriadeGerada3().clone()[1] );
						sb.append( "|" );
						sb.append( pd.getTriadeGerada3().clone()[2] );
						sb.append( "\n" );
					}
					
				}
				textTriades.setText( sb.toString().toLowerCase() );
				
				if ( pd==null ) {
					System.out.println( "PADRAO_NULO" );
				} else {
					System.out.println( "Ricardo " + pd.getPadraoDeBusca().clone()[0] + " " + pd.getCoringas().clone()[0] + " " + pd.getCoringas().clone()[1] );
				}
			}
		}			
		
		Padrao a = (Padrao) padroes.elementAt( 0 );
		String [] b = a.getPadraoDeBusca();

	}
	
	
	private Padrao buscaPadraoQueEncaixa( String frase, String coringaArmazenado ) {
		
		String [] palavras = frase.split( " " );
		
		boolean achouPadrao = false;
		boolean padraoNaoCasa = false;
		int atual = 0;               // variável de controle para percorrer todos os padrões
		int coringaAtual = 1;
		Padrao padraoAtual;
		String [] padrao;			// frase padrão
		String [] coringas = {"","","","","","","","","","","",""};
		
		int ponteiroTxt = 0, ponteiroPadrao = 0, ponteiroTextoPadrao = 0;

		// Esse laço percorre todos os padrões(objetos Pattern)
		while ( !achouPadrao && atual < padroes.size() ) {

			padraoAtual = (Padrao) padroes.get( atual );
			
			padrao  = (String []) padraoAtual.getPadraoDeBusca();	
			
			for ( int i=0; i<coringas.length; i++ ) {
				coringas[i] = "";
			}
			
			padraoNaoCasa = false;
			
			// Esse laço percorre todos os itens do array atual de strings.
			while ( ponteiroTxt < palavras.length && !padraoNaoCasa ) {
				
				if ( padrao[ ponteiroPadrao ].charAt( 0 ) == '#' ) {
					ponteiroTextoPadrao = ponteiroPadrao+1;
					coringaAtual = Integer.parseInt( padrao[ ponteiroPadrao ].substring(1,2) );
				}
				
				try {
					if ( ponteiroTextoPadrao >= padrao.length-1 ) {
						coringas[ coringaAtual ] = coringas[ coringaAtual ] + " " + palavras[ ponteiroTxt ];
						ponteiroTxt++;
					} else {
						if ( palavras[ ponteiroTxt ].matches( padrao[ ponteiroTextoPadrao ] ) || 
						     palavras[ ponteiroTxt ].equalsIgnoreCase( padrao[ ponteiroTextoPadrao ] )) {
							while ( palavras[ ponteiroTxt ].matches( padrao[ ponteiroTextoPadrao ] ) ||
									palavras[ ponteiroTxt ].equalsIgnoreCase( padrao[ ponteiroTextoPadrao ] ) ) {
								System.out.println( "considerou iguais: " + palavras[ ponteiroTxt ] + " " + padrao[ ponteiroTextoPadrao ] );
								ponteiroTxt++;
								ponteiroTextoPadrao++;
							}
							// Se após os matches, não vier um coringa e ainda tiver palavras, o padrão não casa.
							if ( ponteiroTxt < palavras.length ) {
								if ( padrao[ ponteiroTextoPadrao ].charAt( 0 ) != '#' ) {
									padraoNaoCasa = true;
									break;
								}
							}
							//
							ponteiroPadrao = ponteiroTextoPadrao;
							ponteiroTextoPadrao++;
						} else {
							coringas[ coringaAtual ] = coringas[ coringaAtual ] + " " + palavras[ ponteiroTxt ];
							ponteiroTxt++;
						}
					}
				} catch (Exception e ) {
					JOptionPane.showMessageDialog(null, e.getMessage() +  " ricardo pTxt = " + ponteiroTxt + " pPad = " + ponteiroPadrao + " pPadTxt= " + ponteiroTextoPadrao );
				}
				
			}
			
			if ( ponteiroTextoPadrao >= padrao.length-1 && !padraoNaoCasa ) {
				achouPadrao = true;
			}
			
			if ( achouPadrao ) {
				System.out.println( "casou= " + padraoAtual.consultaPadraoBusca() );
				padraoAtual.setCoringaArmazenado( coringaArmazenado );
				padraoAtual.setCoringas( coringas );
				padraoAtual.alimentaTriadesGeradas();
				padraoAtual.atualizaCoringaArmazenado();
				return padraoAtual;
			} else {
				System.out.println( "não casou= " + padraoAtual.consultaPadraoBusca() );
				atual++;
				ponteiroTxt = 0;
				ponteiroPadrao = 0;
				ponteiroTextoPadrao = 0;
				coringaAtual = 1;
			}
			
		}
		
		return null;
	}
	
	/**
	 * Gera Mapa
	 */
	private void geraMapa() {

		tabelaVertices = new Hashtable<String, Vertice>();
		proximaLinha  = 0;
		proximaColuna = 0;
		
		if(triades != null && triades.size() > 0){
			mxGraphComponent grafoBase = ((GraphEditor) getAreaMapaConceitual()).getMxGraphComponent();
			grafoBase.getGraph().removeCells();
			MapaConceitual.geraMapa(geraListaProposicao(triades), grafoBase);
			panelMapaConceitual.repaint();
			panelMapaConceitual.validate();
			mxGraphComponent grafoModificado = ((GraphEditor) getAreaMapaConceitual()).getMxGraphComponent();
			System.out.println(grafoModificado);
			pastasAbas.setSelectedIndex(4);
		}else{
			JOptionPane.showMessageDialog( null, "Insira um texto, e clique em Gerar Conceitos\n " +
					"antes de gerar um Mapa Conceitual." );
			pastasAbas.setSelectedIndex(0);
		}
	}
	
	private List<Proposicao> geraListaProposicao(Vector triades){
		
		List<Proposicao> proposicaoList = new ArrayList<Proposicao>();
		if(triades != null && triades.size() > 0 ){
			String[][] triadeArray = new String[triades.size()][triades.size()]; 
			for (int i = 0; i < triades.size(); i++) {
				triadeArray[i] = (String[]) triades.elementAt(i);
			}
			
			if ( txtConceitoGeral != null ) {
				Vertice verticeConceito  = new Vertice(txtConceitoGeral.getText(),405,5,calculaComprimento(txtConceitoGeral.getText()),250,null);
				tabelaVertices.put( txtConceitoGeral.getText(), verticeConceito );
			}
			
			for (String[] strings : triadeArray) {
				proposicaoList.add(geraProposicao(strings));
			}
		}
		
		return proposicaoList;
	}
	
	private int calculaComprimento( String text ) {
		return text.length()*5+120;
	}
	
	private Proposicao geraProposicao(String[] triade) {
		
		String nomeOrigem;
		String nomeDestino;
		Vertice verticePai;
		Vertice verticeFilho;
		int h, v;
		
		nomeOrigem = RemovedorDeStopWords.removeStopWords( triade[0] );
		nomeDestino = RemovedorDeStopWords.removeStopWords( triade[2] );

		if ( tabelaVertices.containsKey( nomeOrigem ) ) {
			verticePai = tabelaVertices.get( nomeOrigem );
		} else {
			v = buscaPosicaoVaziaVertical();
			h = buscaPosicaoVaziaHorizontal();
			
			verticePai    = new Vertice(nomeOrigem,h,v,calculaComprimento( nomeOrigem ),80, null);
			tabelaVertices.put( nomeOrigem, verticePai );
		}

		if ( tabelaVertices.containsKey( nomeDestino ) ) {
			verticeFilho = tabelaVertices.get( nomeDestino );
		} else {
			v = buscaPosicaoVaziaVertical();
			h = buscaPosicaoVaziaHorizontal();
			
			verticeFilho    = new Vertice(nomeDestino,h,v,calculaComprimento( nomeDestino ),80, null);
			tabelaVertices.put( nomeDestino, verticeFilho );
		}

		Aresta aresta 		  = new Aresta(null,triade[1],verticePai,verticeFilho,null);
		
		Proposicao proposicao = new Proposicao( verticePai, verticeFilho, aresta );
		
		return proposicao;
	}

	private int buscaPosicaoVaziaHorizontal() {

		int [] vh = { 405, 705, 205, 805, 105, 905, 5, 605, 305, 505 };
		
		int coluna = vh[ proximaColuna ];
		
		proximaColuna++;
		
		if ( proximaLinha > 10 ) {
			return 450;
		}

		if ( proximaColuna > 9 ) {
			proximaColuna = 0;
			proximaLinha++;
		}
		
		return coluna;
	}

	private int buscaPosicaoVaziaVertical() {
		
		int [] vv = { 5, 75, 145, 215, 285, 355, 425, 495, 585, 655, 725 };

		int linha = vv[ proximaLinha ];
		
		if ( proximaLinha == 0 ) {
			proximaLinha++;
		}
		
		if ( proximaLinha > 10 ) {
			return 700;
		}
		
		return linha;
	}


	private void mostraSobreMapaExtrator() {
		
		JLabel lblAutores;
		JLabel lblColaboradores;
		JPanel pnlSobre;
		JLabel lblMapaExtrator;
		JLabel lblRodape;
		JPanel painelSobre = new JPanel();
		
		StringBuffer sb1 = new StringBuffer();
		sb1.append( "<html>" );
		sb1.append( "<font color=blue size=+2>MapaExtrator 1.0.0</font>" );
		lblMapaExtrator = new JLabel( sb1.toString() ); 
		sb1.append( "</html>" );

		lblMapaExtrator.setBorder( BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(""),
                BorderFactory.createEmptyBorder(5,10,10,10)) );		

		StringBuffer sb2 = new StringBuffer();
		
		sb2.append( "<html>" );
		sb2.append( "<TABLE BORDER=0>" );
		sb2.append( "<TR><TD>" );
		sb2.append( "Pablo Frederico Oliveira Thiele <br>" );
		sb2.append( "<font color=green><i>pablothiele@gmail.com</i></font>" );
		sb2.append( "<br><br>" ); 
		sb2.append( "Ricardo Ferreira de Oliveira<br>" );
		sb2.append( "<font color=green><i>ricardofo@feevale.br</i></font>" );
		sb2.append( "</TD></TR>" );
		sb2.append( "</html>" );
		
		lblAutores = new JLabel( sb2.toString() ); 
		
		lblAutores.setBorder( BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Autores:"),
                BorderFactory.createEmptyBorder(10,10,10,10)) );		
		
		StringBuffer sb3 = new StringBuffer();
		sb3.append( "<html>" );
		sb3.append( "<font color=green><i>http://Mapaextrator.sf.net</i></font>" );
		sb3.append( "</html>" );
		
		lblColaboradores = new JLabel( sb3.toString() ); 

		lblColaboradores.setBorder( BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Projeto no SourceForge"),
                BorderFactory.createEmptyBorder(10,10,10,10)) );		
		
		pnlSobre = new JPanel();
		pnlSobre.setLayout( new BorderLayout() );
		pnlSobre.add( lblAutores, BorderLayout.CENTER );
		pnlSobre.add( lblColaboradores, BorderLayout.SOUTH );
		
		StringBuffer sb4 = new StringBuffer();
		sb4.append( "<html>" );
		sb4.append( "<font color=blue>" );
		sb4.append( "Desenvolvido na Universidade Feevale" );
		sb4.append( "<br>" );
		sb4.append( "Novo Hamburgo - RS" );
		sb4.append( "<br>" );
		sb4.append( "Versão 1.0.0 - abril/2011" );
		sb4.append( "</font>" );
		sb4.append( "</html>" );

		lblRodape = new JLabel( sb4.toString() ); 

		lblRodape.setBorder( BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(""),
                BorderFactory.createEmptyBorder(10,10,10,10)) );		
	
		painelSobre.setLayout( new BorderLayout() );
		painelSobre.add( lblMapaExtrator, BorderLayout.NORTH );
		
		painelSobre.add(pnlSobre, BorderLayout.CENTER );
		painelSobre.add( lblRodape, BorderLayout.SOUTH );
		
		JOptionPane.showMessageDialog( null, painelSobre, "Sobre o MapaExtrator", JOptionPane.INFORMATION_MESSAGE );
	}

	private void abreAjuda() {
		AjudaMapaExtrator ajudaMapaExtrator = new AjudaMapaExtrator();
		ajudaMapaExtrator.setVisible( true );	
	}
	
	private void licencaGnu() {
		LicencaGnu licencaGnu = new LicencaGnu();
		licencaGnu.setVisible( true );	
	}
	
	private void licencaNuvola() {
		LicencaNuvola licencaNuvola = new LicencaNuvola();
		licencaNuvola.setVisible(true);
	}	

	private void finaliza(){
		System.exit( 0 );
	}
	
	class EditorListener implements FocusListener {

		public void focusGained(FocusEvent arg0) {
		}

		public void focusLost(FocusEvent arg0) {
		}
	}
}

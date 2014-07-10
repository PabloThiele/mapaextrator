

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Hashtable;
import java.util.List;

import utils.BasicGraphEditor;

import com.mxgraph.swing.mxGraphComponent;

public class MapaConceitual 
{
	public static  mxGraphComponent geraMapaConceitual(final List<Proposicao> listaProposicoes,mxGraphComponent grafoBase ){
		
		Object v1;
		Object v2;
		
		grafoBase.getGraph().setAllowDanglingEdges(false);
		Object parent = grafoBase.getGraph().getDefaultParent();
		Hashtable<String, Object> 	tabelaVertices = new Hashtable<String, Object>();
		
		grafoBase.getGraph().getModel().beginUpdate();
		
		grafoBase.getGraph().setCollapseToPreferredSize( true );  
		
		try
		{
			for (Proposicao proposicao : listaProposicoes) {
				
				// Vertice Pai
				if ( tabelaVertices.containsKey( proposicao.getVerticePai().getNome() ) ) {
					v1 = tabelaVertices.get( proposicao.getVerticePai().getNome() );
				} else {
					v1 = grafoBase.getGraph().insertVertex(
							parent, 
							proposicao.getVerticePai().getId(), 
							proposicao.getVerticePai().getNome(), 
							proposicao.getVerticePai().getCoordenadaX(), 
							proposicao.getVerticePai().getCoordenadaY(),
							proposicao.getVerticePai().getLargura(),
							proposicao.getVerticePai().getAltura(),
							proposicao.getVerticePai().getEstilo()
							);
					tabelaVertices.put( proposicao.getVerticePai().getNome(), v1 );
				}

				// Vertice Filho
				if ( tabelaVertices.containsKey( proposicao.getVerticeFilho().getNome() ) ) {
					v2 = tabelaVertices.get( proposicao.getVerticeFilho().getNome() );
				} else {
					v2 = grafoBase.getGraph().insertVertex(
							parent, 
							proposicao.getVerticeFilho().getId(), 
							proposicao.getVerticeFilho().getNome(), 
							proposicao.getVerticeFilho().getCoordenadaX(), 
							proposicao.getVerticeFilho().getCoordenadaY(),
							proposicao.getVerticeFilho().getLargura(),
							proposicao.getVerticeFilho().getAltura(),
							proposicao.getVerticeFilho().getEstilo());
					tabelaVertices.put( proposicao.getVerticeFilho().getNome(), v2 );
				}
				

				// Aresta
				grafoBase.getGraph().insertEdge(
						parent, 
						proposicao.getAresta().getId(), 
						proposicao.getAresta().getNome(), 
						v1, 
						v2,
						proposicao.getAresta().getEstilo());
				
			}
		}
		finally
		{
			grafoBase.getGraph().getModel().endUpdate();
		}
		
		return grafoBase;
		
	}
	
	/**
	 * 
	 * @param e
	 * @return Returns the graph for the given action event.
	 */
	public static final BasicGraphEditor getEditor(ActionEvent e)
	{
		if (e.getSource() instanceof Component)
		{
			Component component = (Component) e.getSource();

			while (component != null
					&& !(component instanceof BasicGraphEditor))
			{
				component = component.getParent();
			}

			return (BasicGraphEditor) component;
		}

		return null;
	}
	
	
//	public static void geraImagemMapa(final List<Proposicao> listaProposicoes, TipoImagem tipoImagem){
//		mxGraph graph = geraMapaConceitual(listaProposicoes);
//	}
	
	public static mxGraphComponent geraMapa(final List<Proposicao> listaProposicoes, mxGraphComponent grafoBase){
		mxGraphComponent graphComponent = geraMapaConceitual(listaProposicoes, grafoBase );
		//mxGraphComponent graphComponent = new mxGraphComponent(graph);
		// graphComponent.setPreferredSize( new Dimension( 980, 570 ) );
		
		return graphComponent;
	}
	
}

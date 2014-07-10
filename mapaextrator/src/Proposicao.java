

public class Proposicao
{
	// A proposição é a composiçao de DOIS vertices ligados via uma aresta
	
	private Vertice verticePai;
	private Vertice verticeFilho;
	private Aresta aresta;
	
	public Proposicao( Vertice vp, Vertice vf, Aresta a ) {
		verticePai = vp;
		verticeFilho = vf;
		aresta = a;
	}
	

	public Vertice getVerticePai() {
		return verticePai;
	}


	public void setVerticePai(Vertice verticePai) {
		this.verticePai = verticePai;
	}


	public Vertice getVerticeFilho() {
		return verticeFilho;
	}


	public void setVerticeFilho(Vertice verticeFilho) {
		this.verticeFilho = verticeFilho;
	}


	public Aresta getAresta() {
		return aresta;
	}
	public void setAresta(Aresta aresta) {
		this.aresta = aresta;
	}
	
}

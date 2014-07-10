

public class Aresta
{
	/*
	 * mxGraph.insertEdge(parent, id, value, source, target, style) – 
	 * creates and 
	 * inserts a new edge into the model, within a begin/end update call.
	 * 
	 *	 */
	private Object pai;
	private String id; 
	private String nome;
	private Vertice origem;
	private Vertice destino;
	private String estilo;
	
	
	public Aresta() {}

	public Aresta(Object pai, String nome, Vertice origem,
			Vertice destino, String estilo) {
		super();
		this.pai = pai;
		this.id = nome;
		this.nome = nome;
		this.origem = origem;
		this.destino = destino;
		this.estilo = estilo;
	}
	
	public Object getPai() {
		return pai;
	}
	public void setPai(Object pai) {
		this.pai = pai;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Object getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Vertice getOrigem() {
		return origem;
	}
	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}
	public Vertice getDestino() {
		return destino;
	}
	public void setDestino(Vertice destino) {
		this.destino = destino;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	
	
}

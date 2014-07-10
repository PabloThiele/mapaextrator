

public class Vertice
{
	private String id;
	private String nome;
	private Integer coordenadaX;
	private Integer coordenadaY;
	private Integer largura;
	private Integer altura;
	private String estilo;
	
	Vertice(){}
	
	Vertice(String nome, Integer coordenadaX, Integer coordenadaY, Integer largura,Integer altura,String estilo){
		try{
			this.id = nome;
			this.nome = nome;
			this.coordenadaX = coordenadaX;
			this.coordenadaY = coordenadaY;
			this.largura = largura;
			this.altura = altura;
			this.estilo = estilo;
		}catch(Exception e){
			System.out.println("Erro ao popular o vértice");
		}
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public Integer getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	public Integer getLargura() {
		return largura;
	}
	public void setLargura(Integer largura) {
		this.largura = largura;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

}

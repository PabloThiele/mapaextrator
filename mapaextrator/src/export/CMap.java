package export;


public class CMap {

	private String xmlns = "http://cmap.ihmc.us/xml/cmap/" ;
	private String xmlnsDC = "http://purl.org/dc/elements/1.1/";
	private MetaData metaData; 

	private Map map;
	
	CMap(MetaData metaData, Map map) {
		super();
		this.metaData = metaData;
		this.map = map;
	}
	public String getXmlns() {
		return xmlns;
	}
	
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}
	
	public String getXmlnsDC() {
		return xmlnsDC;
	}
	
	public void setXmlnsDC(String xmlnsDC) {
		this.xmlnsDC = xmlnsDC;
	}
	
	public MetaData getMetaData() {
		return metaData;
	}
	
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	
	public Map getMap() {
		return map;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
}

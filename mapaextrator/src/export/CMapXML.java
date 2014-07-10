package export;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class CMapXML {
	
	
	public static void main (String args[]){
		XStream xstream = new XStream(new DomDriver()); // does not require XPP3 library
		StringBuilder finalXML = new StringBuilder();
		String defaultHeader = 	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"; 
		
		// Root node
		xstream.alias("cmap", CMap.class);
		// Add the namespace to CMAP
		xstream.useAttributeFor(CMap.class, "xmlns");
		xstream.aliasField("xmlns:dc", CMap.class, "xmlnsDC");
		xstream.useAttributeFor(CMap.class, "xmlnsDC");
		
		
		// Metadata
		xstream.aliasField("res-meta", CMap.class, "metaData");
			xstream.aliasField("dc:title", MetaData.class, "dcTitle");
			xstream.aliasField("dc:description", MetaData.class, "dcDescription");
		
		// Alias for Concept node
		xstream.alias("concept", Concept.class);
		// Added the Concept attributes
		xstream.useAttributeFor(Concept.class, "id");
		xstream.useAttributeFor(Concept.class, "label");
		
		// The same is made for LinkingPhrase
		xstream.alias("linking-phrase", LinkingPhrase.class);
		xstream.useAttributeFor(LinkingPhrase.class, "id");
		xstream.useAttributeFor(LinkingPhrase.class, "label");
		
		// The Connection configuration
		xstream.alias("connection", Connection.class);
		xstream.aliasField("from-id", Connection.class, "fromId");
		xstream.aliasField("to-id", Connection.class, "toId");
		xstream.useAttributeFor(Connection.class, "fromId");
		xstream.useAttributeFor(Connection.class, "toId");
		
		
		// The Concept Appearance configuration
		xstream.alias("concept-appearance", ConceptAppearance.class);
		xstream.useAttributeFor(ConceptAppearance.class, "id");
		xstream.useAttributeFor(ConceptAppearance.class, "x");
		xstream.useAttributeFor(ConceptAppearance.class, "y");
		
		// The LinkingPhrase Appearance configuration
		xstream.alias("linking-phrase-appearance", LinkingPhraseAppearance.class);
		xstream.useAttributeFor(LinkingPhraseAppearance.class, "id");
		xstream.useAttributeFor(LinkingPhraseAppearance.class, "x");
		xstream.useAttributeFor(LinkingPhraseAppearance.class, "y");
		
		// Map nodes fields alias
		xstream.aliasField("concept-list", Map.class, "conceptList");
		xstream.aliasField("linking-phrase-list", Map.class, "linkingPhraseList");
		xstream.aliasField("connection-list", Map.class, "connectionList");
		// Appearance ones
		xstream.aliasField("concept-appearance-list", Map.class, "conceptAppearanceList");
		xstream.aliasField("linking-phrase-appearance-list", Map.class, "linkingPhraseAppearanceList");
		

		// Generate the needes objects
		List<Concept> conceptList = new ArrayList<Concept>();
		List<LinkingPhrase> linkingPhraseList = new ArrayList<LinkingPhrase>();
		List<Connection>  connectionList = new ArrayList<Connection>();
		List<ConceptAppearance> conceptAppearanceList = new ArrayList<ConceptAppearance>();
		List<LinkingPhraseAppearance> linkingPhraseAppearanceList = new ArrayList<LinkingPhraseAppearance>();
		
		conceptList.add(new Concept(1, "Plants"));
		conceptList.add(new Concept(2, "Leaves"));
		//conceptList.add(new Concept(3, "loeoeoea"));
		
		linkingPhraseList.add(new LinkingPhrase(3, "é um"));
		//linkingPhraseList.add(new LinkingPhrase(5, "é um"));
		
		connectionList.add(new Connection(1, 3));
		connectionList.add(new Connection(3, 2));
//		connectionList.add(new Connection(3, 5));
//		connectionList.add(new Connection(5, 2));
		
		conceptAppearanceList.add(new ConceptAppearance(1, 75, 56));
		conceptAppearanceList.add(new ConceptAppearance(2, 136, 156));
		//conceptAppearanceList.add(new ConceptAppearance(3, 205, 180));
		
		linkingPhraseAppearanceList.add(new LinkingPhraseAppearance(3, 80, 95));
		//linkingPhraseAppearanceList.add(new LinkingPhraseAppearance(5, 120, 104));
		
		
		Map mapa = new Map(conceptList,linkingPhraseList,connectionList,conceptAppearanceList,linkingPhraseAppearanceList);
		MetaData metaData = new MetaData("TestONe", "How do i do?");
		CMap cMapmapa = new CMap(metaData, mapa);
		String xml = xstream.toXML(cMapmapa);
		finalXML = finalXML.append(defaultHeader).append(xml);
		System.out.println(finalXML);
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$CHANGED VERSION$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(CharToNCR.getTreatedString(finalXML.toString()));
	
	}

}


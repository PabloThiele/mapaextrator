package export;

import java.util.List;

public class Map {

	private List<Concept> conceptList;
	private List<LinkingPhrase> linkingPhraseList;
	private List<Connection> connectionList;

	private List<ConceptAppearance> conceptAppearanceList;
	private List<LinkingPhraseAppearance> LinkingPhraseAppearanceList;
	
	public Map(List<Concept> conceptList,
			List<LinkingPhrase> linkingPhraseList,
			List<Connection> connectionList,
			List<ConceptAppearance> conceptAppearanceList,
			List<LinkingPhraseAppearance> linkingPhraseAppearanceList) {
		super();
		this.conceptList = conceptList;
		this.linkingPhraseList = linkingPhraseList;
		this.connectionList = connectionList;
		this.conceptAppearanceList = conceptAppearanceList;
		LinkingPhraseAppearanceList = linkingPhraseAppearanceList;
	}

	public List<Concept> getConceptList() {
		return conceptList;
	}

	public void setConceptList(List<Concept> conceptList) {
		this.conceptList = conceptList;
	}

	public List<LinkingPhrase> getLinkingPhraseList() {
		return linkingPhraseList;
	}

	public void setLinkingPhraseList(List<LinkingPhrase> linkingPhraseList) {
		this.linkingPhraseList = linkingPhraseList;
	}

	public List<Connection> getConnectionList() {
		return connectionList;
	}

	public void setConnectionList(List<Connection> connectionList) {
		this.connectionList = connectionList;
	}

	public List<ConceptAppearance> getConceptAppearanceList() {
		return conceptAppearanceList;
	}

	public void setConceptAppearanceList(
			List<ConceptAppearance> conceptAppearanceList) {
		this.conceptAppearanceList = conceptAppearanceList;
	}

	public List<LinkingPhraseAppearance> getLinkingPhraseAppearanceList() {
		return LinkingPhraseAppearanceList;
	}

	public void setLinkingPhraseAppearanceList(
			List<LinkingPhraseAppearance> linkingPhraseAppearanceList) {
		LinkingPhraseAppearanceList = linkingPhraseAppearanceList;
	}
	
	

}

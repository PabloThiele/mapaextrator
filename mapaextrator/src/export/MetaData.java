package export;

public class MetaData {

	private String dcTitle; 
	private String dcDescription;
	
	MetaData(String dcTitle, String dcDescription) {
		super();
		this.dcTitle = dcTitle;
		this.dcDescription = dcDescription;
	}

	public String getDcTitle() {
		return dcTitle;
	}

	public void setDcTitle(String dcTitle) {
		this.dcTitle = dcTitle;
	}

	public String getDcDescription() {
		return dcDescription;
	}

	public void setDcDescription(String dcDescription) {
		this.dcDescription = dcDescription;
	} 
	
	
}

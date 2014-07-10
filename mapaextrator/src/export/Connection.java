package export;

public class Connection {
	
	private Integer fromId;
	private Integer toId;
	
	public Connection(Integer fromId, Integer toId) {
		super();
		this.fromId = fromId;
		this.toId = toId;
	}

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	
}

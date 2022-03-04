package main.java.model;

import javax.persistence.*;

@Entity
@Table(name="creator")
public class Creator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String creatorName;
	
	public Creator() {		
		super();
	}
	
	public Creator (String creatorName) {
		super();
		this.creatorName = creatorName;
	}

	public Creator(int id, String creatorName) {
		super();
		this.id = id;
		this.creatorName = creatorName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	@Override
	public String toString() {
		return "Creator [id=" + id + ", creatorName=" + creatorName + "]";
	}
	
}

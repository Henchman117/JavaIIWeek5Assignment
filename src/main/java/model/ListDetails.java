package main.java.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class ListDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String listName;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Creator creator;
	@JoinTable
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<KeySwitch> listOfKeys;
	
	public ListDetails(int id, String listName, Creator creator, List<KeySwitch> listOfKeys) {
		super();
		this.id = id;
		this.listName = listName;
		this.creator = creator;
		this.listOfKeys = listOfKeys;
	}
	public ListDetails(String listName, Creator creator, List<KeySwitch> listOfKeys) {
		super();
		this.listName = listName;
		this.creator = creator;
		this.listOfKeys = listOfKeys;
	}
	public ListDetails(String listName, Creator creator) {
		super();
		this.listName = listName;
		this.creator = creator;
	}
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public Creator getCreator() {
		return creator;
	}
	public void setCreator(Creator creator) {
		this.creator = creator;
	}
	public List<KeySwitch> getListOfKeys() {
		return listOfKeys;
	}
	public void setListOfKeys(List<KeySwitch> listOfKeys) {
		this.listOfKeys = listOfKeys;
	}
	
	
	
}

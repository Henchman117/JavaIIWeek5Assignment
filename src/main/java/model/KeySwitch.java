package main.java.model;

import javax.persistence.*;

@Entity
@Table(name="items")
public class KeySwitch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="COLOR")
	private String color;
	@Column(name="OPERATINGFORCE")
	private int operatingForce;
	@Column(name="TACTILE")
	private boolean tactile;
	
	public KeySwitch() {
		this.color = "red";
		this.operatingForce = 45;
		this.tactile = false;
		
	}
	public KeySwitch(String color, int pressDownForce, boolean tactile) {
		this.color = color;
		this.operatingForce = pressDownForce;
		this.tactile = tactile;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getOperatingForce() {
		return operatingForce;
	}
	public void setOperatingForce(int pressDownForce) {
		this.operatingForce = pressDownForce;
	}
	public boolean getTactile() {
		return tactile;
	}
	public void setTactile(boolean tactile) {
		this.tactile = tactile;
	}
	
	
}

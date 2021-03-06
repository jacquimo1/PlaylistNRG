package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="appGroup")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appGroup_id")
	private int id;
	
	@Column(name="appGroup_name")
	private String name;
	
	@Column(name="passcode")
	private String passcode;
	
	@Column(name="manager_id")
	private int managerId;
	
	@ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "appGroup_appUser", joinColumns = { @JoinColumn(name = "appGroup_id") }, inverseJoinColumns = { @JoinColumn(name = "appUser_id") })
    private List<User> users_g;
	
	public Group() {
		super();
	}
	
	public Group(String name, String passcode, int managerId) {
		super();
		this.name = name;
		this.passcode = passcode;
		this.managerId = managerId;
	}
	
	public Group (int id, String name, String passcode, int managerId) {
		super();
		this.id = id;
		this.name = name;
		this.passcode = passcode;
		this.managerId = managerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", passcode=" + passcode + ", managerId=" + managerId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}

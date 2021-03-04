package com.hcl.capstone.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // might have to change
	private long id;
	
	private String name;
<<<<<<< Updated upstream
	private String desctiption;
	
	@OneToMany(mappedBy="genre")//added annotation
	private List<Album> album; // added Album object
=======
	private String description;
	@OneToMany(mappedBy="genre")//added annotation
	private List<Album> album; // added Album object // Made Album a list object
>>>>>>> Stashed changes
	
	public Genre() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesctiption() {
		return description;
	}
	public void setDesctiption(String desctiption) {
		this.description = desctiption;
	}

<<<<<<< Updated upstream
=======
	// ADDED NEW GETTERS AND SETTERS
>>>>>>> Stashed changes
	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}


	
	// ADDED NEW GETTERS AND SETTERS

	
}

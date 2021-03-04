package com.hcl.capstone.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // might have to change
	private long id;

	private String name;
	private String location;

	@OneToMany(mappedBy="artist") // changed from ManyToMany
	private List<Song> songs; //changed to List
	@OneToMany(mappedBy="artist") // changed to OneToMany
	private List<Album> album; //changed to List

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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public List<Album> getAlbum() {
		return album;
	}
	public void setAlbum(List<Album> album) {
		this.album = album;
<<<<<<< Updated upstream


	};

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	
=======
	}

>>>>>>> Stashed changes



	
	

}

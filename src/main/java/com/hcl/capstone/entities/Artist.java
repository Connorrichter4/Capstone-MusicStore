package com.hcl.capstone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // might have to change
	private long id;
	
	private String name;
	private String location;
	@ManyToMany
	private Song songs;
	@ManyToMany
	private Album album;
	
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
	public Song getSongs() {
		return songs;
	}
	public void setSongs(Song songs) {
		this.songs = songs;
	}
	public Album getAlbulms() {
		return album;
	}
	public void setAlbulms(Album albulms) {
		this.album = albulms;
	}
	
	

}

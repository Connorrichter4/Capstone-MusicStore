package com.hcl.capstone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // might have to change
	private long id;
	
	private String name;
	private Double price;
	private Long inventory;
	
	@ManyToOne
	@JsonIgnore //Use this for toStrong
	private Artist artist;
	@ManyToOne
	private Album album;
	
	public Song() {
		
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getInventory() {
		return inventory;
	}
	public void setInventory(Long inventory) {
		this.inventory = inventory;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}

//	@Override
//	public String toString() {
//
//		return "Song [id=" + id + ", name=" + name + ", price=" + price + ", inventory=" + inventory +  ", artist id="
//				+ artist.getId() + " artist name=" + artist.getName() + ", album id=" + album.getId() + 
//				", album name=" + album.getName() + ", image=" + album.getImage() +  "]";
//	}

}

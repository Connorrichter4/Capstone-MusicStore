package com.hcl.capstone.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private Double price;
	
	@ManyToOne
	private Artist artist;

	private Date date;

	private String status;

	private String image;

	private long inventory;

	@OneToOne(mappedBy="album")
	private Genre genre;

	@OneToMany(mappedBy="album")
	private List<Song> song;

	
	public Album() {
		super();
	}


	public Album(long id, String name, Double price, Artist artist, Date date, String status, String image,
			long inventory, Genre genre, List<Song> song) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.artist = artist;
		this.date = date;
		this.status = status;
		this.image = image;
		this.inventory = inventory;
		this.genre = genre;
		this.song = song;
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


	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public long getInventory() {
		return inventory;
	}


	public void setInventory(long inventory) {
		this.inventory = inventory;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	public List<Song> getSong() {
		return song;
	}


	public void setSong(List<Song> song) {
		this.song = song;
	}


	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", price=" + price + ", artist=" + artist + ", date=" + date
				+ ", status=" + status + ", image=" + image + ", inventory=" + inventory + ", genre=" + genre
				+ ", song=" + song + "]";
	}
}

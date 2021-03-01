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

	private String albumName;

	private Double albumPrice;
	
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

	public Album(long albumId, String albumName, Double albumPrice, Artist artist, Date date, String condition,
			String image, long inventory, Genre genre, List<Song> song) {
		super();
		this.id = albumId;
		this.albumName = albumName;
		this.albumPrice = albumPrice;
		this.artist = artist;
		this.date = date;
		this.status = condition;
		this.image = image;
		this.inventory = inventory;
		this.genre = genre;
		this.song = song;
	}

	public long getAlbumId() {
		return id;
	}

	public void setAlbumId(long albumId) {
		this.id = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Double getPrice() {
		return albumPrice;
	}

	public void setPrice(Double price) {
		this.albumPrice = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCondition() {
		return status;
	}

	public void setCondition(String condition) {
		this.status = condition;
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
		return "Album [albumId=" + id + ", albumName=" + albumName + ", condition=" + status + ", image="
				+ image + ", inventory=" + inventory + "]";
	}

}

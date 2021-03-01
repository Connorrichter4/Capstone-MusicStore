package com.hcl.capstone.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long albumId;

	private String albumName;

	private BigDecimal price;

	private Date date;

	private String condition;

	private String image;

	private long inventory;

	@OneToOne
	private Genre genre;

	@OneToMany
	private List<Song> song;

	public Album() {
		super();
	}

	public Album(long albumId, String albumName, BigDecimal price, Date date, String condition, String image,
			long inventory, Genre genre, List<Song> song) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.price = price;
		this.date = date;
		this.condition = condition;
		this.image = image;
		this.inventory = inventory;
		this.genre = genre;
		this.song = song;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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
		return "Album [albumId=" + albumId + ", albumName=" + albumName + ", condition=" + condition + ", image="
				+ image + ", inventory=" + inventory + "]";
	}

}

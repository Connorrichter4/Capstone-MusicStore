package com.hcl.capstone.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.repositories.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	AlbumRepository repo;
	
	public List<Album> findAllAlbums() {
		List<Album> albums = new ArrayList<Album>();
		for(Album album : repo.findAll()) {
			System.out.println("found an album...");
			albums.add(album);
		}
		return albums;
	}
	
	public Album findAlbum(Long id) {
		if(!repo.existsById(id)) {
			return repo.findById(id).get();
		}else {
			return new Album(); //return empty album if nor found
		}
	}
	
	public boolean addOrUpdateNewAlbum(Album album) {
		if(!repo.existsById(album.getId()) && !repo.findByName(album.getName())) {
			repo.save(album);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteAlbum(Long id) {
		if(!repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}

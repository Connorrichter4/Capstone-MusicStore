package com.hcl.capstone.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.repositories.AlbumRepository;

@Service
public class AlbumService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AlbumRepository repo;
	
	public List<Album> findAllAlbums() {
		List<Album> albums = new ArrayList<Album>();
		for(Album album : repo.findAll()) {
			logger.info("found an album...");
			albums.add(album);
		}
		return albums;
	}
	
	public Album findAlbum(Long id) {
		if(repo.existsById(id)) {
			logger.info("found the album...");
			return repo.findById(id).get();
		}else {
			logger.info("album not found...");
			return new Album(); //return empty album if nor found
		}
	}
	
}

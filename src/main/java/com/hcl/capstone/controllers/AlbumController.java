package com.hcl.capstone.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.services.AlbumService;



@Controller
public class AlbumController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	AlbumService service;
	
	@GetMapping("/album")
	public String getAllAlbums(ModelMap map) {
		logger.info("inside get mapping");
		List<Album> albums = service.findAllAlbums();
		map.put("albums", albums);
		return "test_album";
	}
	
	@GetMapping("/album/{id}")
	public String getAlbum(ModelMap map, @PathVariable Long id) {
		Album album = service.findAlbum(id);
		logger.info(album.toString());
		map.put("album", album);
		return "test_this_album";
	}

}

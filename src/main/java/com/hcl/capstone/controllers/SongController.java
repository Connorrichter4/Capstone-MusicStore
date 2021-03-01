package com.hcl.capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.services.SongService;

@Controller
public class SongController {
	@Autowired
	SongService songService;
	
	//AlbumService albumService;
	
	//public Artist artist; //get it from artist entity
	//public Album album; //get it from album entity
	
	@RequestMapping(value="/testSongController", method=RequestMethod.GET)
	String showSongs(ModelMap model) {
		model.put("allSongs", songService.getAllSong());
		return "testSongController";
	}
	
	
	/*
	 * @RequestMapping(value="/addSong", method=RequestMethod.POST) String
	 * addSongs(@RequestParam String name, @RequestParam Double price,
	 * 
	 * @RequestParam Long inventory, Artist artist, Album album) {
	 * songService.createSong(name, price, inventory, artist, album); return
	 * "testSongController"; }
	 */
	
	

}

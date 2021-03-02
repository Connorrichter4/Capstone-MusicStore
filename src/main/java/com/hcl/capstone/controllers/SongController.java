package com.hcl.capstone.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.services.SongService;

@Controller
public class SongController {
	
	private Logger logger = LoggerFactory.getLogger(SongController.class);
	
	@Autowired
	SongService songService;
	
	//AlbumService albumService;
	
	//public Artist artist; //get it from artist entity
	//public Album album; //get it from album entity
	
	@RequestMapping(value="/song", method=RequestMethod.GET)
	public String showSongs(ModelMap model) {
		Iterable<Song> listOfSongs = songService.getAllSong();
		listOfSongs.forEach(song -> logger.info(song.toString()));
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

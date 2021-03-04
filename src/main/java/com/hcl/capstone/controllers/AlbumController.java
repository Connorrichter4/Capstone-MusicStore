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
import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.entities.Genre;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.services.AlbumService;
import com.hcl.capstone.services.ArtistService;
import com.hcl.capstone.services.SongService;



@Controller
public class AlbumController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	AlbumService albumService;
	@Autowired
	ArtistService artistService;
	@Autowired
	SongService songService;
	
	@GetMapping("/album")
	public String getAllAlbums(ModelMap map) {
		logger.info("inside get mapping");
		List<Album> albums = albumService.findAllAlbums();
		Iterable<Artist> artists = artistService.getAllArtist();
		Iterable<Song> songs = songService.getAllSong();
//		Iterable<Song> genres = songService.getAllGenres(); //TODO: ADD GENRE SERVICE LATER
		map.put("albums", albums);
		map.put("songs", songs);
		map.put("artists", artists);
		map.put("genres", "Under Construction...");	//TODO: add genre service later
		return "test_album";
	}
	
	@GetMapping("/album/{id}")
	public String getAlbum(ModelMap map, @PathVariable Long id) {
		Album album = albumService.findAlbum(id);
		logger.info(album.toString());
		map.put("album", album);
		return "test_this_album";
	}

}

package com.hcl.capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.entities.User;
import com.hcl.capstone.repositories.UserRepository;
import com.hcl.capstone.services.SongService;
import com.hcl.capstone.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	SongService songService;
	
	@Autowired
	UserService userService;
	
//	@Autowired
//	AlbumService albumService;

	@GetMapping("/")
	public String showProducts(ModelMap model) {
		Iterable<Song> songs = songService.getAllSong();
//		Iterable<Album> albums = albumService.getAllAlbum();
		model.put("songs", songs);
//		model.put("albums", albums);
		return "admin-products";
	}
	
	@GetMapping("/song/{id}")
	public String getSongProduct(ModelMap model, @PathVariable Long id) {
		Song song = songService.getSongById(id).get();
		model.put("product", song);
		return "admin-get-product";
	}
	
	@GetMapping("/album/{id}")
	public String getAlbumProduct(ModelMap model, @PathVariable Long id) {
//		Album album = albumService.getAlbumById(id).get();
//		model.put("product", album);
		return "admin-get-product";
	}
	
	@PostMapping("/song/{id}")
	public RedirectView updateSongProduct(@PathVariable Long id, Song song ) {
		if(songService.updateSong(id,song)) {
			return new RedirectView("/song/" + id);
		}
		return new RedirectView("/admin/song/" + id); 
	}
	
	@PostMapping("/song/delete/{id}")
	public RedirectView deleteSongProduct(@PathVariable Long id) {
		if(songService.deleteSong(id)) {
			return new RedirectView("/song/");
		}
		return new RedirectView("/admin/song/" + id); 
	}
	
	@GetMapping("/customers")
	public String showCustomers(ModelMap model) {
		Iterable<User> users = userService.getAll();
		model.put("users", users);
		return "admin-products";
	}
}

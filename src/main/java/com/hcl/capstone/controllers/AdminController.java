package com.hcl.capstone.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Artist;
import com.hcl.capstone.entities.Song;
import com.hcl.capstone.entities.User;
import com.hcl.capstone.repositories.UserRepository;
import com.hcl.capstone.services.AlbumService;
import com.hcl.capstone.services.ArtistService;
import com.hcl.capstone.services.SongService;
import com.hcl.capstone.services.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SongService songService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	ArtistService artistService;

	@GetMapping("/")
	public String showProducts(ModelMap model) {
		Iterable<Song> songs = songService.sortSongsBySortedName();
		Iterable<Album> albums = albumService.findAllAlbums();
		model.put("songs", songs);
		model.put("albums", albums);
		return "admin-products";
	}
	
	@GetMapping("/song/{id}")
	public String getSongProduct(ModelMap model, @PathVariable Long id) {
		Song song = songService.getSongById(id).get();
		logger.info(song.toString());
		Iterable<Album> albums = albumService.findAllAlbums();
		Iterable<Artist> artists = artistService.getAllArtist();
		model.put("albums", albums);
		model.put("artists", artists);
		model.put("song", song);
		return "admin-edit-song";
	}
	
	@PostMapping("/song/{id}")
	public ModelAndView updateSongProduct(ModelMap model, @PathVariable Long id, Song song, @RequestParam Long artist_id, @RequestParam Long album_id ) {
		song.setAlbum(albumService.findAlbum(album_id));
		song.setArtist(artistService.getArtistById(artist_id).get());
		
		logger.info(song.toString());
		if(songService.updateSong(id,song)) {
			return new ModelAndView("redirect:/admin/");
		}
		model.put("error", "There was an error updating the song");
		return new ModelAndView("redirect:/admin/song/" + id, model); 
	}
	
	@GetMapping("/song/delete/{id}")
	public RedirectView deleteSongProduct(@PathVariable Long id) {
		if(songService.deleteSong(id)) {
			return new RedirectView("/admin/");
		}
		return new RedirectView("/admin/song/" + id); 
	}
	
	@GetMapping("/album/{id}")
	public String getAlbumProduct(ModelMap model, @PathVariable Long id) {
//		Album album = albumService.getAlbumById(id).get();
//		model.put("product", album);
		return "admin-get-album";
	}
	
	@PostMapping("/album/{id}")
	public RedirectView updateAlbum(@PathVariable Long id, Album album ) {
//		if(albumService.updateSong(id,album)) {
//			return new RedirectView("/admin/" + id);
//		}
		return new RedirectView("/admin/song/" + id); 
	}
	
	@GetMapping("/album/delete/{id}")
	public RedirectView deleteAlbum(@PathVariable Long id) {
//		if(albumService.deleteSong(id)) {
//			return new RedirectView("/admin/");
//		}
		return new RedirectView("/admin/album/" + id); 
	}
	
	@GetMapping("/customers")
	public String showCustomers(ModelMap model) {
		Iterable<User> users = userService.getAll();
		model.put("users", users);
		return "admin-customers";
	}
	
	@GetMapping("/customer/{id}")
	public String getCustomer(ModelMap model, @PathVariable Long id) {
		User user = userService.getUserById(id);
		
		model.put("user", user);
		return "admin-edit-customer";
	}
	
	@PostMapping("/customer/{id}")
	public ModelAndView updateCustomer(ModelMap model, @PathVariable Long id, User user ) {
		user.setId(id);
		// verify valid email using regex
		Pattern pattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(user.getEmail());
		System.out.println(matcher.matches());
		if(!matcher.matches()) {
			logger.info("Invalid Email Input");
			model.put("error", "Email Must Be Valid");
			return new ModelAndView("admin-edit-customer", model);
		}
	
		userService.updateUser(user);
		return new ModelAndView("redirect:/admin/customers"); 
	}
	
	@GetMapping("/customer/delete/{id}")
	public ModelAndView deleteCustomer(ModelMap model, @PathVariable Long id) {
		userService.deleteUser(id);
		return new ModelAndView("redirect:/admin/customers", model);
	}
	

}

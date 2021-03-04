package com.hcl.capstone.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		System.out.println(model);
//		model.remove("albums");
//		System.out.println(model);

		logger.info("inside show admin home");
		Iterable<Album> albums = albumService.getAllAlbum();
//		
//		for(Album album : albums) {
//			logger.info(album.toString());
//		}
		
		Iterable<Artist> artists = artistService.getAllArtist();
		Iterable<Song> songs = songService.getAllSong();
		model.addAttribute("albums", albums);
		model.addAttribute("artists", artists);
		model.addAttribute("songs", songs);
		
//		System.out.println(model.get("albums"));
//		model.remove("albums");
//		System.out.println(model.get("albums"));
		
		return "admin-products";
	}
	
	@GetMapping("/songs")
	public String showSongProducts(ModelMap model) {	
	
		Iterable<Song> songs = songService.getAllSong();
		model.addAttribute("songs", songs);
		return "admin-songs";
	}
	
	@GetMapping("/artist")
	public String showArtists(ModelMap model) {	
	
		Iterable<Artist> artists = artistService.getAllArtist();
		model.addAttribute("artists", artists);
		return "admin-artists";
	}
	
	/*
	 * 
	 * 
	 * 
	 * 			Song Controls
	 * 
	 * 
	 * 
	 */
//
//	@GetMapping("/song/create")
//	public String createSongForm(ModelMap model) {
//
//		Iterable<Album> albums = albumService.findAllAlbums();
//		Iterable<Artist> artists = artistService.getAllArtist();
//		model.put("albums", albums);
//		model.put("artists", artists);
//		
//		return "admin-create-song";
//	}
//
//	@PostMapping("/song/create")
//	public RedirectView createSongProduct(ModelMap model, Song song, @RequestParam Long artist_id,
//			@RequestParam Long album_id) {
//		song.setAlbum(albumService.findAlbum(album_id));
//		song.setArtist(artistService.getArtistById(artist_id).get());
//
//		logger.info(song.toString());
//
//		songService.createSong(song);
//		return new RedirectView("/admin/");

//	}

//	@GetMapping("/song/{id}")
//	public String getSongProduct(ModelMap model, @PathVariable Long id) {
//		Song song = songService.getSongById(id).get();
//		logger.info(song.toString());
//		Iterable<Album> albums = albumService.findAllAlbums();
//		Iterable<Artist> artists = artistService.getAllArtist();
//		model.put("albums", albums);
//		model.put("artists", artists);
//		model.put("song", song);
//		return "admin-edit-song";
//	}
//
//	@PostMapping("/song/{id}")
//	public ModelAndView updateSongProduct(ModelMap model, @PathVariable Long id, Song song,
//			@RequestParam Long artist_id, @RequestParam Long album_id) {
//		song.setAlbum(albumService.findAlbum(album_id));
//		song.setArtist(artistService.getArtistById(artist_id).get());
//
//		logger.info(song.toString());
//		if (songService.updateSong(id, song)) {
//			return new ModelAndView("redirect:/admin/");
//		}
//		model.put("error", "There was an error updating the song");
//		return new ModelAndView("redirect:/admin/song/" + id, model);
//	}

//	@GetMapping("/song/delete/{id}")
//	public RedirectView deleteSongProduct(@PathVariable Long id) {
//		logger.info("inside delete function");
//		
//		// need to add model for delete success and failure
//		
//		if (songService.deleteSong(id)) {
//			return new RedirectView("/admin/");
//		}
//		return new RedirectView("/admin/");
//	}
	
	/*
	 * 
	 * 
	 * 
	 * 			Album Controls
	 * 
	 * 
	 * 
	 */
	
	@GetMapping("/album/create")
	public String createAlbumForm(ModelMap model) {

//		Iterable<Album> albums = albumService.findAllAlbums();
		Iterable<Artist> artists = artistService.getAllArtist();
//		model.put("albums", albums);
		model.put("artists", artists);
		
		return "admin-create-album";
	}
	
	@PostMapping("/album/create")
	public RedirectView createAlbumProduct(ModelMap model, Album album, @RequestParam Long artist_id) {
		
		album.setArtist(artistService.getArtistById(artist_id).get());

		logger.info(album.toString());

		albumService.createAlbum(album);
		return new RedirectView("/admin/");

	}

	@GetMapping("/album/{id}")
	public String getAlbumProduct(ModelMap model, @PathVariable Long id) {
		
		Album album = albumService.getAlbumById(id).get();
		logger.info(album.toString());
		
		Iterable<Artist> artists = artistService.getAllArtist();
		
		
		model.put("artists", artists);
		model.put("album", album);
		
		return "admin-edit-album";
	}

	@PostMapping("/album/{id}")
	public ModelAndView updateAlbumProduct(ModelMap model, @PathVariable Long id, Album album,
			@RequestParam Long artist_id) {
		
		
		album.setArtist(artistService.getArtistById(artist_id).get());
	

		logger.info(album.toString());
		if (albumService.updateAlbum(id, album)) {
			return new ModelAndView("redirect:/admin/");
		}
		model.put("error", "There was an error updating the album");
		return new ModelAndView("redirect:/admin/album/" + id, model);
	}

	@GetMapping("/album/delete/{id}")
	public RedirectView deleteAlbumProduct(@PathVariable Long id) {
		logger.info("inside delete function");
		
		// need to add model for delete success and failure
		
		if (albumService.deleteAlbum(id)) {
			return new RedirectView("/admin/");
		}
		return new RedirectView("/admin/");
	}
	
	/*
	 * 
	 * 
	 * 
	 * 			Customer Controls
	 * 
	 * 
	 * 
	 */

//	@GetMapping("/customers")
//	public String showCustomers(ModelMap model) {
//		Iterable<User> users = userService.getAll();
//		model.put("users", users);
//		return "admin-customers";
//	}
//
//	@GetMapping("/customer/{id}")
//	public String getCustomer(ModelMap model, @PathVariable Long id) {
//		User user = userService.getUserById(id);
//
//		model.put("user", user);
//		return "admin-edit-customer";
//	}
//
//	@PostMapping("/customer/{id}")
//	public ModelAndView updateCustomer(ModelMap model, @PathVariable Long id, User user) {
//		user.setId(id);
//		// verify valid email using regex
//		Pattern pattern = Pattern.compile(
//				"^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
//		Matcher matcher = pattern.matcher(user.getEmail());
//		System.out.println(matcher.matches());
//		if (!matcher.matches()) {
//			logger.info("Invalid Email Input");
//			model.put("error", "Email Must Be Valid");
//			return new ModelAndView("admin-edit-customer", model);
//		}
//
//		userService.updateUser(user);
//		return new ModelAndView("redirect:/admin/customers");
//	}
//
//	@GetMapping("/customer/delete/{id}")
//	public ModelAndView deleteCustomer(ModelMap model, @PathVariable Long id) {
//		userService.deleteUser(id);
//		return new ModelAndView("redirect:/admin/customers", model);
//	}

}

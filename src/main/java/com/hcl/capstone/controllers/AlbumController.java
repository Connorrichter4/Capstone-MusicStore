package com.hcl.capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.services.AlbumService;



@Controller
public class AlbumController {

	@Autowired
	AlbumService service;
	
	@GetMapping(value={"/","/home","/index"})
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		List<Album> albums = service.findAllAlbums();
		mv.addObject("albums", albums);
		mv.setViewName("test_album");
		return mv;
	}
}

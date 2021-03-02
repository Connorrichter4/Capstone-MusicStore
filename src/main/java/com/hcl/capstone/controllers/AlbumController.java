package com.hcl.capstone.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.services.AlbumService;



@Controller
public class AlbumController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	AlbumService service;
	
	@GetMapping(value={"/","/home","/index"})
	public ModelAndView test() {
		logger.info("inside get mapping");
		ModelAndView mv = new ModelAndView();
		List<Album> albums = service.findAllAlbums();
		mv.addObject("albums", albums);
		mv.setViewName("test_album");
		return mv;
	}
}

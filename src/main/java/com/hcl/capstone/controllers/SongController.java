package com.hcl.capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hcl.capstone.services.SongService;

@Controller
public class SongController {
	@Autowired
	SongService songService;
	
	

}

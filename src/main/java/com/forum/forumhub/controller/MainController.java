package com.forum.forumhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forumhub")
public class MainController {
	@GetMapping
	public String cursos() {
		return "Forum Hub";
	}
}


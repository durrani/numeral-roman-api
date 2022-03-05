package com.numeral.roman.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numeral.roman.api.service.NumberToRomanService;

@RestController
@RequestMapping("api")
public class NumberToRomanController {
	
	@Autowired
	private NumberToRomanService numberToRomanService;
	
	@GetMapping("/numberToRoman/{number}")
	public String getRoman(@PathVariable Integer number) {
		return numberToRomanService.convert(number);
	}
}

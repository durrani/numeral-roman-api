package com.numeral.roman.api.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numeral.roman.api.model.NumberRoman;
import com.numeral.roman.api.repository.NumberRomanRepository;

@Service
public class NumberToRomanService {

	private static Map<String, Integer> primitive = new LinkedHashMap<>();
	static {
		primitive.put("M", 1000);
		primitive.put("CM", 900);
		primitive.put("D", 500);
		primitive.put("CD", 400);
		primitive.put("C", 100);
		primitive.put("XC", 90);
		primitive.put("L", 50);
		primitive.put("XL", 40);
		primitive.put("X", 10);
		primitive.put("IX", 9);
		primitive.put("V", 5);
		primitive.put("IV", 4);
		primitive.put("I", 1);
	}

	@Autowired
	private NumberRomanRepository numberRomanRepository;

	public String convert(Integer intValue) {

		// check if value is in cache
		Optional<NumberRoman> optionalNumeralRoman = numberRomanRepository.findById(intValue);

		// if present
		if (optionalNumeralRoman.isPresent()) {
			return optionalNumeralRoman.get().getRomanValue();
		}

		// if not in cache
		// logic to find the roman value
		int number = intValue.intValue();

		StringBuilder roman = new StringBuilder();

		for (Entry<String, Integer> entry : primitive.entrySet()) {

			while (number >= entry.getValue()) {
				number = number - entry.getValue();
				roman.append(entry.getKey());
			}
		}

		// store to cache
		numberRomanRepository.save(new NumberRoman(intValue, roman.toString()));

		return roman.toString();
	}

}

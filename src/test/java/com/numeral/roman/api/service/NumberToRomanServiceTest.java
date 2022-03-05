package com.numeral.roman.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.numeral.roman.api.model.NumberRoman;
import com.numeral.roman.api.repository.NumberRomanRepository;

@RunWith(MockitoJUnitRunner.class)
public class NumberToRomanServiceTest {

	@Autowired
	@InjectMocks
	private NumberToRomanService service;

	@Mock
	private NumberRomanRepository numberRomanRepository;

	@Before
	public void before() {
		Optional<NumberRoman> optional = Optional.empty();
		when(numberRomanRepository.findById(anyInt())).thenReturn(optional);
	}

	@Test
	public void checkSingleDigits() {
		assertEquals("", service.convert(0));
		assertEquals("I", service.convert(1));
		assertEquals("II", service.convert(2));
		assertEquals("III", service.convert(3));
		assertEquals("IV", service.convert(4));
		assertEquals("V", service.convert(5));
		assertEquals("VI", service.convert(6));
		assertEquals("VII", service.convert(7));
		assertEquals("VIII", service.convert(8));
		assertEquals("IX", service.convert(9));
	}

	@Test
	public void checkTens() {
		assertEquals("X", service.convert(10));
		assertEquals("XX", service.convert(20));
		assertEquals("XXX", service.convert(30));
		assertEquals("XL", service.convert(40));
		assertEquals("L", service.convert(50));
		assertEquals("LX", service.convert(60));
		assertEquals("LXX", service.convert(70));
		assertEquals("LXXX", service.convert(80));
		assertEquals("XC", service.convert(90));
	}

	@Test
	public void checkHundreds() {
		assertEquals("C", service.convert(100));
		assertEquals("CC", service.convert(200));
		assertEquals("CCC", service.convert(300));
		assertEquals("CD", service.convert(400));
		assertEquals("D", service.convert(500));
		assertEquals("DC", service.convert(600));
		assertEquals("DCC", service.convert(700));
		assertEquals("DCCC", service.convert(800));
		assertEquals("CM", service.convert(900));
	}

	@Test
	public void checkThousands() {
		assertEquals("M", service.convert(1000));
		assertEquals("MM", service.convert(2000));
		assertEquals("MMM", service.convert(3000));
	}

}

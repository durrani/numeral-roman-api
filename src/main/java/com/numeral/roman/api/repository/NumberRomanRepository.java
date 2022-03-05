package com.numeral.roman.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.numeral.roman.api.model.NumberRoman;

@Repository
public interface NumberRomanRepository extends JpaRepository<NumberRoman, Integer>{

}

package com.artaleDB.services;

import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

@Component
public class CalculationService {
	
	public <T> long getCount(Iterable<T> list) {
		return StreamSupport.stream(list.spliterator(), false).count();
	}
}

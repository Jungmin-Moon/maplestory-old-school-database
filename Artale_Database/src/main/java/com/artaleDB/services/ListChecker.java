package com.artaleDB.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListChecker {

	//Having to copy and paste five lines of code eight different times was gonna get too annoying for me
	
	public <T> List<T> checkIfEmptyElseCreateSubList(List<T> list, int start, int pageSize, int size) {
		
		if (list.size() < start) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(start + pageSize, size);
			list = list.subList(start, toIndex);
		}
		
		
		return list;
	}
	
	
}

package com.example.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Entry;
import com.example.phonebook.service.PhonebookService;


@RestController
@RequestMapping(path="/phonebook")
public class PhonebookController {
	
	@Autowired
	PhonebookService phonebookService;
	
	
	@PostMapping("/create")
	public String createEntry(Entry entry) {
		return phonebookService.addEntry(entry);
	}
	
	@GetMapping("/entries")
	public List<Entry> getEntries() {
		return phonebookService.getAllEntries();
	}
	
	@PostMapping("/delete/{entryId}")
	public String deleteEntry(@PathVariable("entryId") int entryId) {
		return phonebookService.deleteEntry(entryId);
	}
	
	@PutMapping("/update")
	public String updateEntry(Entry entry) {
		return phonebookService.updateEntry(entry);
	}
	
	@GetMapping("/search/{surName}") 
	public List<Entry> searchEntry(@PathVariable("surName") String surName) {
		return phonebookService.searchBySurName(surName);
	}

}

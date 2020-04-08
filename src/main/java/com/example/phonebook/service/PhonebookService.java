package com.example.phonebook.service;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.bean.Entry;
import com.example.phonebook.dao.PhonebookRepo;

@Service
public class PhonebookService {
	
	@Autowired
	PhonebookRepo phonebookRepo;
	
	public String addEntry(Entry entry) {
		
		if (StringUtils.isEmpty(entry.getFirstName()) || StringUtils.isEmpty(entry.getSurName())
				|| StringUtils.isEmpty(entry.getPhoneNumber())) {
			throw new ValidationException("Surname, firstname and phoneNumber are madatory");
		}
		
		Entry en = new Entry();
		try {
			en = phonebookRepo.save(entry);
		}
		catch(Exception e) {
			return "Entry creation Failed !!!!";
		}
		return "Entry created successfully. EntryId is :" + en.getEntryId();
	}
	
	public List<Entry> getAllEntries() {
		return phonebookRepo.findAll();
	}
	
	public String deleteEntry(int entryId) {
		try {
			phonebookRepo.deleteById(entryId);
		}
		catch(Exception e) {
			return "Deletion failed !!!";
		}
		return "Entry deleted successfully. EntryId is :" + entryId;
	}
	
	public String updateEntry(Entry entry) {
		try {
			phonebookRepo.updateEntry(entry.getEntryId(), entry.getSurName(), entry.getFirstName(),
					entry.getPhoneNumber());
		} catch (Exception e) {
			return "Updation failed !!!";
		}
		return "Entry updated successfully. EntryId is :" + entry.getEntryId();
	}
	
	public List<Entry> searchBySurName(String surName) {
		return phonebookRepo.findBySurName(surName);
	}
	
	

}

package com.example.phonebook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bean.Entry;

@Repository
@Transactional
public interface PhonebookRepo extends JpaRepository<Entry, Integer> {

	@Query("UPDATE entry e SET e.surname = :surname AND e.firstname = :firstName AND e.phoneNumber = :phoneNumber where e.entryId = :entryId")
	void updateEntry(@Param("entryId") int entryId, @Param("surname") String surname,
			@Param("firstName") String firstName, @Param("phoneNumber") long phoneNumber);
	
	List<Entry> findBySurName(String surName);
}

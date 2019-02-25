package com.example.mvcnote.listanote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvcnote.listanote.model.Nota;

public interface NoteRepository extends JpaRepository<Nota, Integer>{
	

}

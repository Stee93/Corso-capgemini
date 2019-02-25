package com.example.mvcnote.listanote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvcnote.listanote.model.Nota;
import com.example.mvcnote.listanote.repository.NoteRepository;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	
	
	@Autowired //mi cerca da solo il componente che implementa l interfaccia e associala alla classe che la chiama 
	private NoteRepository noterepository;
	
	@Override
	public void saveNota(Nota n) {
		noterepository.save(n);
		
	}

	@Override
	public List<Nota> getAll() {
		
		return noterepository.findAll();
	}

}

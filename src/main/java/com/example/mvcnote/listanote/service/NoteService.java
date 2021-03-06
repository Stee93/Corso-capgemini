package com.example.mvcnote.listanote.service;

import java.util.List;
import java.util.Optional;

import com.example.mvcnote.listanote.model.Nota;

public interface NoteService {
	public void saveNota(Nota n);
	public void update(Nota n);
	public void deleteNota(Nota n);
	public Optional<Nota> findById(Integer notaId);
	public List<Nota> getAll();
}

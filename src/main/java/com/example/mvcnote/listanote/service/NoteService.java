package com.example.mvcnote.listanote.service;

import java.util.List;

import com.example.mvcnote.listanote.model.Nota;

public interface NoteService {
	public void saveNota(Nota n);
	public List<Nota> getAll();
}

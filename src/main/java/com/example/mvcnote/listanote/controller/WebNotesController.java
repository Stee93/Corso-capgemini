package com.example.mvcnote.listanote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mvcnote.listanote.model.Nota;
import com.example.mvcnote.listanote.service.NoteService;

@Controller
public class WebNotesController {
	
	@Autowired //trova i componenti che implementa questa interfaccia e assegnali a questa variabile privata
	private NoteService noteservice;
	
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView home(){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		List<Nota> listaNote = noteservice.getAll();
		mav.addObject("listaNote",listaNote  ); //mi ritorna una lista di oggetti note al template home
		mav.addObject("nota", new Nota());
		return mav;
	}
		
	@RequestMapping(value="/salva", method=RequestMethod.POST)
	public ModelAndView add(@Valid Nota nota,BindingResult bindingResult) {
		ModelAndView mav=new ModelAndView();
		noteService.saveNota(nota);
		mav.setViewName("home");
		List<Nota> listaNote = noteservice.getAll();
		mav.addObject("listaNote",listaNote);
		mav.addObject("nota", new Nota());
		return mav;
	}
		
	@RequestMapping(value="/edit/{notaId}", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable Integer notaId) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("nota", noteService.findById(notaId));
		mav.setViewName("edit_nota");
		return mav;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView do_update(@Valid Nota n, BindingResult bindingResult) {
		noteService.saveNota(n);
		return new ModelAndView("redirect:/");
	}

}

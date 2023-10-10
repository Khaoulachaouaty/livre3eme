package com.khaoula.livre.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.khaoula.livre.entities.Editeur;
import com.khaoula.livre.repos.EditeurRepository;

@RestController
@RequestMapping("/api/ed")
@CrossOrigin("*")

public class EditeurRESTController {
	@Autowired
	EditeurRepository editeurRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Editeur> getAllEditeurs()
	{
	return editeurRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Editeur getEditeurById(@PathVariable("id") Long id) {
	return editeurRepository.findById(id).get();
	}
}

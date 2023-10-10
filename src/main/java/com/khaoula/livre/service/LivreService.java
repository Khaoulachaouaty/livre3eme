package com.khaoula.livre.service;

import java.util.List;

import com.khaoula.livre.dto.LivreDTO;
import com.khaoula.livre.entities.Editeur;
import com.khaoula.livre.entities.Livre;

public interface LivreService {
	LivreDTO saveLivre(LivreDTO l);
	LivreDTO updateLivre(LivreDTO l);
	void deleteLivre(Livre l);
	void deleteLivreById(Long id);
	LivreDTO getLivre(Long id);
	List<LivreDTO> getAllLivre();
	List<Livre> findByNomLivre(String nom);
	List<Livre> findByNomLivreContains(String nom);
	List<Livre> findByNomPrix (String nom, Double prix);
	List<Livre> findByEditeur (Editeur editeur);
	List<Livre> findByEditeurIdEd(Long id);
	List<Livre> findByOrderByNomLivreAsc();
	List<Livre> trierLivreNomsPrix();
	LivreDTO convertEntityToDto (Livre livre);
	Livre convertDtoToEntity(LivreDTO livreDto);

}

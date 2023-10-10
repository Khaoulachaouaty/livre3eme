package com.khaoula.livre.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khaoula.livre.dto.LivreDTO;
import com.khaoula.livre.entities.Editeur;
import com.khaoula.livre.entities.Livre;
import com.khaoula.livre.repos.LivreRepository;

@Service
public class LivreServiceImpl implements LivreService{
	@Autowired
	LivreRepository livreRepository;
	@Override
	public LivreDTO saveLivre(LivreDTO l) {
		 return convertEntityToDto( livreRepository.save(convertDtoToEntity(l)));
	}
	@Override
	public LivreDTO updateLivre(LivreDTO l) {
		 return convertEntityToDto(livreRepository.save(convertDtoToEntity(l)));
	}
	@Override
	public void deleteLivre(Livre l) {
	livreRepository.delete(l);
	}
	 @Override
	public void deleteLivreById(Long id) {
		 livreRepository.deleteById(id);
	}
	@Override
	public LivreDTO getLivre(Long id) {
		return convertEntityToDto(livreRepository.findById(id).get());
	}
	@Override
	public List<LivreDTO> getAllLivre() {
		return livreRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	@Override
	public List<Livre> findByNomLivre(String nom) {
	return livreRepository.findByNomLivre(nom);
	}
	@Override
	public List<Livre> findByNomLivreContains(String nom) {
		return livreRepository.findByNomLivreContains(nom);
	}
	@Override
	public List<Livre> findByNomPrix(String nom, Double prix) {
	return livreRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Livre> findByEditeur(Editeur editeur) {
		return livreRepository.findByEditeur(editeur);
	}
	@Override
	public List<Livre> findByEditeurIdEd(Long id) {
		return livreRepository.findByEditeurIdEd(id);
	}
	@Override
	public List<Livre> findByOrderByNomLivreAsc() {
		return livreRepository.findByOrderByNomLivreAsc();
	}
	@Override
	public List<Livre> trierLivreNomsPrix() {
		return livreRepository.trierLivreNomsPrix();
	}
	@Autowired
	ModelMapper modelMapper;
	@Override
	public LivreDTO convertEntityToDto(Livre livre) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		LivreDTO livreDTO = modelMapper.map(livre, LivreDTO.class);
		return livreDTO;
	}
	 /*ProduitDTO produitDTO = new ProduitDTO();
	 produitDTO.setIdProduit(produit.getIdProduit());
	 produitDTO.setNomProduit(produit.getNomProduit());
	 produitDTO.setPrixProduit(produit.getPrixProduit());
	 produitDTO.setDateCreation(produit.getDateCreation());
	 produitDTO.setCategorie(produit.getCategorie());
	 return produitDTO;*/

	 /*return ProduitDTO.builder()
	.idProduit(produit.getIdProduit())
	.nomProduit(produit.getNomProduit())
	//.prixProduit(produit.getPrixProduit())
	.dateCreation(produit.getDateCreation())
	.categorie(produit.getCategorie())
	//.nomCat(produit.getCategorie().getNomCat())
	.build();
	}*/
	
	@Override
	public Livre convertDtoToEntity(LivreDTO livreDto) {
		Livre livre = new Livre();
		livre = modelMapper.map(livreDto, Livre.class);
		livre.setIdLivre(livreDto.getIdLivre());
		livre.setNomLivre(livreDto.getNomLivre());
		livre.setPrixLivre(livreDto.getPrixLivre());
		livre.setDatePublication(livreDto.getDatePublication());
		livre.setEditeur(livreDto.getEditeur());
		 return livre;
	}

}

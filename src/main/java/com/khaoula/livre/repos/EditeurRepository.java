package com.khaoula.livre.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.khaoula.livre.entities.Editeur;

@RepositoryRestResource(path = "ed")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular 
public interface EditeurRepository extends JpaRepository<Editeur, Long> {

}

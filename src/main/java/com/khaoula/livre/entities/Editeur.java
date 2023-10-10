package com.khaoula.livre.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Editeur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idEd;
private String nomEd;
private String origine;
@JsonIgnore
@OneToMany(mappedBy = "editeur")
private List<Livre> livre;
}

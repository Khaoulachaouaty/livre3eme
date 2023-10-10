package com.khaoula.livre.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomLvre", types = { Livre.class })
public interface LivreProjection {
	public String getNomLivre();
}
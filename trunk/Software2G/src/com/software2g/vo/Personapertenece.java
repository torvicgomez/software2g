package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personapertenece database table.
 * 
 */
@Entity
public class Personapertenece implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonapertenecePK id;

	public Personapertenece() {
	}

	public PersonapertenecePK getId() {
		return this.id;
	}

	public void setId(PersonapertenecePK id) {
		this.id = id;
	}

}
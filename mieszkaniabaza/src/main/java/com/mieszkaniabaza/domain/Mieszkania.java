package com.mieszkaniabaza.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.Min;

import com.mieszkaniabaza.domain.Wynajmujacy;



@Entity
@NamedQueries({ 
	@NamedQuery(name = "Mieszkania.wszystkie", query = "Select m from Mieszkania m")
})
public class Mieszkania {

	private Long id;
 	private Wynajmujacy wynajmujacy;
	private String ulica = "";
	private Integer cena = 0;
	private String opis = "";

	 public Mieszkania() {
	}

	public Mieszkania(Wynajmujacy wynajmujacy, String ulica , Integer cena, String opis)
	{
	this.wynajmujacy = wynajmujacy;
	this.ulica = ulica;
	this.cena = cena;
	this.opis = opis;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "id_wynajmujacy", nullable = false)
	
	public Wynajmujacy getWynajmujacy() {
	return wynajmujacy;
	}
	public void setWynajmujacy(Wynajmujacy wynajmujacy) { this.wynajmujacy=wynajmujacy; }
	
	
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	@Min(0)
	public Integer getCena() {
		return cena;
	}
	public void setCena(Integer cena) {
		this.cena = cena;
	}

	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
}




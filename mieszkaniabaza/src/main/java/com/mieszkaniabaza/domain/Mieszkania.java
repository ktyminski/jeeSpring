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
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Mieszkania.wszystkie", query = "Select m from Mieszkanie m")
})
public class Mieszkania {

	private Long idMieszkania;
 	private Wynajmujacy wynajmujacy;
	private String ulica="";
	private Double cena = 0.0;
	private String opis = "";

	 public Mieszkania() {
	}

	public Mieszkania(Wynajmujacy wynajmujacy, String ulica, Double cena, String opis)
	{
	this.wynajmujacy = wynajmujacy;
	this.ulica = ulica;
	this.cena = cena;
	this.opis = opis;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return idMieszkania;
	}
	public void setId(Long idMieszkania) {
		this.idMieszkania = idMieszkania;
	}

	@ManyToOne
	@JoinColumn(name = "id_Wynajmujacy", nullable = false)

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	@Min(0)
	public Double getCena() {
		return cena;
	}
	public void setCena(Double cena) {
		this.cena = cena;
	}

	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Wynajmujacy getWlasciciel() {
		return wynajmujacy;
		// TODO Auto-generated method stub
		
	}

	public com.mieszkaniabaza.domain.Wynajmujacy getWynajmujacy() {
		return wynajmujacy;
	
	}

	public void setWynajmujacy(Wynajmujacy wynajmujacy) {
		this.wynajmujacy = wynajmujacy;
		
	}
}



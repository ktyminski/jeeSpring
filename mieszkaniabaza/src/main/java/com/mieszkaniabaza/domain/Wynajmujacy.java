package com.mieszkaniabaza.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
@NamedQueries({ 
	@NamedQuery(name = "Wynajmujacy.all", query = "Select w from Wynajmujacy w")
})
public class Wynajmujacy {
	
	private Long idWynajmujacy;
	private String imie;
	private String nazwisko;
	private Long pesel;

	private List<Mieszkania> mieszkania = new ArrayList<Mieszkania>();
	
	@OneToMany(mappedBy = "Wynajmujacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	public List<Mieszkania> getMieszkania() {
	return mieszkania;
	}
	public void setPogrzeby(List<Mieszkania> mieszkania) {
	this.mieszkania = mieszkania;
	}



	public Long getIdWynajmujacy() {
		return idWynajmujacy;
	}

	public void setIdWynajmujacy(Long idWynajmujacy) {
		this.idWynajmujacy = idWynajmujacy;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Wynajmujacy(Long idWynajmujacy, String imie, String nazwisko, Long pesel, List<Mieszkania> mieszkania) {
		super();
		this.idWynajmujacy = idWynajmujacy;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.mieszkania = mieszkania;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public Long getPesel() {
		return pesel;
	}

	public void setPesel(Long pesel) {
		this.pesel = pesel;
	}

	public void setMieszkania(List<Mieszkania> mieszkania) {
		this.mieszkania = mieszkania;
	}

	public Wynajmujacy() {
	}

	public Wynajmujacy(String imie, String nazwisko, Long pesel) {
	this.imie = imie;
	this.nazwisko = nazwisko;
	this.pesel = pesel;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return idWynajmujacy;
	}
	public void setId(Long id) {
		this.idWynajmujacy = id;
	}


	

}
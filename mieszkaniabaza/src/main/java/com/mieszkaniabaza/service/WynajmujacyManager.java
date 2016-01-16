package com.mieszkaniabaza.service;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mieszkaniabaza.domain.Wynajmujacy;

@Stateless
public class WynajmujacyManager {

	@PersistenceContext
	EntityManager em;

	public Wynajmujacy pobierzPoId(Long id) {
		return em.find(Wynajmujacy.class, id);
	}

	public void dodaj(Wynajmujacy wynajmujacy) {
		wynajmujacy.setId(null);
		em.persist(wynajmujacy);
        	em.flush();
	}

	public void edytuj(Wynajmujacy wynajmujacy, String imie, String nazwisko, Long pesel) {
		 wynajmujacy = em.find(Wynajmujacy.class, wynajmujacy.getId());
		 wynajmujacy.setImie(imie);
		 wynajmujacy.setNazwisko(nazwisko);
		 wynajmujacy.setPesel(pesel);
		em.merge(wynajmujacy);
	}

	public void usun(Wynajmujacy wynajmujacy) {
		wynajmujacy = em.find(Wynajmujacy.class, wynajmujacy.getId());
		em.remove(wynajmujacy);
	}

	public List<Wynajmujacy> dajWszystkie() {
		return em.createNamedQuery("wynajmujacy.wszystkie").getResultList();
	}

}



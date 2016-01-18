package com.mieszkaniabaza.service;



	import java.util.Date;
	import java.util.List;

	import javax.ejb.Stateless;
	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;

	import com.mieszkaniabaza.domain.Wynajmujacy;
	import com.mieszkaniabaza.domain.Mieszkania;

	@Stateless
	public class MieszkaniaManager {

		@PersistenceContext
		EntityManager em;

		public Mieszkania pobierzPoId(Long id) {
			return em.find(Mieszkania.class, id);
		}

		public void dodaj(Mieszkania mieszkanie) {
			mieszkanie.setId(null);
			em.persist(mieszkanie);
			Wynajmujacy wynajmujacy = em.find(Wynajmujacy.class, mieszkanie.getWynajmujacy().getId());
			em.merge(wynajmujacy);
		}

		public void edytuj(Mieszkania Mieszkania, Wynajmujacy Wynajmujacy, String ulica, Integer cena, String opis) {
			Mieszkania = em.find(Mieszkania.class, Mieszkania.getId());
			Wynajmujacy tr = em.find(Wynajmujacy.class, Mieszkania.getWynajmujacy().getId());
			
			Mieszkania.setWynajmujacy(Wynajmujacy);
			Mieszkania.setUlica(ulica);
			Mieszkania.setCena(cena);
			Mieszkania.setOpis(opis);
			em.merge(Mieszkania);
		
			em.merge(tr);
		
			em.merge(Wynajmujacy);
		}

		public void usun(Mieszkania Mieszkania) {
			Mieszkania = em.find(Mieszkania.class, Mieszkania.getId());
			Wynajmujacy tr = em.find(Wynajmujacy.class, Mieszkania.getWynajmujacy().getId());
			tr.getMieszkania().remove(Mieszkania);
			em.remove(Mieszkania);
			em.merge(tr);
		}

		public List<Mieszkania> dajWszystkie() {
			return em.createNamedQuery("Mieszkania.wszystkie").getResultList();
		}

	
	
	
}

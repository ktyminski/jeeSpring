package com.mieszkaniabaza.rest;


import java.util.List;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.mieszkaniabaza.domain.Mieszkania;
import com.mieszkaniabaza.domain.Wynajmujacy;
import com.mieszkaniabaza.service.MieszkaniaManager;
import com.mieszkaniabaza.service.WynajmujacyManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;


@Stateless
@Path("/mieszkania")
public class MieszkaniaResources{
    @EJB
    private MieszkaniaManager pm;
    @EJB
    private WynajmujacyManager tm;

    @GET
    @Path("/dajWszystkie")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mieszkania> dajMieszkaniay() {
    	 return pm.dajWszystkie();
    }

    @POST
    @Path("/dodaj")
    @Produces(MediaType.APPLICATION_JSON)
    public Mieszkania dodaj(
            
            @FormParam("wlasciciel") Long wlasciciel,
            @FormParam("ulica") String ulica,
            @FormParam("cena") Double cena,
	    @FormParam("opis") String opis)
    {
	Mieszkania mieszkania = new Mieszkania();


	mieszkania.setWynajmujacy(tm.pobierzPoId(wlasciciel));
	mieszkania.setUlica(ulica);
	mieszkania.setCena(cena);
	mieszkania.setOpis(opis);

	pm.dodaj(mieszkania);

       return mieszkania;
    }

    @PUT
    @Path("/edytuj/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mieszkania edytuj(
            @PathParam("id") Long id,
            @FormParam("wlasciciel") Long wlasciciel,
            @FormParam("ulica") String ulica,
            @FormParam("cena") Double cena,
	    @FormParam("opis") String opis)
    {
	Mieszkania mieszkania = new Mieszkania();

	mieszkania = pm.pobierzPoId(id);
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	try
	{
		pm.edytuj(mieszkania,tm.pobierzPoId(wlasciciel), ulica, cena, opis);
	}
	catch(Exception e)
	{
	}

       return mieszkania;
    }

    @DELETE
    @Path("/usun/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void usun(@PathParam("id") long id)
    {
        Mieszkania mieszkania = new Mieszkania();

        pm.usun(pm.pobierzPoId(id));
    }

    @GET
    @Path("/podglad/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mieszkania podglad(@PathParam("id") long id) {
    	 return pm.pobierzPoId(id);
    }
}






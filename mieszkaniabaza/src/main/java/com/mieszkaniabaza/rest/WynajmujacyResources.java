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
@Path("/wynajmujacy")
public class WynajmujacyResources{
    @EJB
    private WynajmujacyManager tm;

    @GET
    @Path("/dajWszystkie")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Wynajmujacy> dajTrumny() {
    	 return tm.dajWszystkie();
    }

    @POST
    @Path("/dodaj")
    @Produces(MediaType.APPLICATION_JSON)
    public Wynajmujacy dodaj(
            @FormParam("imie") String imie,
            @FormParam("nazwisko") String nazwisko,
            @FormParam("pesel") Long pesel)
    {

        Wynajmujacy wynajmujacy = new Wynajmujacy();

        wynajmujacy.setImie(imie);
        wynajmujacy.setNazwisko(nazwisko);
        wynajmujacy.setPesel(pesel);

        tm.dodaj(wynajmujacy);

        return wynajmujacy;
    }

    @PUT
    @Path("/edytuj/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Wynajmujacy edytuj(
            @PathParam("idWynajmujacy") Long id,
            @FormParam("imie") String imie,
            @FormParam("nazwisko") String nazwisko,
            @FormParam("pesel") Long pesel)
    {
 	Wynajmujacy wynajmujacy = new Wynajmujacy();

	wynajmujacy = tm.pobierzPoId(id);
	tm.edytuj(wynajmujacy, imie, nazwisko, pesel);

        return wynajmujacy;
    }

    @DELETE
    @Path("/usun/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void usun(@PathParam("id") long id)
    {
        Wynajmujacy wynajmujacy = new Wynajmujacy();

        tm.usun(tm.pobierzPoId(id));
    }

    @GET
    @Path("/podglad/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Wynajmujacy podglad(@PathParam("id") long id) {
    	 return tm.pobierzPoId(id);
    }

}
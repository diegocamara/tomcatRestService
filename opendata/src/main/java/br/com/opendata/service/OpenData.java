package br.com.opendata.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.opendata.manager.IExemploManager;

@Component
@Path("/opendata")
public class OpenData {

	@Autowired
	private IExemploManager exemploManager;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getOpenData() {

		getExemploManager().buscarValor(1);

		return "OpenData Service";
	}

	public IExemploManager getExemploManager() {
		return exemploManager;
	}

	public void setExemploManager(IExemploManager exemploManager) {
		this.exemploManager = exemploManager;
	}

}

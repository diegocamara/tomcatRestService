package br.com.opendata.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.opendata.dao.ExemploDAO;

@Service
public class ExemploManager extends AbstractManager<ExemploDAO> implements
		IExemploManager {

	@Autowired
	private ExemploDAO exemploDao;

	@Override	
	@Transactional(readOnly = true)
	public int buscarValor(int codigo) {
		return this.exemploDao.buscarValor(codigo);
	}

	@Override
	public ExemploDAO getDao() {
		return exemploDao;
	}

	public ExemploDAO getExemploDao() {
		return exemploDao;
	}

	public void setExemploDao(ExemploDAO exemploDao) {
		this.exemploDao = exemploDao;
	}

}

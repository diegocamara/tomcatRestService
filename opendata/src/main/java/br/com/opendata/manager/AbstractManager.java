package br.com.opendata.manager;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class AbstractManager<E> {

	public abstract E getDao();

}

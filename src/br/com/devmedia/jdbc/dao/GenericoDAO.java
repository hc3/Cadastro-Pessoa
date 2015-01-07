package br.com.devmedia.jdbc.dao;

import java.util.List;

import br.com.devmedia.exception.PersistenciaException;

public interface GenericoDAO<T> {
	
	void inserir(T obj) throws PersistenciaException;
	
	void atualizar(T obj) throws PersistenciaException;
	
	void deletar(Integer id) throws PersistenciaException;
	
	List<T> listarTodos() throws PersistenciaException;
	
	T buscaPorId(Integer id) throws PersistenciaException;
	
}

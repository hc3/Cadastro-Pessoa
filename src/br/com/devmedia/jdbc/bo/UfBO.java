package br.com.devmedia.jdbc.bo;

import java.util.List;

import br.com.devmedia.exception.NegocioException;
import br.com.devmedia.jdbc.dao.UfDAO;
import br.com.devmedia.jdbc.dto.UfDTO;

public class UfBO {

	public List<UfDTO> listaUf() throws NegocioException {
		List<UfDTO> lista = null;
		try{
			UfDAO ufDAO = new UfDAO();
			lista = ufDAO.listaEstados();
		}catch(Exception e){
			throw new NegocioException(e.getMessage(), e);
		}
		return lista;
	}
}

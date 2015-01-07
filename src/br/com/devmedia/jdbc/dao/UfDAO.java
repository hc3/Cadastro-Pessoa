package br.com.devmedia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.devmedia.exception.PersistenciaException;
import br.com.devmedia.jdbc.ConexaoUtil;
import br.com.devmedia.jdbc.dto.UfDTO;

public class UfDAO {

	public List<UfDTO> listaEstados() throws PersistenciaException {
		List<UfDTO> lista = new ArrayList<UfDTO>();
		
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_UF";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				UfDTO ufDTO = new UfDTO();
				ufDTO.setIdUf(resultSet.getInt(1));
				ufDTO.setSigla(resultSet.getString(2));
				ufDTO.setDescricao(resultSet.getString(3));
				
				lista.add(ufDTO);
			}
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage() , e);
		}
		
		return lista;
	}
	
}

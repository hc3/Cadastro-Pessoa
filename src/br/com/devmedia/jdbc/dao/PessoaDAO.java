package br.com.devmedia.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.devmedia.exception.PersistenciaException;
import br.com.devmedia.jdbc.ConexaoUtil;
import br.com.devmedia.jdbc.dto.EnderecoDTO;
import br.com.devmedia.jdbc.dto.PessoaDTO;
import br.com.devmedia.jdbc.dto.UfDTO;

public class PessoaDAO implements GenericoDAO<PessoaDTO>{

	@Override
	public void inserir(PessoaDTO pessoaDTO) throws PersistenciaException {
		
		try{
			int chaveEnd = insereEndereco(pessoaDTO.getEnderecoDTO());
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO TB_PESSOA (NOME , CPF , SEXO , DTNASC , COD_ENDERECO)" + 
					"VALUES(? , ? , ? , ? , ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setLong(2, pessoaDTO.getCpf());
			statement.setString(3, String.valueOf(pessoaDTO.getSexo()));
			statement.setDate(4 , new Date (pessoaDTO.getDtNascimento().getTime()));
			statement.setInt(5, chaveEnd);
			
			statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage() , e);
		}
	}

	private int insereEndereco(EnderecoDTO enderecoDTO) throws PersistenciaException{
		int chave = 0;
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO TB_ENDERECO (LOGRADOURO , BAIRRO , CIDADE , NUMERO , CEP , COD_UF)" + 
					"VALUES(? , ? , ? , ? , ? , ?)";
			PreparedStatement statement = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, enderecoDTO.getLogradouro());
			statement.setString(2, enderecoDTO.getBairro());
			statement.setString(3 , enderecoDTO.getCidade());
			statement.setLong(4, enderecoDTO.getNumero());
			statement.setInt(5, enderecoDTO.getCep());
			statement.setInt(6, enderecoDTO.getUfDTO().getIdUf());
			statement.execute();
			ResultSet result = statement.getGeneratedKeys();
			if(result.next()){
				chave = result.getInt(1);
			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage() , e);
		}
		return chave;
	}
	
	@Override
	public void atualizar(PessoaDTO pessoaDTO) throws PersistenciaException {
		
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE TB_PESSOA " +
					"SET NOME = ? ,"+
					"CPF = ? , "+
					"SEXO = ? ,"+
					"DTNASC = ? "+
					"WHERE ID_PESSOA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setLong(2, pessoaDTO.getCpf());
			statement.setString(3, String.valueOf(pessoaDTO.getSexo()));
			statement.setDate(4 , new Date (pessoaDTO.getDtNascimento().getTime()));
			statement.setInt(5, pessoaDTO.getIdPessoa());
			
			statement.execute();
			atualizaEndereco(pessoaDTO.getEnderecoDTO());
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage() , e);
		}
		
	}
	
	private void atualizaEndereco(EnderecoDTO enderecoDTO) throws PersistenciaException{
		
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE TB_ENDERECO" +
						" SET LOGRADOURO = ? ," +
						" BAIRRO = ?, " +
						" CIDADE = ?, " +
						" NUMERO = ?, " +
						" CEP = ?, " +
						" COD_UF = ?" +
						" WHERE ID_ENDERECO = ? ";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1 , enderecoDTO.getLogradouro());
			statement.setString(2, enderecoDTO.getBairro());
			statement.setString(3, enderecoDTO.getCidade());
			statement.setLong(4 , enderecoDTO.getNumero());
			statement.setInt(5 , enderecoDTO.getCep());
			statement.setInt(6 , enderecoDTO.getUfDTO().getIdUf());
			statement.setInt(7 , enderecoDTO.getIdEndereco());
			
			statement.execute();
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage() , e);
		}
	}

	@Override
	public void deletar(Integer idPessoa) throws PersistenciaException {
		
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM TB_PESSOA WHERE ID_PESSOA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idPessoa);
			
			statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage() , e);
		}
	}
	
	public void deletaTudo() throws PersistenciaException{
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "DELETE FROM TB_PESSOA";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage() , e);
		}
	}

	@Override
	public List<PessoaDTO> listarTodos() throws PersistenciaException {
		List<PessoaDTO> listaPessoas = new ArrayList<PessoaDTO>();
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setDtNascimento(resultSet.getDate("DTNASC"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				pessoaDTO.setEnderecoDTO(buscaEnderecoPorId(resultSet.getInt("cod_endereco")));
				
				listaPessoas.add(pessoaDTO);
			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage() , e);
		}
		return listaPessoas;
	}
	
	public EnderecoDTO buscaEnderecoPorId(Integer idEndereco) throws PersistenciaException {
		EnderecoDTO enderecoDTO = null;
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "SELECT * FROM TB_ENDERECO WHERE ID_ENDERECO = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idEndereco);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				enderecoDTO = new EnderecoDTO();
				enderecoDTO.setIdEndereco(result.getInt(1));
				enderecoDTO.setLogradouro(result.getString(2));
				enderecoDTO.setBairro(result.getString(3));
				enderecoDTO.setCidade(result.getString(4));
				enderecoDTO.setNumero(result.getLong(5));
				enderecoDTO.setCep(result.getInt(6));
				enderecoDTO.setUfDTO(buscaUfPorId(result.getInt(7)));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage());
		}
		return enderecoDTO;
	}
	
	private UfDTO buscaUfPorId(Integer idUf) throws PersistenciaException{
		UfDTO ufDTO = null;
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "SELECT * FROM TB_UF WHERE ID_UF = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idUf);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				ufDTO = new UfDTO();
				ufDTO.setIdUf(result.getInt(1));
				ufDTO.setSigla(result.getString(2));
				ufDTO.setDescricao(result.getString(3));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage());
		}
		return ufDTO;
	}

	@Override
	public PessoaDTO buscaPorId(Integer id) throws PersistenciaException {
		PessoaDTO pessoaDTO = null;
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA WHERE ID_PESSOA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setDtNascimento(resultSet.getDate("DTNASC"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				pessoaDTO.setEnderecoDTO(buscaEnderecoPorId(resultSet.getInt("cod_endereco")));
			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage() , e);
		}
		return pessoaDTO;
	}
	
	public List<PessoaDTO> filtraPessoa(String nome , Long cpf , String sexo, String orderBy)throws PersistenciaException {
		List<PessoaDTO> lista = new ArrayList<PessoaDTO>();
		
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA ";
			
			boolean ultimo = false;
			
			if(nome != null && !nome.equals("")){
				sql += " WHERE NOME LIKE ? ";
				ultimo = true;
			}
			if(cpf != null && !cpf.equals("")){
				if(ultimo){
					sql += " AND ";
				}else{
					sql += " WHERE ";
					ultimo = true;
				}
				sql += " CPF LIKE ? ";
			}
			if(sexo != null && !sexo.equals("")){
				if(ultimo){
					sql += " AND ";
				}else{
					sql += " WHERE ";
				}
				sql += " SEXO = ? ";
			}
			sql += " ORDER BY " + orderBy;
			PreparedStatement statement = connection.prepareStatement(sql);
			int cont = 0;
			
			if(nome != null && !nome.equals("")){
				statement.setString(++cont, "%" + nome + "%");
			}
			if(cpf != null && !cpf.equals("")){
				statement.setString(++cont, "%" + cpf + "%");
			}
			if(sexo != null && !sexo.equals("")){
				statement.setString(++cont, sexo);
			}
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setDtNascimento(resultSet.getDate("DTNASC"));
				//pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setEnderecoDTO(buscaEnderecoPorId(resultSet.getInt("cod_endereco")));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				
				lista.add(pessoaDTO);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage() , e);
		}
		
		return lista;
		
	}

}

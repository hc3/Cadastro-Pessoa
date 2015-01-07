package br.com.devmedia.jdbc.bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.devmedia.exception.NegocioException;
import br.com.devmedia.exception.ValidaException;
import br.com.devmedia.jdbc.dao.PessoaDAO;
import br.com.devmedia.jdbc.dto.EnderecoDTO;
import br.com.devmedia.jdbc.dto.PessoaDTO;

public class PessoaBO {

	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public void cadastrar (PessoaDTO pessoaDTO)throws NegocioException{
		try{
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.inserir(pessoaDTO);
		}catch(Exception e){
			throw new NegocioException(e.getMessage() , e);
		}
	}
	
	public String[][] listagem(List<Integer> idsPessoas)throws NegocioException{
		String[][] listaRetorno = null;
		int numColuns = 10;
		try{
			PessoaDAO pessoaDAO = new PessoaDAO();
			List<PessoaDTO> lista = pessoaDAO.listarTodos();
			listaRetorno = new String[lista.size()][numColuns];
			
			for(int i = 0; i < lista.size(); i++){
				PessoaDTO pessoaDTO = lista.get(i);
				EnderecoDTO enderecoDTO = pessoaDTO.getEnderecoDTO();
				
				listaRetorno[i][0] = pessoaDTO.getIdPessoa().toString();
				idsPessoas.add(pessoaDTO.getIdPessoa());
				listaRetorno[i][1] = pessoaDTO.getNome();
				listaRetorno[i][2] = pessoaDTO.getCpf().toString();
				listaRetorno[i][3] = pessoaDTO.getSexo() == 'M' ? "Masculino" : "Feminino";
				listaRetorno[i][4] = dateFormat.format(pessoaDTO.getDtNascimento());
				listaRetorno[i][5] = enderecoDTO.getLogradouro();
				listaRetorno[i][6] = enderecoDTO.getCep().toString();
				listaRetorno[i][7] = enderecoDTO.getUfDTO().getDescricao();
				listaRetorno[i][8] = "Editar";
				listaRetorno[i][9] = "Deletar";
			}
			
		}catch(Exception e){
			throw new NegocioException(e.getMessage() , e);
		}
		return listaRetorno;	
	}
	
	public boolean validaNome(String nome) throws ValidaException{
		boolean ehValido = true;
		if (nome == null || nome.equals("")){
			ehValido = false;
			throw new ValidaException("Campo Nome e Obrigatorio");
		}else if (nome.length() > 30 ){
			ehValido = false;
			throw new ValidaException("Campo nome muito grande");
		}
		return ehValido;
	}
	
	public boolean validaCpf(String cpf) throws ValidaException{
		boolean ehValido = true;
		if (cpf == null || cpf.equals("")){
			ehValido = false;
			throw new ValidaException("Campo CPF e Obrigatorio");
		}else if (cpf.length() != 11){
			ehValido = false;
			throw new ValidaException("Campo CPF tem que ter 11 Digitos");
		}else {
			char[] digitos = cpf.toCharArray();
			for(char digito : digitos){
				if(!Character.isDigit(digito)){
					ehValido = false;
					throw new ValidaException("O campo CPF e numerico");
				}
			}
		}
		return ehValido;
	}
	
	public boolean validaEndereco(EnderecoDTO enderecoDTO) throws ValidaException{
		boolean ehValido = true;
		if (enderecoDTO.getLogradouro() == null || enderecoDTO.getLogradouro().equals("")){
			ehValido = false;
			throw new ValidaException("Campo Logradouro e Obrigatorio");
		}else if (enderecoDTO.getBairro() == null || enderecoDTO.getBairro().equals("")){
			ehValido = false;
			throw new ValidaException("Campo Bairro e Obrigatorio");
		}else if (enderecoDTO.getNumero() == null || enderecoDTO.getNumero().equals(0)){
			ehValido = false;
			throw new ValidaException("Campo Numero e Obrigatorio");
		}else if (enderecoDTO.getCep() == null || enderecoDTO.getCep().equals("")){
			ehValido = false;
			throw new ValidaException("Campo CEP e Obrigatorio");
		}
		return ehValido;
	}
	
	public boolean validaDtNascimento(String dtNascimento) throws ValidaException{
		boolean ehValido = true;
		if (dtNascimento == null || dtNascimento.equals("")){
			ehValido = false;
			throw new ValidaException("Campo Data Nascimento e Obrigatorio");
		}else {
			ehValido = false;
			try {
				dateFormat.parse(dtNascimento);
			} catch (ParseException e) {
				throw new ValidaException("Formato invalido de DATA");
			}
		}
		return ehValido;
	}
	
	public String[][] listaConsulta(String nome , Long cpf , char sexo, String orderBy)throws NegocioException{
		String[][] listaRetorno = null;
		int numColuns = 11;
		try{
			PessoaDAO pessoaDAO = new PessoaDAO();
			
			List<PessoaDTO> lista = pessoaDAO.filtraPessoa(nome, cpf, String.valueOf(sexo), orderBy);
			listaRetorno = new String[lista.size()][numColuns];
			
			for(int i = 0; i < lista.size(); i++){
				PessoaDTO pessoaDTO = lista.get(i);
				EnderecoDTO enderecoDTO = pessoaDTO.getEnderecoDTO();
				listaRetorno[i][0] = pessoaDTO.getIdPessoa().toString();
				listaRetorno[i][1] = pessoaDTO.getNome();
				listaRetorno[i][2] = pessoaDTO.getCpf().toString();
				listaRetorno[i][3] = enderecoDTO.getLogradouro();
				listaRetorno[i][4] = enderecoDTO.getBairro();
				listaRetorno[i][5] = enderecoDTO.getCidade();
				listaRetorno[i][6] = enderecoDTO.getCep().toString();
				listaRetorno[i][7] = enderecoDTO.getNumero().toString();
				listaRetorno[i][8] = enderecoDTO.getUfDTO().getDescricao();
				listaRetorno[i][9] = pessoaDTO.getSexo() == 'M' ? "Masculino" : "Feminino";
				listaRetorno[i][10] = dateFormat.format(pessoaDTO.getDtNascimento());
			}
			
		}catch(Exception e){
			throw new NegocioException(e.getMessage() , e);
		}
		return listaRetorno;	
	}
	
	public void removePessoa(Integer idPessoa)throws NegocioException{
		try{
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.deletar(idPessoa);
		}catch(Exception e){
			throw new NegocioException(e.getMessage());
		}
	}
	
	public void removeTudo() throws NegocioException{
		try{
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.deletaTudo();
		}catch(Exception e){
			throw new NegocioException(e.getMessage());
		}
	}
	
	public PessoaDTO buscaPorId(Integer idPessoa) throws NegocioException{
		PessoaDTO pessoaDTO = null;
		try{
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDTO = pessoaDAO.buscaPorId(idPessoa);
		}catch(Exception e){
			throw new NegocioException(e.getMessage());
		}
		return pessoaDTO;
	}
	
	public void Atualizar (PessoaDTO pessoaDTO) throws NegocioException{
		try{
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.atualizar(pessoaDTO);
		}catch(Exception e){
			throw new NegocioException(e.getMessage());
		}
	}
	
}

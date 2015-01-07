package br.com.devmedia.jdbc.bo;

import br.com.devmedia.exception.NegocioException;
import br.com.devmedia.jdbc.dao.LoginDAO;
import br.com.devmedia.jdbc.dto.LoginDTO;

public class LoginBO {
	
	public boolean logar(LoginDTO loginDTO)throws NegocioException{
		boolean resultado = false;
		try{
			if(loginDTO.getNome() == null || "".equals(loginDTO.getNome())){
				throw new NegocioException("Login Obrigatorio");
			}else if (loginDTO.getSenha() == null || "".equals(loginDTO.getSenha())){
				throw new NegocioException("Senha Obrigatoria");
			}else {
				LoginDAO loginDAO = new LoginDAO();
				resultado = loginDAO.logar(loginDTO);
			}
		}catch(Exception e){
			throw new NegocioException(e.getMessage());
		}
		return resultado;
	}

}

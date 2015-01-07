package br.com.devmedia.jdbc.dto;

public class UfDTO {

	private Integer Id_Uf;
	private String sigla;
	private String descricao;
	
	public Integer getIdUf() {
		return Id_Uf;
	}
	public void setIdUf(Integer id_Uf) {
		Id_Uf = id_Uf;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

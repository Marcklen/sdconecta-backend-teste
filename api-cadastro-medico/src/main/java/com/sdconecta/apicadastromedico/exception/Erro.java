package com.sdconecta.apicadastromedico.exception;

import lombok.Data;

@Data
public class Erro {

	public String mensagem;
	public int status;
	
	public Erro(String mensagem, int status) {
		this.mensagem = mensagem;
		this.status = status;
	}
	
}
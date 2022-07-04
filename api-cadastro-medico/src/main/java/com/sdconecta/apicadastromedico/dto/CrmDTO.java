package com.sdconecta.apicadastromedico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmDTO {

	private Integer user;
	
	@NotBlank
	@Size(min = 2, max = 45)
	private String crm;
	
	@NotBlank
	@Size(min = 2, max = 2)
	private String uf;
	
	private String speciality;
}

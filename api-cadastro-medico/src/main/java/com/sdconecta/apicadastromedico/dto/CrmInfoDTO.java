package com.sdconecta.apicadastromedico.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrmInfoDTO {
	
	private String crm;
	private String uf;
	private String speciality;
}

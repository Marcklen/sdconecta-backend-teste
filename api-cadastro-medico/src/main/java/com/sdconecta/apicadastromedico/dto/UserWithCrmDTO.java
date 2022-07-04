package com.sdconecta.apicadastromedico.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserWithCrmDTO {

	private Integer user_id;
	private String name;
	private String surname;
	private List<CrmInfoDTO> crm;
}

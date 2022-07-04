package com.sdconecta.apicadastromedico.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdconecta.apicadastromedico.dto.CrmDTO;
import com.sdconecta.apicadastromedico.dto.UserWithCrmDTO;
import com.sdconecta.apicadastromedico.exception.RegraNegocioException;
import com.sdconecta.apicadastromedico.model.Crm;
import com.sdconecta.apicadastromedico.model.User;
import com.sdconecta.apicadastromedico.repository.CrmRepository;
import com.sdconecta.apicadastromedico.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CrmService {

	private final CrmRepository crmRepository;
	private final UserRepository userRepository;
	
	@Transactional
	public Crm salvar (CrmDTO crmDTO) {
		Integer id = crmDTO.getUser();
		User user = userRepository.findById(id)
						.orElseThrow( () -> new RegraNegocioException("Codigo de Usuario Invalido (ou Inexistente)"));
		Crm crm = new Crm();
		crm.setCrm(crmDTO.getCrm());
		crm.setUf(crmDTO.getUf());
		crm.setSpeciality(crmDTO.getSpeciality());
		crm.setUser(user);
		crmRepository.save(crm);
		
		return crm;
	}
}

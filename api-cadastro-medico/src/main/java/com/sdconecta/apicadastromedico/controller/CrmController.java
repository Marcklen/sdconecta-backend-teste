package com.sdconecta.apicadastromedico.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sdconecta.apicadastromedico.dto.CrmDTO;
import com.sdconecta.apicadastromedico.dto.UserWithCrmDTO;
import com.sdconecta.apicadastromedico.model.Crm;
import com.sdconecta.apicadastromedico.model.User;
import com.sdconecta.apicadastromedico.repository.CrmRepository;
import com.sdconecta.apicadastromedico.service.CrmService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/docs/crm")
@Api(value = "REST API de CRMs")
@CrossOrigin(origins = "*")
public class CrmController {

	private final CrmService crmService;
	private final CrmRepository crmRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Integer save( @RequestBody @Valid CrmDTO crmDTO) {
		Crm crm = crmService.salvar(crmDTO);
		return crm.getId();
	}
	
	@GetMapping
	public List<Crm> findAll(){
		return crmRepository.findAll();
	}
}

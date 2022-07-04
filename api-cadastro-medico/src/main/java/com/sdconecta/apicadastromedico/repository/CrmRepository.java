package com.sdconecta.apicadastromedico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdconecta.apicadastromedico.model.Crm;

public interface CrmRepository extends JpaRepository<Crm, Integer>{
	
	//Optional<Crm> findBySpeciality(String speciality);
	//Optional<Crm> findByIdFetchCrm(Integer id);
}

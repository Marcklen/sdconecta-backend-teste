package com.sdconecta.apicadastromedico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sdconecta.apicadastromedico.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//Optional<User> findByName (@Param("name") String nome);
	//Optional<User> findBySpeciality (@Param("speciality") String speciality);
}

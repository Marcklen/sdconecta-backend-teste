package com.sdconecta.apicadastromedico.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sdconecta.apicadastromedico.model.User;
import com.sdconecta.apicadastromedico.repository.UserRepository;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/docs/users")
@Api(value = "REST API de Usuários")
@CrossOrigin(origins = "*")
public class UserController {

	private final UserRepository userRepository;
	//private final ModelMapper modelMapper;
	
	@GetMapping("{id}")
	public User getUserById (@PathVariable Integer id) {
		return userRepository
				.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"o usuário não encontrado"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User save (@RequestBody @Valid User user) {
		return userRepository.save(user);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Integer id) {
		userRepository
					.findById(id)
					.map( userExistente -> {
						userRepository.delete(userExistente);
						return userExistente;
					})
					.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"o usuário não encontrado"));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update (@PathVariable Integer id,
						@RequestBody User user) {
		userRepository
					.findById(id)
					.map( userExistente -> {
						user.setId(userExistente.getId());
						userRepository.save(user);
						return userExistente;
					})
					.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"o usuário não encontrado"));
	}
	
//	@SuppressWarnings("rawtypes")
	@GetMapping
	public List<User> find (User filtro) {
		ExampleMatcher matcher = ExampleMatcher
									.matching()
									.withIgnoreCase()
									.withStringMatcher(
											ExampleMatcher.StringMatcher.CONTAINING);
		
		Example example = Example.of(filtro, matcher);
		return userRepository.findAll(example);
	}
}
//	private UserDTO converterModelparaDTO(User user) {
//		UserDTO userDTO = new UserDTO();
//		userDTO.setId(user.getId());
//		userDTO.setName(user.getName());
//		userDTO.setSurname(user.getSurname());
//		userDTO.setEmail(user.getEmail());
//		userDTO.setMobile_phone(user.getMobile_phone());
//		return userDTO;
//	}
//	
//	private User converterDTOparaModel(UserDTO userDTO) {
//		User user = new User();
//		user.setId(userDTO.getId());
//		user.setName(userDTO.getName());
//		user.setEmail(userDTO.getEmail());
//		user.setPassword("Confidencial");
//		user.setMobile_phone(userDTO.getMobile_phone());
//		return user;
//	}

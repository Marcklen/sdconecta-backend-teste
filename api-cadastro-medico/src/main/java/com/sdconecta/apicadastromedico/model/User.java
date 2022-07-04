package com.sdconecta.apicadastromedico.model;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TB_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	@NotEmpty(message = "O campo e-mail não pode ser vazio")
	@NotNull(message = "O campo e-mail não pode ser nulo")
	@Email
	@Column(name = "EMAIL", length = 255, unique = true , nullable = false)
	private String email;
	
	@Column(name = "PASSWORD", length = 255, nullable = false)	
	private String password;	
	
	@NotNull(message = "O campo nome não pode ser vazio")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "O nome deve iniciar com letra maiuscula")
	@Column(name = "NAME", length = 255, nullable = false)	
	private String name;	
	
	@NotNull(message = "O campo sobrenome não pode ser vazio")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "O sobrenome deve iniciar com letra maiuscula")
	@Column(name = "SURNAME", length = 255, nullable = false)	
	private String surname;	
	
	@NotNull(message = "O campo telefone não pode ser vazio")
	@Pattern(regexp = "[0-9]*")
	@Column(name = "MOBILE_PHONE", length = 255, nullable = false)	
	private String mobile_phone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<Crm> crm;
}
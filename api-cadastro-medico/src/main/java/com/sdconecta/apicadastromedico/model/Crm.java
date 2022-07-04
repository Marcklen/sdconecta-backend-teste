package com.sdconecta.apicadastromedico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_CRM")
public class Crm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID") //nullable = false, insertable = false, updatable = false)
	private User user;
	
	@Column(name = "CRM", length = 45, nullable = false)
	private String crm;
	
	@Column(name = "UF", length = 2, nullable = false)
	private String uf;
	
	@Column(name = "SPECIALITY", length = 255, nullable = true)
	private String speciality;
}
package com.banco.math.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import com.banco.math.demo.model.audit.UserDateAudit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "account", uniqueConstraints = { @UniqueConstraint(columnNames = { "accountNumber" }) })
public class Account extends UserDateAudit {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "accountNumber")
	private String accountNumber;
	
	@NotBlank
	@Column(name = "digit")
	private String digit;

	@NotBlank
	@Column(name = "cpf")
	private String cpf;
}

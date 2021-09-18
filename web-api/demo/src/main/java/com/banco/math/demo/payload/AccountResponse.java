package com.banco.math.demo.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(Include.NON_NULL)
public class AccountResponse extends UserDateAuditPayload {
	private String accountNumber;
	private String digit;
	private String cpf;
}

package com.everis.kibana.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Time {
	
	private @NonNull String nome;
	private @NonNull int anoFundacao;
	private @NonNull int mundial;

}

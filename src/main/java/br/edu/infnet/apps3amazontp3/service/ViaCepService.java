package br.edu.infnet.apps3amazontp3.service;


import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.apps3amazontp3.service.dto.EnderecoDto;

@FeignClient( url = "https://viacep.com.br/ws/", name = "viaCepService")
public interface ViaCepService {
	
	    @GetMapping("{cep}/json")

	    EnderecoDto buscarEnderecoPor(@PathVariable("cep") String cep);

	}



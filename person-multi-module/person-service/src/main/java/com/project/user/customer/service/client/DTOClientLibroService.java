package com.project.user.customer.service.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.user.customer.handler.RestTemplateResponseErrorHandler;
import com.user.project.customer.libreria.dtomodel.DTOLibro;

@Service
public class DTOClientLibroService {
	
	@Value("${server.url}")
	private String serverUrl;
	private RestTemplate restTemplate;

	@Autowired
	public DTOClientLibroService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
	}
	
	public DTOLibro[] getALL() {
		
		ResponseEntity<DTOLibro[]> responseEntity = restTemplate.getForEntity(serverUrl, DTOLibro[].class);
		DTOLibro[] libri = responseEntity.getBody();
		return libri;
	}

	public DTOLibro get(Integer id) {
		return restTemplate.getForObject(serverUrl + "/" + id, DTOLibro.class);
	}

	public DTOLibro add(DTOLibro dtoLibro) {
		return restTemplate.postForObject(serverUrl, dtoLibro, DTOLibro.class);
	}

	public void delete(Integer id) {
		restTemplate.delete(serverUrl + "/" + id, DTOLibro.class);
	}

	public void update(Integer id, DTOLibro dtoLibro) {
		restTemplate.put(serverUrl + "/" + id, dtoLibro);
	}
}

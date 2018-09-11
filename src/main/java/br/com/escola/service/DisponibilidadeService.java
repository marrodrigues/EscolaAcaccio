package br.com.escola.service;

import java.util.List;

import br.com.escola.dto.DisponibilidadeDTO;

public interface DisponibilidadeService {

	DisponibilidadeDTO save(DisponibilidadeDTO dia);

	List<DisponibilidadeDTO> findAll();

}

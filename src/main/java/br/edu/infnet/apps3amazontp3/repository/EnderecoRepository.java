package br.edu.infnet.apps3amazontp3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apps3amazontp3.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{

}

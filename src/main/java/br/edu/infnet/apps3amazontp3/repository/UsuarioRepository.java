package br.edu.infnet.apps3amazontp3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.apps3amazontp3.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	@Query("from Usuario user where user.email =:email")
	public Optional<Usuario> findByEmail(String email);

	public Usuario save(String email);
	
	
}

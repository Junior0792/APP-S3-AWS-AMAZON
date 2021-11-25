package br.edu.infnet.apps3amazontp3.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apps3amazontp3.model.Endereco;
import br.edu.infnet.apps3amazontp3.model.Usuario;
import br.edu.infnet.apps3amazontp3.repository.EnderecoRepository;
import br.edu.infnet.apps3amazontp3.repository.UsuarioRepository;
import br.edu.infnet.apps3amazontp3.service.AmazonClienteService;
import br.edu.infnet.apps3amazontp3.service.ViaCepService;
import br.edu.infnet.apps3amazontp3.service.dto.EnderecoDto;



@RestController
@RequestMapping ("/usuario")
public class UsuarioController {

	@Autowired
	private ViaCepService viaCepService;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
    @Autowired
    private AmazonClienteService amazonClientService;

   
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Usuario> findAll() {

        return usuarioRepository.findAll();

    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Usuario save(@RequestBody Usuario usuario) {
    	
    	EnderecoDto enderecoDto = viaCepService.buscarEnderecoPor(usuario.getEndereco().getCep());
    	usuario.getEndereco().copyFrom(enderecoDto);
        Usuario u = usuarioRepository.save(usuario);

        return u;

    }
    
    @RequestMapping(method = RequestMethod.PUT)

    public Usuario update(@RequestBody Usuario usuario) {

        Usuario u = usuarioRepository.save(usuario);

        return u;

    }
    
    @RequestMapping(method = RequestMethod.DELETE)

    public void remove(@RequestBody Usuario usuario) {

      usuarioRepository.delete(usuario);

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)

    public Optional<Usuario> getById(@PathVariable Integer id) {

        return  usuarioRepository.findById(id);

    }
    
    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)

    public Optional<Usuario> getByEmail(@PathVariable String email) {

        return  usuarioRepository.findByEmail(email);
    }

}



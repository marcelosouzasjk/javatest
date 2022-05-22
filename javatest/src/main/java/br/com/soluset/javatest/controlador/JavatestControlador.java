package br.com.soluset.javatest.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.soluset.javatest.domain.Account;
import br.com.soluset.javatest.domain.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class JavatestControlador {
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping
	public List<Account> listar(){
		List<Account> usuarios = accountRepository.findAll();
		return usuarios;
	}
	
	@GetMapping("/{id}")
	public String buscar(@PathVariable Long id){
		Optional<Account> resultado = accountRepository.findById(id);
		Account usuario = resultado.get();
		return usuario.getName() + "," + usuario.getUser() + "," + usuario.getEmail();
	}
	
	@PostMapping
	public Account inserir (@RequestBody Account usuarios) {
		Account usuarioInserido = accountRepository.save(usuarios);
		return usuarioInserido;
	}
	
	@DeleteMapping("/{id}")	
	public Account excluir (@PathVariable Long id){
		Optional<Account> account = accountRepository.findById(id);
		accountRepository.delete(account.get());
		Account usuarioRetorno = account.get();
		return usuarioRetorno; 
	}
	
	@PutMapping
	public Account editar(@RequestBody Account usuario) {
		Account usuarioEditado = accountRepository.save(usuario);
		return usuarioEditado;
	}
	
}

package br.com.soluset.javatest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soluset.javatest.domain.Account;
import br.com.soluset.javatest.domain.repository.AccountRepository;
import br.com.soluset.javatest.exception.NotFoundResourceException;

@Service
public class UsuariosService {
	@Autowired
	private AccountRepository accountRepository;
	
	public Account buscarPorCodigo(Long id) {
		Optional <Account> resultado = accountRepository.findById(id);
		
		if(resultado.isEmpty()) {
			throw new NotFoundResourceException();
		}
		
		Account account = resultado.get();
		return account;
	}
	public List<Account> listar(){
		List<Account> resultado = accountRepository.findAll();
		return resultado;
	}
	
}


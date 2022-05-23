package br.com.soluset.javatest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.soluset.javatest.domain.Account;
import br.com.soluset.javatest.domain.repository.AccountRepository;

@SpringBootTest
public class AccountRepositoryTests {
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void inserir() {
		Account u1 = new Account();
		Account u2 = new Account();
		
		accountRepository.save(u1);
		accountRepository.save(u2);
	}
}
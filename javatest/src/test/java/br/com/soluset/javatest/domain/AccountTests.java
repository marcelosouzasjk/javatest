package br.com.soluset.javatest.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountTests {
	@Test
	public void cadastrar() {
		Account u = new Account();
		System.out.println(u);
	}
}

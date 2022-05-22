package br.com.soluset.javatest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.soluset.javatest.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}

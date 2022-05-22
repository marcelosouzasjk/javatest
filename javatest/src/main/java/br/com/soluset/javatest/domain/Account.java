package br.com.soluset.javatest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.NamedQuery;
import javax.persistence.PreRemove;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

//import org.hibernate.annotations.SQLDelete;
//import org.hibernate.annotations.Where;
import org.jboss.logging.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@SQLDelete(sql = "UPDATE account SET state = 'DELETED' WHERE id = ? AND state <> 'DELETED'", check = ResultCheckStyle.COUNT) 
//@Where(clause = "state <> 'DELETED'")
//@NamedQuery(name = "Account.FindByName", query = "SELECT a FROM Account a WHERE a.name like :name")
public class Account {
	
	@Transient
	Logger log = Logger.getLogger(this.getClass().getName());
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(length = 50, nullable = false, unique = false)
	private String Name;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(length = 50, nullable = false, unique = true)
	private String user;
	
	@Column(length = 50, nullable = false, unique = false)
	@Size(min = 6, max = 50)
	private String password;
	
	@Column
	@Enumerated(EnumType.STRING)
	private AccountState state;
			
	@PreRemove
	public void deleteUser(){
		log.info("Set status to DELETED");
		this.state = AccountState.DELETED;
	}
}

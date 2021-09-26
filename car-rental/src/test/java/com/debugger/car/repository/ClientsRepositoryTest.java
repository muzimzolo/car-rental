package com.debugger.car.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.debugger.car.domain.CarClient;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
   TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:test-data-set.xml")
class ClientsRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ClientsRepository clientsRepository;
	
	
	@Test
	public void findByEmailTest() {
		CarClient foundClient = clientsRepository.findByEmailAddress("muzi@icloud.com");
		assertThat(foundClient.getEmailAddress(), is(equalTo("muzi@icloud.com")));

	}
	
	@Test
	public void testByEmailBypassRepoClass() {
		// Find an inserted record
	CarClient foundClient = entityManager.find(CarClient.class, new Long("2"));
    assertThat(foundClient.getEmailAddress(), is(equalTo("tzulu@outlook.com")));

	}

}

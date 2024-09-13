package com.xiongping.transacation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service

public class TableVersionService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private TableVersionService service;

	@Transactional
	public void insert1() {
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		jdbcTemplate.execute("insert into table_version values(1,'user1',1)");
		throw new RuntimeException();
	}

	@Transactional
	public void insert2() {
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		jdbcTemplate.execute("insert into table_version values(2,'user1',1)");
		try {
			throw new RuntimeException();
		} catch (Exception e) {
		}

	}

	@Transactional
	public void insert3() {
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		jdbcTemplate.execute("insert into table_version values(300,'user1',1)");
		service.insert3_1();
	}

	public void insert3_1() {
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		jdbcTemplate.execute("insert into table_version values(301,'user1',1)");
	}

	@Transactional
	public void insert4() {
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		jdbcTemplate.execute("insert into table_version values(400,'user1',1)");
		service.insert4_1();
	}

	public void insert4_1() {
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		jdbcTemplate.execute("insert into table_version values(401,'user1',1)");
		throw new RuntimeException();
	}

	@Transactional
	public void insert5() {
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		jdbcTemplate.execute("insert into table_version values(500,'user1',1)");
		insert5_1();
	}

	public void insert5_1() {
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		jdbcTemplate.execute("insert into table_version values(501,'user1',1)");
		try {
			throw new RuntimeException();
		} catch (Exception e) {
		}
	}


	@Transactional
	public void insert6() {
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		jdbcTemplate.execute("insert into table_version values(600,'user1',1)");
		service.insert6_1();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insert6_1() {
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		jdbcTemplate.execute("insert into table_version values(601,'user1',1)");
	}

	@Transactional
	public void insert100() {
		jdbcTemplate.execute("insert into table_version values(2,'user1',1)");
		try {
			service.insert200();
		} catch (Exception e) {

		}
	}

	@Transactional()
	public void insert200() {
		jdbcTemplate.execute("insert into table_version values(3,'user2',1)");
		try {
			throw new RuntimeException();
		} catch (Exception e) {
		}
	}
}

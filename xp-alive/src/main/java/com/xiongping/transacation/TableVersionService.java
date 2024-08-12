package com.xiongping.transacation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TableVersionService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TableVersionService service;
    
    public void insert1() {
        jdbcTemplate.execute("insert into table_version values(2,'user1',1)");
        try {
            service.insert2();
        } catch (Exception e) {
        
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert2() {
        jdbcTemplate.execute("insert into table_version values(3,'user2',1)");
        throw new RuntimeException();
    }
}

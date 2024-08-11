package com.xiongping.transacation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author xiongping
 * @date 2024-08-01
 */
@ComponentScan("com.xiongping.transacation")
public class TransactionApplication {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                TransactionApplication.class);
    
        TableVersionService tableVersionService = (TableVersionService) context.getBean("tableVersionService");
        tableVersionService.insert1();
        
    }
}

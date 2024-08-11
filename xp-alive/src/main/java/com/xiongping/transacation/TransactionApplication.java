package com.xiongping.transacation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xiongping
 * @date 2024-08-01
 */
@ComponentScan("com.xiongping.transacation")

public class TransactionApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionApplication.class);

	}
}

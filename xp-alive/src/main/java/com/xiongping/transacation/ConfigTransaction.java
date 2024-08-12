package com.xiongping.transacation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xiongping
 * @date 2024-08-01
 */
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class ConfigTransaction {
}

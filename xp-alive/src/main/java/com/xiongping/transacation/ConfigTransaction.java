package com.xiongping.transacation;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xiongping
 * @date 2024-08-01
 */
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableAsync
//@EnableCaching
public class ConfigTransaction {
}

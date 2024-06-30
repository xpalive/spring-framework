package com.xiongping.inferredConstruct;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InferredConstructTest {
    
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        BeanDefinition userBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(UserService.class)
                .getBeanDefinition();
        BeanDefinition departmentBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(DepartmentService.class)
                .getBeanDefinition();
        BeanDefinition orderBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(OrderService.class)
                .getBeanDefinition();
        
//        userBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(new DepartmentService());
//        userBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(new OrderService());
        userBeanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        context.registerBeanDefinition("userService", userBeanDefinition);
        context.registerBeanDefinition("departmentService", departmentBeanDefinition);
        context.registerBeanDefinition("orderService", orderBeanDefinition);
        context.refresh();
        
        UserService userService = context.getBean("userService", UserService.class);
        userService.getOrderService().print();
        userService.getDepartmentService().print();
        userService.print();
        context.getBean("userService", UserService.class);
    }
}

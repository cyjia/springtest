package org.sug.demo.springtest.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sug.demo.springtest.service.RegistrationService;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class Test0SpringAutowire {

    @Test
    public void should_autowire_fields() throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("test-domain-context.xml");

        assertThat(beanFactory.getBean(RegistrationService.class), notNullValue());
    }

}

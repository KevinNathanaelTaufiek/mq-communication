package com.kevinnathanaeltaufiek.mq_communication.configuration;

import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import com.ibm.mq.spring.boot.MQConfigurationProperties;
import com.ibm.mq.spring.boot.MQConnectionFactoryCustomizer;
import com.ibm.mq.spring.boot.MQConnectionFactoryFactory;
import jakarta.jms.ConnectionFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import java.util.List;

@Configuration
public class Qm2Config {

    @Bean
    @ConfigurationProperties("qm2")
    public MQConfigurationProperties qm2ConfigProperties() {
        return new MQConfigurationProperties();
    }

    @Bean
    public MQConnectionFactory qm2ConnectionFactory(@Qualifier("qm2ConfigProperties") MQConfigurationProperties properties, ObjectProvider<List<MQConnectionFactoryCustomizer>> factoryCustomizers) {
        return new MQConnectionFactoryFactory(properties, factoryCustomizers.getIfAvailable()).createConnectionFactory(MQConnectionFactory.class);
    }

    @Bean
    public JmsListenerContainerFactory<?> qm2JmsListenerContainerFactory(@Qualifier("qm2ConnectionFactory") ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

}
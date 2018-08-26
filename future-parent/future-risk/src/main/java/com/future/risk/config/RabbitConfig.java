package com.future.risk.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	final static String MARKET_EXCHANGE = "com.future.market";
	
	final static String ROUTER_KEY = "instrument.*";
	
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(MARKET_EXCHANGE);
	}
	
	@Bean
	Queue marketQueue() {
		return new Queue("marketQ", false, true, true);
	}
	
	@Bean
	Binding binding(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with(ROUTER_KEY);
	}
	
	@Bean
	MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	

}

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
	
//	@Bean
//	Binding binding(Queue marketQueue, TopicExchange exchange) {
//		return BindingBuilder.bind(marketQueue).to(exchange).with(ROUTER_KEY);
//	}
	
	@Bean
	Binding bindingi(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.i1901");
	}
	
	@Bean
	Binding bindingj(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.j1901");
	}
	
	@Bean
	Binding bindingjm(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.jm1901");
	}
	
	@Bean
	Binding bindingzc(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.ZC901");
	}
	
	@Bean
	Binding bindingrb(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.rb1901");
	}
	
	@Bean
	Binding bindingcu(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.cu1810");
	}
	
	@Bean
	Binding bindingni(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.ni1811");
	}
	
	@Bean
	Binding bindingzn(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.zn1810");
	}
	
	@Bean
	Binding bindingru(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.ru1901");
	}
	
	@Bean
	Binding bindingma(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.MA901");
	}
	
	@Bean
	Binding bindingsr(Queue marketQueue, TopicExchange exchange) {
		return BindingBuilder.bind(marketQueue).to(exchange).with("instrument.SR901");
	}
	
//		BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.i1901");//铁矿石
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.j1901");//焦炭
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.jm1901");//焦煤
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.ZC901");//动力煤（主力）
//        
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.rb1901");//螺纹
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.cu1810");//铜（主力）
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.ni1811");//镍（主力）
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.zn1810");//锌（主力）
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.ru1901");//橡胶（主力）
//        
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.MA901");//甲醇
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.l1901");//塑料（主力）
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.bu1812");//沥青
//
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.CF901");//棉花
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.SR901");//白糖
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.m1901");//豆粕
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.RM901");//菜粕（主力）
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.y1901");//豆油
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.p1901");//棕榈油
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.OI901");//菜油
//        BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.pp1901");//（主力）
	
	@Bean
	MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	

}

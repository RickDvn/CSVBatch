package com.orange.batch.process;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockProcessor {
	@Bean
	public StockItemProcessor processor() {
		return new StockItemProcessor();
	}
}

package com.orange.batch.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

import com.orange.batch.model.Stock;

@Component
public class StockWriter {
	
	@Bean
	public FlatFileItemWriter<Stock> writer() {
		return new FlatFileItemWriterBuilder<Stock>().name("productoItemWriter")
				.resource(new PathResource("src/main/resources/data/local/stockTerminales.csv")).delimited()
				.names("lugar", "id", "stock", "stockReal", "stockVirtual")
				.build();
	}
}

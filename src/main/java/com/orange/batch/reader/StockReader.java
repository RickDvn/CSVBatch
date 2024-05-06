package com.orange.batch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.orange.batch.model.Stock;

@Component
public class StockReader {

	@Bean
	public FlatFileItemReader<Stock> read() {

		// El separador de las columnas
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(";");
		tokenizer.setStrict(false); // Para que no tenga en cuenta las columnas extra
		tokenizer.setNames("lugar", "id", "stock", "stockReal", "stockVirtual");

		DefaultLineMapper<Stock> lineMapper = new DefaultLineMapper<Stock>();
		lineMapper.setLineTokenizer(tokenizer);

		// Inicializacion del mapper que a sonarlint le gusta
		BeanWrapperFieldSetMapper<Stock> mapper = new BeanWrapperFieldSetMapper<Stock>();
		
		mapper.setTargetType(Stock.class);
		lineMapper.setFieldSetMapper(mapper);
		lineMapper.setLineTokenizer(tokenizer);
		
		return new FlatFileItemReaderBuilder<Stock>().name("stockItemReader").linesToSkip(1)
				.resource(new FileSystemResource("src/main/resources/data/local/stockTerminales.dat"))
				.lineMapper(lineMapper).build();
	}
	
}

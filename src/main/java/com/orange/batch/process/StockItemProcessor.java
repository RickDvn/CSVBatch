package com.orange.batch.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.orange.batch.model.Stock;

public class StockItemProcessor implements ItemProcessor<Stock, Stock>{

	private static final Logger log = LoggerFactory.getLogger(StockItemProcessor.class);
	
	@Override
	public Stock process(final Stock stock) {
		log.info("Processing: " + stock);
		
		if (stock.getLugar().equalsIgnoreCase("PENINSULA")) {
			return stock;
		}else {
			return null;
		}
		
	}
	
}

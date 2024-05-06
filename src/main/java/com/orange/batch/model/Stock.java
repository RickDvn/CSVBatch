package com.orange.batch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
	
	private String lugar;
	private Long id;
	private int stock;
	private int stockReal;
	private int stockVirtual;
}

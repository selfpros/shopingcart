package com.Ibm.utility;

import java.util.UUID;

public class ProductCodeGen {
	
	public static String getCode()
	{
		return "PRD"+UUID.randomUUID().toString().replace("-","").substring(1, 11).toUpperCase();
				
	}

}

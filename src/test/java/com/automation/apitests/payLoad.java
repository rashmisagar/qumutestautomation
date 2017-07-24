package com.automation.apitests;

import java.util.Random;

public class payLoad {

	
	public static String getPutData()
	{
		Random random = new Random();
	
		String b = String.format("{\"pos\":{\"left\":%1$d,\"top\":%2$d}}", random.nextInt(30), random.nextInt(20));
		
		return b;
	}
}

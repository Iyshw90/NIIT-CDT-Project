package com.web.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTesting {
	public static void main(String args[])
	{
		//initiates the class which has @configuration annotation and runs it.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//scans this base pacakage and complies all the java files in it.
		context.scan("com.web");
		context.refresh();
	}

}

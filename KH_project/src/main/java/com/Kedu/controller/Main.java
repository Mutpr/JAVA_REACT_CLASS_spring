package com.Kedu.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String [] args) {
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("application-context.xml");
	}
}

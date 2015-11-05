package com.employee.util;


import java.util.Scanner;

public class  KeyBoard {
	static Scanner scanner = new Scanner(System.in);

	public static int readInt(String message) {
		System.out.println(message);
		try {
			int number = Integer.parseInt(scanner.next());
			return number;

		} catch (NumberFormatException nfe) {
			System.out.println("enter valid input");
			return readInt(message);
		}
	}

	public static String readString(String message) {
		System.out.println(message);
		return scanner.next();
	}
	
	public static void print(String message) {
		System.out.println(message);
	}
}



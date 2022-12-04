package com.cucumberFramework.utils;

import java.util.Random;

public class TestUtitlities {

	public static String generateRandomUsername() {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		}

		return sb.toString();
	}
}

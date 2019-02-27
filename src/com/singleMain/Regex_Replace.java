package com.singleMain;

import java.util.regex.Pattern;

public class Regex_Replace {
	public static void main(String[] args) {
		String term = "dfhdfjk%sdsd%sfdjfkl";
		System.out.println(term.replaceAll("%s", "_REGEX_"));
		//Java内部类：Pattern
		final Pattern pattern = Pattern.compile("%s");
		System.out.println("Pattern："+ pattern.matcher(term).replaceAll("_PATTERN_"));
		System.out.println(term);
	}

}

package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class test1 {

public static void main(String[] args) {
	List<String> words=Arrays.asList("win","try","best","luck","do");
	Predicate<String> test1=w->{
		System.out.println("Checking...");
		return w.equals("do");				//line n1

	};
	Predicate<String> test2=(String w)->w.length()>3;//line 2
	words.stream()
			.filter(test2)
			.filter(test1)
			.count();
}
}
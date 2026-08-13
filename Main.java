package com.lambda3;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * ::
 * 1. 类::静态方法
 * 2. 实例对象::实例方法
 * 3. 类::实例方法
 * 4. 类::new
 */
public class Main {
	public static void main(String[] args) {
		Function<String, Integer> func1 = User::test1;
		System.out.println(func1.apply("123456"));
		
		User u = new User();
		Function<String, Double> func2 = u::test2;
		System.out.println(func2.apply("123456"));
		
		BiFunction<String, String, Boolean> bi = String::equals;
		System.out.println(bi.apply("a", "a"));
		System.out.println(bi.apply("a", "b"));
		
		Supplier<User> s = User::new;
		User u2 = s.get();
		
		Function<String, User> func3 = User::new;
		User u3 = func3.apply("das");
		System.out.println(u3.username);
	}
}

class User {
	public String username;
	public static Integer test1(String str) {
		return Integer.parseInt(str);
	}
	public Double test2(String str) {
		return Double.parseDouble(str);
	}
	
	public User() {}
	public User(String username) {}
}

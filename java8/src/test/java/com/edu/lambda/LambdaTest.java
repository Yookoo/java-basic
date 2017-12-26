package com.edu.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.edu.entity.Employee;

public class LambdaTest {

	/**
	 * Lambda表达式 Supplier Consumer void accept(T t); Function Predicate
	 */
	@Before
	public void setUp() {
		List<Employee> employees = Arrays.asList(new Employee(1L, "张三", 1000.0), new Employee(2L, "李四", 2333.3),
				new Employee(3L, "王五", 5555.5), new Employee(4L, "赵六", 8000.0), new Employee(5L, "田七", 6000.0),
				new Employee(6L, "孙八", 9999.0));
	}

	/**
	 * Lambda表达式 用于替代传统的匿名内部类
	 */
	@Test
	public void test1() {
		// 传统的匿名方法
		new Runnable() {
			public void run() {
				System.out.println("——run()——");
			}
		}.run();
		//Lambda表达式
		Runnable runable = ()->System.out.println("——Lambda()——");
		runable.run();
	}

	public void test2() {
		// TODO Auto-generated method stub

	}

	public void test3() {
		// TODO Auto-generated method stub

	}

}

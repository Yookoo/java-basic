package com.edu.stream;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.edu.entity.Employee;

public class StreamAPITest {
	
	List<Employee> employees = new ArrayList<>();

	@Before
	public void setUp() {
		employees = Arrays.asList(new Employee(1L, "张三", 30, 1000.0), new Employee(2L, "李四", 20, 2333.3),
				new Employee(3L, "王五", 8, 5555.5), new Employee(4L, "赵六", 60, 8000.0),
				new Employee(5L, "田七", 55, 6000.0), new Employee(6L, "孙八", 48, 9999.0));
	}
	@Test
	public void test1() throws Exception {
		employees.stream()
			.filter((e) -> e.getAge()>=35)
			.forEach(System.out::println);
	}
}

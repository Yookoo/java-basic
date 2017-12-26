package com.edu.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.edu.entity.Employee;

public class LambdaTest {

	/**
	 * Lambda���ʽ Supplier Consumer void accept(T t); Function Predicate
	 */
	@Before
	public void setUp() {
		List<Employee> employees = Arrays.asList(new Employee(1L, "����", 1000.0), new Employee(2L, "����", 2333.3),
				new Employee(3L, "����", 5555.5), new Employee(4L, "����", 8000.0), new Employee(5L, "����", 6000.0),
				new Employee(6L, "���", 9999.0));
	}

	/**
	 * Lambda���ʽ ���������ͳ�������ڲ���
	 */
	@Test
	public void test1() {
		// ��ͳ����������
		new Runnable() {
			public void run() {
				System.out.println("����run()����");
			}
		}.run();
		//Lambda���ʽ
		Runnable runable = ()->System.out.println("����Lambda()����");
		runable.run();
	}

	public void test2() {
		// TODO Auto-generated method stub

	}

	public void test3() {
		// TODO Auto-generated method stub

	}

}

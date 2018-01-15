package com.edu.lambda;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import com.edu.entity.Employee;

public class LambdaTest {

	/**
	 * Lambda���ʽ Supplier Consumer void accept(T t); Function Predicate
	 */
	List<Employee> employees = new ArrayList<>();

	@Before
	public void setUp() {
		employees = Arrays.asList(new Employee(1L, "����", 30, 1000.0), new Employee(2L, "����", 20, 2333.3),
				new Employee(3L, "����", 8, 5555.5), new Employee(4L, "����", 60, 8000.0),
				new Employee(5L, "����", 55, 6000.0), new Employee(6L, "���", 48, 9999.0));
	}
	
	//���󣺻�ȡ��˾�й��ʴ��� 5000 ��Ա����Ϣ
	@Test
	public void test4() throws Exception {
		System.out.println("------------------lambda-------------------");
		filterEmployees(employees,(e)->e.getSalary()>=5000).forEach(System.out::println);
		System.out.println("------------------stream-------------------");
		employees.stream().filter((e)->e.getSalary()>=5000).forEach(System.out::println);
	
	}
	// ���󣺻�ȡ��˾������С�� 35 ��Ա����Ϣ
	@Test
	public void test3() {
		System.out.println("---------------��ͳ����--------------------");
		List<Employee> list1 = new ArrayList<>();
		
		for (Employee emp : employees) {
			if(emp.getAge() <= 35){
				list1.add(emp);
			}
		}
		for (Employee employee : list1) {
			System.out.println("--------" + employee + "----------");
		}
		System.out.println("----------------����һ-------------------");
		List<Employee> list2 = new ArrayList<>();
		Consumer<Employee> filter = (e)->{
			if(e.getAge() >= 35){
				list2.add(e);
			}
		};
		employees.forEach(filter::accept);	
		list2.forEach(System.out::println);
		System.out.println("----------------������-------------------");
		List<Employee> filterEmployees = filterEmployees(employees, (e) -> e.getAge() >= 35);
		filterEmployees.forEach(System.out::println);
	}

	public List<Employee> filterEmployees(List<Employee> list, Predicate<Employee> predicate){
		List<Employee> list2 = new ArrayList<>();
		for (Employee employee : list) {
			if(predicate.test(employee)){
				list2.add(employee);
			}
		}
		return list2;
	}
	/**
	 * --------------------------------------------------------------------- ����
	 * 
	 */

	@Test
	public void test2() {
		Comparator<Employee> comparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return Integer.compare(o1.getAge(), o2.getAge());
			}
		};
		Collections.sort(employees, comparator);

		for (Employee employee : employees) {
			System.out.println("--------" + employee + "----------");
		}
		Comparator<Employee> comparator2 = (o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary());

		Collections.sort(employees, comparator2);
		employees.forEach(System.out::println);
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
		// Lambda���ʽ
		Runnable runable = () -> System.out.println("����Lambda()����");
		runable.run();
	}

}

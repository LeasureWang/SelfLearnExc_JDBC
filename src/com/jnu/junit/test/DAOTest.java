package com.jnu.junit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.jnu.thr.jdbc.Customer;
import com.jnu.thr.jdbc.DAO;

public class DAOTest {

	DAO dao = new DAO();

	@Test
	public void testUpdate() {

		String sql = "insert into tb_customer(cutr_key,cutr_name,cutr_location,cutr_tel)"
				+ "values(?,?,?,?)";
		dao.update(sql, 20170806, "jnu", "tianhe", 985211);

	}

	@Test
	public void testGet() {
		String sql = "select cutr_key customerKey,cutr_name customerName,"
				+ "cutr_location customerLocation,cutr_tel customerTel from tb_customer where cutr_key=?";
		Customer customer = dao.get(Customer.class, sql, 20170806);
		System.out.println(customer);
	}

	@Test
	public void testGetForList() {
		String sql = "select cutr_key customerKey,cutr_name customerName,"
				+ "cutr_location customerLocation,cutr_tel customerTel from tb_customer";
		List<Customer> customer = dao.getForList(Customer.class, sql);
	
		System.out.println(customer);

	}

	@Test
	public void testGetForValue() {
		String sql="select cutr_location from tb_customer where cutr_tel=?";
		String location=(String) dao.getForValue(sql, 211);
		System.out.println(location);
		
		sql="select max(cutr_key) from tb_customer";
		int key=(int) dao.getForValue(sql);
		System.out.println(key);
		
	}

}

package com.kfit.demo.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kfit.demo.bean.Cat;

/**
 * 使用@Repository注解，标注这是一个持久化操作对象.
 * @author sulei
 *
 */
@Repository
public class CatDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	public Cat selectByCatName(String catName){
		/**
		 * 1、定义一个Sql语句；
		 * 2、定义一个RowMapper.
		 * 3、执行查询方法.
		 */
		String sql="select *from cat where cat_name=?";
		RowMapper<Cat> rowMapper=new BeanPropertyRowMapper<>(Cat.class);
		Cat cat=jdbcTemplate.queryForObject(sql, new Object[]{catName},rowMapper);
		return cat;
	}
}

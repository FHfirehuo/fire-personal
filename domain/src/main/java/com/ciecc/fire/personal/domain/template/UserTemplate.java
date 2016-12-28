package com.ciecc.fire.personal.domain.template;

//import java.sql.ResultSet;
//import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ciecc.fire.personal.domain.User;

@Repository
public class UserTemplate {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getByUserName(String userName) {
		
		User u = new User();
		String sql = "select * from sys_user where username = ?";

		try {
			u = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userName);
		} catch (EmptyResultDataAccessException e) {

		}

		return u;

	}

	/*
	 * 这种也会报Incorrect result size: expected 1, actual 0的错误
	 * 使用这种方法打开上面import的三个注释
	 * public User getByUserName(String userName) { User u = new User(); String
	 * sql = "select * from sys_user where username = ?";
	 * 
	 * u = jdbcTemplate.queryForObject(sql, new UserMapper(), userName);
	 * 
	 * return u;
	 * 
	 * }
	 * 
	 * private class UserMapper implements RowMapper<User> {
	 * 
	 * public User mapRow(ResultSet rs, int rowNum) throws SQLException { User
	 * user = new User(); user.setId(rs.getInt("id"));
	 * user.setName(rs.getString("name"));
	 * user.setUsername(rs.getString("username"));
	 * user.setPassword(rs.getString("password")); return user; }
	 * 
	 * }
	 */

}

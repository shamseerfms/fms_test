package com.fms.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.dao.UserDao;
import com.fms.model.User;
import com.fms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void add(User user) {
		userDao.add(user);
		
	}

	@Transactional
	public void edit(User user) {
		userDao.edit(user);
	}

	
	public List<User> getAllUser() {
		 String sql = "select * from users";
         List<User> users = new ArrayList<User>();
	      
        @SuppressWarnings("unchecked")
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            User user = new User();
	        user.setId(Integer.parseInt(String.valueOf(row.get("id"))));
	        user.setFirstName((String)row.get("first_name"));
	        user.setLastName((String)row.get("last_name"));
	        users.add(user);
	     }
	 
	    return users;
	}
}

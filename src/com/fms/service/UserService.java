package com.fms.service;
import com.fms.model.User;

import java.util.List;

public interface UserService {
	public void add(User user);
	public void edit(User user);
	public List<User> getAllUser();
}

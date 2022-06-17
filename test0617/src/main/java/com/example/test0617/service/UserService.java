package com.example.test0617.service;

import com.example.test0617.domain.Role;
import com.example.test0617.domain.User;

import java.util.List;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}

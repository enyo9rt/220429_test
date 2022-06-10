package com.sparta.test0610.controller;

import com.sparta.test0610.dto.PutRequestDto;
import com.sparta.test0610.dto.UsersRequestDto;
import com.sparta.test0610.models.Users;
import com.sparta.test0610.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
	private final UsersService usersService;
	
	@Autowired
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@GetMapping("/read/{id}")
	public Users get(@PathVariable Long id) {
		return usersService.getUsers(id);
	}
	
	@PostMapping("/create")
	public Users post(@RequestBody UsersRequestDto requestDto) {
		return usersService.createUser(requestDto);
	}
	
	@PutMapping("/update/{id}")
	public Long post(@PathVariable Long id, @RequestBody PutRequestDto requestDto) {
		return usersService.updateUser(id, requestDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public Long delete(@PathVariable Long id) {
		return usersService.deleteUser(id);
	}
	
	@GetMapping("/recommend/{id}")
	public List<Users> match(@PathVariable Long id) {
		return usersService.matching(id);
	}
}

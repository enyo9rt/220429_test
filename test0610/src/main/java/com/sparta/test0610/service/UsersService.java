package com.sparta.test0610.service;

import com.sparta.test0610.dto.PutRequestDto;
import com.sparta.test0610.dto.UsersRequestDto;
import com.sparta.test0610.models.Users;
import com.sparta.test0610.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersService {
	private final UsersRepository usersRepository;
	
	@Autowired
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	@Transactional
	public Users getUsers(Long id) {
		Users user = usersRepository.findById(id).orElseThrow(
				() -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
		);
		return user;
	}
	
	public Users createUser(UsersRequestDto requestDto) {
		Users user = new Users(requestDto);
		usersRepository.save(user);
		return user;
	}
	
	@Transactional
	public Long updateUser(Long id, PutRequestDto requestDto) {
		Users user = usersRepository.findById(id).orElseThrow(
				() -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
		);
		user.update(requestDto);
		return user.getId();
	}
	
	@Transactional
	public Long deleteUser(Long id) {
		Users user = usersRepository.findById(id).orElseThrow(
				() -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
		);
		usersRepository.deleteById(id);
		return user.getId();
	}
	
	@Transactional
	public List<Users> matching(Long id) {
		Users user = usersRepository.findById(id).orElseThrow(
				() -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
		);
		List<Users> list = usersRepository.findByAgeAndGenderNotLike(user.getAge(), user.getGender());
		return list;
	}
	
}

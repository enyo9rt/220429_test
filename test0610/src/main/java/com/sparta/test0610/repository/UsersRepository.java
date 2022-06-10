package com.sparta.test0610.repository;

import com.sparta.test0610.models.Users;
import com.sparta.test0610.models.UsersGender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
	List<Users> findByAgeAndGenderNotLike(int age, UsersGender gender);
}

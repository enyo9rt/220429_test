package com.sparta.test0610.dto;

import com.sparta.test0610.models.UsersGender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PutRequestDto {
		private String username;
		private UsersGender gender;
		private int age;
	}

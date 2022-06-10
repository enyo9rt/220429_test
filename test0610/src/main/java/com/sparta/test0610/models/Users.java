package com.sparta.test0610.models;

import com.sparta.test0610.dto.PutRequestDto;
import com.sparta.test0610.dto.UsersRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Users extends Timestamped {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private UsersGender gender;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private int age;

	public Users(UsersRequestDto requestDto) {
		this.username = requestDto.getUsername();
		this.gender = requestDto.getGender();
		this.email = requestDto.getEmail();
		this.age = requestDto.getAge();
	}
	
	public void update(PutRequestDto requestDto) {
		this.username = requestDto.getUsername();
		this.gender = requestDto.getGender();
		this.age = requestDto.getAge();
	}
}

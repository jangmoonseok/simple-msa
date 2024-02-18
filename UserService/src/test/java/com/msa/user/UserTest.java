package com.msa.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class UserTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	@Transactional
	void userTest() {
		UserEntity user = new UserEntity();
		user.setUserName("memberA");
		Long id = repository.save(user);
		
		UserEntity find = repository.find(id);
		
		Assertions.assertThat(find.getId()).isEqualTo(id);
	}
}

package com.msa.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.msa.common.domain.UserEntity;
import com.msa.common.domain.UserRepository;



@SpringBootTest
public class UserTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	@Transactional
	@Rollback(false)
	void userTest() {
		UserEntity user = new UserEntity();
		user.setUserName("memberB");
		Long id = repository.save(user);
		
		UserEntity find = repository.find(id);
		
		Assertions.assertThat(find.getId()).isEqualTo(id);
		Assertions.assertThat(find).isEqualTo(user);
	}
}

package com.msa.common.domain;

import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Long save(UserEntity user) {
		em.persist(user);
		return user.getId();
	}
	
	public UserEntity find(Long id) {
		return em.find(UserEntity.class, id);
	}
}

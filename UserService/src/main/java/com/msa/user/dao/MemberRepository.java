package com.msa.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msa.user.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>{

	Optional<MemberEntity> findByMemberName(String memberName);
}

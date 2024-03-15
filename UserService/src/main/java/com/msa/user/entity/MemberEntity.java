package com.msa.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "T_MEMBER")
@Getter
@Builder
public class MemberEntity {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;
	
	@Column(name = "memner_name")
	private String memberName;
	
	@Column(name = "password")
	private String password;
}

package com.msa.user.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_MEMBER")
@Getter
@NoArgsConstructor
public class MemberEntity {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;
	
	@Column(name = "memner_name")
	private String memberName;
	
	@Column(name = "password")
	private String password;
	
	public void passwordEncoder(BCryptPasswordEncoder encoder) {
		this.password = encoder.encode(password);
	}
}

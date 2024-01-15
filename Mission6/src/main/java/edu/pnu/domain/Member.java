package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder

public class Member {
	@Id
//	@Column(name="MEMBER_ID")
	private int id;
	private String name;
	private String pass;
	private Date regidate;
}

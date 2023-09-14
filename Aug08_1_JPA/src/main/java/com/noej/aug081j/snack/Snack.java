package com.noej.aug081j.snack;

import com.noej.aug081j.company.Company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ??.save(...)
//		PK값이 DB에 없으면 : insert
//		PK값이 DB에 있으면 : update

// 과자 번호(pk)를 seq로 올릴거라서 값이 없을 것

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "aug08_snack")
public class Snack {

	@Id
	//								OracleDB의 seq이름,	.java에서 쓸 이름, 한번에 얼마씩 올릴지
	@SequenceGenerator(sequenceName = "aug08_snack_seq", name = "ass", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "ass")
	@Column(name = "s_no")
	private Integer no;
	
	@Column(name = "s_name")
	private String name;
	
	@Column(name = "s_price")
	private Integer price;
	
	// 회사가 하나면 과자가 여러개 has관계
	@ManyToOne
	@JoinColumn(name = "s_maker")
	private Company company;
}

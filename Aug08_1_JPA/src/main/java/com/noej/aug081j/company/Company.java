package com.noej.aug081j.company;

import java.util.List;

import com.noej.aug081j.snack.Snack;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Persistence
// 영속성
// 프로그램 종료되어도 안지워지는 -> DB

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "aug08_company")
public class Company {

	@Id
	@Column(name = "c_name")
	private String name;
	
	@Column(name = "c_addr")
	private String addr;
	
	// 반대쪽 JoinColumn에 준거 변수명
	@OneToMany(mappedBy = "company")
	private List<Snack> snacks;
}

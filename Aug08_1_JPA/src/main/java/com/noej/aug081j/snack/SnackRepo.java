package com.noej.aug081j.snack;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// N + 1 :
//		우리가 쓰던 그 join이 아닌, 값 같은걸 여러번 찾는
//			-> 여러번select를 하니까 효율성, 속도에 문제가
//		우리가 쓰던 그 join으로
//			-> select는 한번 -> 데이터가 늘어나는데...?

@Repository
public interface SnackRepo extends CrudRepository<Snack, Integer> {
	// SQL - x
	// JPQL : select distinct 닉 from 테이블명 닉 join fetch 닉.변수명
	@Query("select distinct asnack from aug08_snack asnack join fetch asnack.company")
	public abstract List<Snack> findAll();
}

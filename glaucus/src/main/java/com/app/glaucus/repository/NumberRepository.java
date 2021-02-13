package com.app.glaucus.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.glaucus.entity.Number;


@Repository

public interface NumberRepository extends JpaRepository<Number, Long>  {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public Optional<Number> findFirstByOrderByNumber();
	
	
	@Modifying
	@Query("update Number set number=:number where id=:id")
	public void updateData(@Param("number") Integer number,@Param("id") Long id );
	
	//@Lock(LockModeType.PESSIMISTIC_WRITE)
//	@Query(value="intsert into Number (number) values (:num)",nativeQuery = true)
//	public void insetData(@Param("num") Integer number);
	
	
	
	
}

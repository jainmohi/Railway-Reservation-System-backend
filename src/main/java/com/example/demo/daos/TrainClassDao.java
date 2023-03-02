package com.example.demo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.pojos.TrainClass;

public interface TrainClassDao extends JpaRepository<TrainClass, Long>
{
//	@Query("delete from TrainClass u where u.trainCode = ?1")
//	void deletetrainclassbytrainid(Long trainCode );
	void deleteByTrainCode(long id);
	
	@Query("select p from TrainClass p where p.trainCode=:id")
	List<TrainClass> getBookingStatus(@Param ("id") Long id);

}

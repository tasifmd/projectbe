package com.tasif.projectbe.vechicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasif.projectbe.vechicle.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	
	public List<Vehicle> findByUserId(long userId);

}

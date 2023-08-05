package com.bharat.location.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bharat.location.entities.Location;
public interface LocationRepository extends JpaRepository<Location, Integer> {
	@Query(value="SELECT type, COUNT(type) FROM loc GROUP BY type",nativeQuery = true)
	public List<Object[]> findTypeAndTypeCount();
}

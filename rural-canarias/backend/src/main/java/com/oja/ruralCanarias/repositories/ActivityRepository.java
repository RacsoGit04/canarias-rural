package com.oja.ruralCanarias.repositories;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
import com.oja.ruralCanarias.models.Activity

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{
}
package com.oja.ruralCanarias.repositories;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
import com.oja.ruralCanarias.models.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long>{
}
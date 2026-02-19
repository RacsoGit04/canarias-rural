package com.oja.ruralCanarias.repositories;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
import com.oja.ruralCanarias.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
}
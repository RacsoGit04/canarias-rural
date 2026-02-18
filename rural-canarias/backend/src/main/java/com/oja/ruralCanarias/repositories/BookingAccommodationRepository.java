package com.oja.ruralCanarias.repositories;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
import com.oja.ruralCanarias.models.BookingAccommodation

@Repository
public interface BookingAccommodationRepository extends JpaRepository<BookingAccommodation, Long>{
}
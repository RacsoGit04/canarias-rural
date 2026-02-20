package com.oja.ruralCanarias.repositories;
import com.oja.ruralCanarias.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Para el registro solo quiero saber si hay un email en uso, findByEmail gastaría memoria innecasariamente
    boolean existsByEmail(String email); 
    //Para el login 
    Optional<User> findByEmail(String email);
}


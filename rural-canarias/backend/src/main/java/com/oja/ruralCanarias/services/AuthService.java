package com.oja.ruralCanarias.services;
import com.oja.ruralCanarias.dtos.auth.RegisterRequest;
import com.oja.ruralCanarias.models.User;
import com.oja.ruralCanarias.models.Role; 
import com.oja.ruralCanarias.repositories.RoleRepository; 
import com.oja.ruralCanarias.repositories.UserRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import java.util.HashSet; 
import java.util.Set; 


public class AuthService {
    @Autowired 
    private UserRepository userRepository; 

    @Autowired
    private RoleRepository roleRepository; 

    public String registerUser(RegisterRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Error: El email ya está registrado"); 
        }

        User newUser = new User(); 

        newUser.setFirstName(request.getFirstName()); 
        newUser.setLastName(request.getLastName()); 
        newUser.setEmail(request.getEmail()); 
        newUser.setPhone(request.getPhone()); 
        //POR AHORA SIN ENCRIPTAR CUIDADO 

        newUser.setPassword(request.getPassword()); 

        Role userRole = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("Error: El rol ROLE_USER no existe en la BD.")); 

        Set<Role> roles = new HashSet<>(); 
        //siempre se asigna por defecto el rol con menos privilegios de todo el sistema 
        //¿y el proveedor? Opción A - Primero usuario base y se configura desde perfil / Opcción B - Endpoint separado
        roles.add(userRole); 
        newUser.setRoles(roles); 

        userRepository.save(newUser); 

        return "!Usuario registrado con éxito"; 

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1Ciclo4.reto1Ciclo4.inferfaces;

import java.util.List;
import java.util.Optional;
import reto1Ciclo4.reto1Ciclo4.modelo.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */
public interface UserInterface extends CrudRepository<User,Integer>{
    
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
    
}

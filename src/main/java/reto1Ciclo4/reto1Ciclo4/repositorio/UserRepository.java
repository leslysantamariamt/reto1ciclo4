/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1Ciclo4.reto1Ciclo4.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto1Ciclo4.reto1Ciclo4.inferfaces.UserInterface;
import reto1Ciclo4.reto1Ciclo4.modelo.User;

/**
 *
 * @author USUARIO
 */
@Repository
public class UserRepository {

    @Autowired
    private UserInterface crud2;

    public List<User> getAll() {
        return (List<User>) crud2.findAll();
    }

    public Optional<User> getUser(int id) {
        return crud2.findById(id);
    }
    
    public User save(User user) {
        return crud2.save(user);
    }

    public void delete(User user) {
        crud2.delete(user);
    }
    public boolean getUserEmail(String email) {
        Optional<User> user = crud2.findByEmail(email);
        return !user.isEmpty();
    }



    public Optional<User> getUserEmailPassword(String email, String password) {
        return crud2.findByEmailAndPassword(email, password);
    }

}

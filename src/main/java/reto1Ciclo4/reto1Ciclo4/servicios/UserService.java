/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1Ciclo4.reto1Ciclo4.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto1Ciclo4.reto1Ciclo4.modelo.User;
import reto1Ciclo4.reto1Ciclo4.repositorio.UserRepository;

/**
 *
 * @author USUARIO
 */
@Service
public class UserService {

    @Autowired
    private UserRepository metodosCrud;
    
    public List<User> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<User> getUser(int id) {
        return metodosCrud.getUser(id);
    }
    
    public boolean getUserEmail(String email) {
        return metodosCrud.getUserEmail(email);
    }

    public User save(User user) {
        if (user.getId() == null) {
            return metodosCrud.save(user);
        } else {
            Optional<User> e = metodosCrud.getUser(user.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(user);
            } else {
                return user;
            }
        }
    }

    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> e = metodosCrud.getUser(user.getId());
            if (!e.isEmpty()) {

                if (user.getEmail()!= null) {
                    e.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    e.get().setPassword(user.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean deleteUser(int id) {
        Boolean aBoolean = getUser(id).map(user -> {
            metodosCrud.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public User getUserEmailPassword(String email, String password) {
        Optional<User> user = metodosCrud.getUserEmailPassword(email, password);
        
        if (user.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return user.get();
        }
    }

}

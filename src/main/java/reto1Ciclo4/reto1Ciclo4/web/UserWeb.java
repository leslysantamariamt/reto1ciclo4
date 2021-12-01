/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1Ciclo4.reto1Ciclo4.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reto1Ciclo4.reto1Ciclo4.modelo.User;
import reto1Ciclo4.reto1Ciclo4.servicios.UserService;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserWeb {
    
    @Autowired
    private UserService servicio;
    @GetMapping("/all")
    public List<User> getUsers(){
        return servicio.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return servicio.save(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User id) {
        return servicio.update(id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return servicio.deleteUser(id);
    }
    
    @GetMapping("/{email}")
    public boolean getUsersEmail(@PathVariable("email") String email){
    return servicio.getUserEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User getUsersEmailPassword(@PathVariable("email") String email, @PathVariable("password") String password){
    return servicio.getUserEmailPassword(email,password);
    }
}

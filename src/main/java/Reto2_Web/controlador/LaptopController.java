/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_Web.controlador;

import Reto2_Web.modelo.Laptop;
import Reto2_Web.sevicio.LaptopService;

import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/api/laptop")
@CrossOrigin("*")
public class LaptopController {
     @Autowired
    private LaptopService laptopService;
       
     @GetMapping("/all")
    public List<Laptop> getAll() {
        return laptopService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Laptop> getLaptop(@PathVariable("id") int id) {
        return laptopService.getLaptop(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopService.create(laptop);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop laptop) {
        return laptopService.update(laptop);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return laptopService.delete(id);
    } 
    
}

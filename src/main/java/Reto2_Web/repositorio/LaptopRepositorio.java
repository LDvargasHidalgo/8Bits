/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_Web.repositorio;

import Reto2_Web.interfaces.InterfaceLaptop;
import Reto2_Web.modelo.Laptop;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class LaptopRepositorio {
     @Autowired
    private InterfaceLaptop repository;

    public List<Laptop> getAll() {
        return repository.findAll();
    }

    public Optional<Laptop> getLaptop(int id) {
        return repository.findById(id);
    }
    public Laptop create(Laptop laptop) {
        return repository.save(laptop);
    }

    public void update(Laptop laptop) {
        repository.save(laptop);
    }
    
    public void delete(Laptop laptop) {
        repository.delete(laptop);
    }
}

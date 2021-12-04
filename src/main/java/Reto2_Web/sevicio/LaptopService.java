/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_Web.sevicio;

import Reto2_Web.modelo.Laptop;
import Reto2_Web.repositorio.LaptopRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class LaptopService {
    @Autowired
    private LaptopRepositorio laptopRepository;

    public List<Laptop> getAll() {
        return laptopRepository.getAll();
    }

   public Optional<Laptop> getLaptop(int id) {
        return laptopRepository.getLaptop(id);
    }

    public Laptop create(Laptop laptop) {
        if (laptop.getId() == null) {
            return laptop;
        } else {
            return laptopRepository.create(laptop);
        }
    }

    public Laptop update(Laptop laptop) {

        
        if (laptop.getId() != null) {
            Optional<Laptop> laptopDb = laptopRepository.getLaptop(laptop.getId());
            if (laptopDb.isPresent()) { 
                if (laptop.getBrand()!= null) {
                    laptopDb.get().setBrand(laptop.getBrand());
                }
                if (laptop.getModel()!= null) {
                    laptopDb.get().setModel(laptop.getModel());
                }
                if (laptop.getProcesor()!= null) {
                    laptopDb.get().setProcesor(laptop.getProcesor());
                }
                if (laptop.getOs()!= null) {
                    laptopDb.get().setOs(laptop.getOs());
                }
                if (laptop.getDescription()!= null) {
                    laptopDb.get().setDescription(laptop.getDescription());
                }
                if (laptop.getMemory()!= null) {
                    laptopDb.get().setMemory(laptop.getMemory());
                }
                if (laptop.getHardDrive()!= null) {
                    laptopDb.get().setHardDrive(laptop.getHardDrive());
                }             
                if (laptop.getPrice() != 0.0) {
                    laptopDb.get().setPrice(laptop.getPrice());
                }
                if (laptop.getQuantity() != 0) {
                    laptopDb.get().setQuantity(laptop.getQuantity());
                }
                if (laptop.getPhotography() != null) {
                    laptopDb.get().setPhotography(laptop.getPhotography());
                }
                
                laptopDb.get().setAvailability(laptop.isAvailability());
                laptopRepository.update(laptopDb.get());
                return laptopDb.get();
            } else {
                return laptop;
            }
        } else {
            return laptop;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getLaptop(id).map(laptop -> {
            laptopRepository.delete(laptop);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

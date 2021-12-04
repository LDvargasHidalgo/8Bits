/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_Web.interfaces;

import Reto2_Web.modelo.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Usuario
 */
public interface InterfaceLaptop extends MongoRepository<Laptop, Integer>{
    
}

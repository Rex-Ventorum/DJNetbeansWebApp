/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Pojos;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author L117student
 */
public interface IProductDAO extends JpaRepository<Product,String>{
    
}

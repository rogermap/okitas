/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo.db;

import hu.combit.demo.model.DemoGyerek;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoGyerekRepository extends CrudRepository<DemoGyerek, Long>  {
     
    
}

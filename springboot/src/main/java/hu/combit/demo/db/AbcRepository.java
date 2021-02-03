/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo.db;

import hu.combit.demo.model.Abc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbcRepository extends CrudRepository<Abc, Long>  {
    
    Iterable<Abc> findAllByA(Integer a); 
    Iterable<Abc> findAllByAAndBOrderByADesc(Integer a, String B); 
    
}

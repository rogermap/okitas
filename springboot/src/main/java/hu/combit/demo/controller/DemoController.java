/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo.controller;


import hu.combit.demo.Osszeg;
import hu.combit.demo.db.AbcRepository;
import hu.combit.demo.model.Abc;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @Autowired
    AbcRepository abcRepository;
    
    
    @GetMapping(value = "/osszeadas/{a}/{b}", produces = "application/json")
    public ResponseEntity add(@PathVariable("a") Integer  a,@PathVariable("b")Integer b ){
        return new ResponseEntity(new Osszeg(a,b),  HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/abc/{id}")
    protected String doDelete(@PathVariable("id") Long  id) {
        if (id != null) {
            abcRepository.deleteById(id);
        }
        return "OK";
    }

    @PutMapping("/abc")
    protected String doPut(
            @RequestBody Abc abc) 
    {
            abcRepository.save(abc);
        
        return "OK";
    }

    @PostMapping("/abc")
    protected String doPost(
            @RequestBody Abc abc)  {
            abcRepository.save(abc);
        
        return "OK";
    }

    @GetMapping("/abc")
    protected ResponseEntity doGet() {
        List<Abc> adatok = new ArrayList<>();
        Iterable<Abc> i =  abcRepository.findAll();
        i.forEach(new Consumer<Abc>() {
            @Override
            public void accept(Abc t) {
                adatok.add(t);
            }
        });
        return new ResponseEntity(adatok,  HttpStatus.OK);
        
    }
    
    @GetMapping("/abc/{a}")
    protected ResponseEntity filter(@PathVariable("a") Integer a ) {
        List<Abc> adatok = new ArrayList<>();
        Iterable<Abc> i =  abcRepository.findAllByA(a);
        i.forEach(new Consumer<Abc>() {
            @Override
            public void accept(Abc t) {
                adatok.add(t);
            }
        });
        return new ResponseEntity(adatok,  HttpStatus.OK);
        
    }
}

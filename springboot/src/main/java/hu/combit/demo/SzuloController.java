/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SzuloController {
      @Autowired
    DemoSzuloRepository demoSzuloRepository;
    
 
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/szulo/{id}")
    protected String doDelete(@PathVariable("id") Long  id) {
        if (id != null) {
            demoSzuloRepository.deleteById(id);
        }
        return "OK";
    }

    @PutMapping("/szulo")
    protected String doPut(
            @RequestBody DemoSzulo szulo) 
    {
            demoSzuloRepository.save(szulo);
        
        return "OK";
    }

    @PostMapping("/szulo")
    protected String doPost(
            @RequestBody DemoSzulo szulo)  {
            demoSzuloRepository.save(szulo);
        
        return "OK";
    }

    @GetMapping("/szulo")
    protected ResponseEntity doGet() {
        List<DemoSzulo> adatok = new ArrayList<>();
        Iterable<DemoSzulo> i =  demoSzuloRepository.findAll();
        i.forEach(new Consumer<DemoSzulo>() {
            @Override
            public void accept(DemoSzulo t) {
                adatok.add(t);
            }
        });
        return new ResponseEntity(adatok,  HttpStatus.OK);
        
    }
}

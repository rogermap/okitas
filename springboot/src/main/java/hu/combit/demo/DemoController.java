/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    // http://localhost:8080/osszeadas/12/8 
    
    static class Osszeg {
        private int osszeg;
        public Osszeg(int a, int b){
            osszeg = a+b;
        }
    }
    
    @GetMapping("/osszeadas/{a}/{b}")
    public ResponseEntity add(@PathVariable("a") Integer  a,@PathVariable("b")Integer b ){
        return new ResponseEntity(a+b,  HttpStatus.OK);
    }
    
    
    @DeleteMapping("/abc/{id}")
    protected String doDelete(@PathVariable("id") String  id) {
        if (id != null) {
            Utility.delete(id);
        }
        return "OK";
    }

    @PutMapping("/abc/{a}/{b}/{c}/{d}")
    protected String doPut(
            @PathVariable("a") String  a,
            @PathVariable("b") String  b,
            @PathVariable("c") String  c,
            @PathVariable("d") String  d) 
    {
        if (a != null && b != null && c != null && d != null) {
            Utility.create(a, b, c, d);
        }
        return "OK";
    }

    @PostMapping("/abc/{a}/{b}/{c}/{d}/{id}")
    protected String doPost(
            @PathVariable("a") String  a,
            @PathVariable("b") String  b,
            @PathVariable("c") String  c,
            @PathVariable("d") String  d,
            @PathVariable("id") String  id)  {
        
        if (a != null && b != null && c != null && d != null && id != null) {
            Utility.update(id, a, b, c, d);
        }
        return "OK";
    }

    @GetMapping("/abc")
    protected String doGet() {
        List<String[]> adatok = Utility.list();
        JSONArray elemek = new JSONArray();
        for (String[] adatSor : adatok) {
            JSONArray sor = new JSONArray();
            elemek.add(sor);
            for (String adat : adatSor) {
                sor.add(adat);
            }
        }

        return elemek.toJSONString();
        
    }
    
}

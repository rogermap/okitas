/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo;

import lombok.Setter;
import lombok.Getter;

/**
 *
 * @author krisztianfarkas
 */
@Getter
@Setter
public class Osszeg {
    
        private int osszeg;
        public Osszeg(int a, int b){
            osszeg = a+b;
        }
}

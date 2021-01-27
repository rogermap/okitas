/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="DemoGyerek")
@Table(name="DEMO_GYEREK")
public class DemoGyerek {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo")
    @SequenceGenerator(name = "demo", sequenceName = "demo", allocationSize = 1)
    private Long id;
    private String nev; 
    private Long szuloId;
    private Integer kor;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
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
    
    @NotNull
    @Size(min = 2, max = 8, message = "A név hossza 2 és 8 karakter közötti kell legyen")
    private String nev; 
    
    @NotNull
    private Long szuloId;
    
    @Min(value = 0)
    @Max(value = 120)
    private Integer kor;
}

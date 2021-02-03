/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Entity(name="DemoSzulo")
@Table(name="DEMO_SZULO")
public class DemoSzulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "demo_generator")
    @SequenceGenerator(name = "demo_generator", sequenceName = "demo", allocationSize = 1)
    private Long id;
    private String nev;
    private String cim;
    @OneToMany(mappedBy = "szuloId", cascade = {CascadeType.ALL})
    private List<DemoGyerek> gyerekek;
    
}

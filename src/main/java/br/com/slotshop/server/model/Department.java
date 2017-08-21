package br.com.slotshop.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by vinic on 24/05/2017.
 */
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 100, nullable = false)
    private String name;
    
    @NotEmpty
    @Column(length = 100, nullable = false)
    private String description;

}

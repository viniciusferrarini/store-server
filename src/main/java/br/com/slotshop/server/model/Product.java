package br.com.slotshop.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by vinic on 16/05/2017.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @Column(length = 1000, nullable = false)
    private String description;

    @NotEmpty
    @Column(nullable = false)
    private Integer amount;

    @NotEmpty
    @Column(nullable = false)
    private Double value;

    @JoinColumn(name = "brandId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Brand brand;

    @JoinColumn(name = "subCategoryId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private SubCategory subCategory;


    
}

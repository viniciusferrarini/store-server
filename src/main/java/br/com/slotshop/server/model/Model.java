package br.com.slotshop.server.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @JoinColumn(name = "subCategoryId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private SubCategory subCategory;

    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<ProductModel> models;

}

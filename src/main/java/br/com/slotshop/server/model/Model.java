package br.com.slotshop.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome deve ser preenchido!")
    @Column(name = "name")
    private String name;

    @JoinColumn(name = "subCategoryId")
    @ManyToOne(fetch = FetchType.EAGER)
    private SubCategory subCategory;

}

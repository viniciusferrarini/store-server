package br.com.slotshop.server.model;

import br.com.slotshop.server.util.DoubleUtil;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vinic on 16/05/2017.
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Double value;

    @JoinColumn(name = "brandId", referencedColumnName = "id")
    @ManyToOne
    private Brand brand;

    @JoinColumn(name = "subCategoryId", referencedColumnName = "id")
    @ManyToOne
    private SubCategory subCategory;

    @JsonManagedReference
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<ProductModel> models;

    @JsonManagedReference
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<ProductGallery> gallery;

    public Double getValueWithDiscount(){
        return this.value - ((this.value * 10) / 100);
    }

    public String getValueWithDiscountFormatted(){
        return DoubleUtil.formatRealWithSimbol(getValueWithDiscount());
    }

    public Double getValueParcel(){
        return this.value / 12;
    }

    public String getValueParcelFormatted(){
        return DoubleUtil.formatRealWithSimbol(getValueParcel());
    }

    public String getValueFormatted(){
        return DoubleUtil.formatRealWithSimbol(this.value);
    }

    public String getFirstPictureFromGallery(){
        if(this.gallery!= null && !this.gallery.isEmpty()) {
            return this.gallery.get(0).getPicture();
        }
        return "0";
    }

}

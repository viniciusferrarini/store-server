package br.com.slotshop.server.model;

import br.com.slotshop.server.util.DoubleUtil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @Column
    private Integer amount;

    @Column
    private Double total;

    @ManyToOne
    @JoinColumn(name = "buy")
    @JsonBackReference
    private Buy buy;

    public String getTotalFormatted(){
        return DoubleUtil.formatRealWithSimbol(this.total);
    }

}

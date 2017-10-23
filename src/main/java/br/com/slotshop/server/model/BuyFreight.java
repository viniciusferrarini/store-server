package br.com.slotshop.server.model;

import br.com.slotshop.server.enumeration.FreightType;
import br.com.slotshop.server.util.DoubleUtil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BuyFreight {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private FreightType freightType;

    @Column
    private Integer deliveryTime;

    @Column
    private Double value;

    @Column(nullable = true)
    private String trackingCode;

    public String getValueFormatted(){
        if (this.value != null){
            return DoubleUtil.formatRealWithSimbol(this.value);
        }
        return "0,00";
    }

    public String getFreightTypeLabel(){
        return this.freightType.getLabel();
    }

}

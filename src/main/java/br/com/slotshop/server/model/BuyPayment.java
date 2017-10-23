package br.com.slotshop.server.model;

import br.com.slotshop.server.enumeration.PaymentType;
import br.com.slotshop.server.util.DoubleUtil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BuyPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(nullable = true)
    private Double discounts;

    @Column(nullable = true)
    private Integer amountParcel;

    @Column(nullable = true)
    private Double totalParcel;

    public Double getDiscounts() {
        if (this.discounts != null){
            return this.discounts;
        }
        return 0.0;
    }

    public String getDiscountsFormatted(){
        return DoubleUtil.formatRealWithSimbol(this.getDiscounts());
    }

    public String getTotalParcelFormatted(){
        if (this.totalParcel != null){
            return DoubleUtil.formatRealWithSimbol(this.totalParcel);
        }
        return "0,00";
    }

    public String getPaymentTypeLabel(){
        return this.paymentType.getLabel();
    }

}

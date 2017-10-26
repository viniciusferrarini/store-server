package br.com.slotshop.server.model;

import br.com.slotshop.server.enumeration.OrderStatus;
import br.com.slotshop.server.util.DateUtil;
import br.com.slotshop.server.util.DoubleUtil;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Buy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private BuyFreight freight;

    @OneToOne(cascade = CascadeType.ALL)
    private BuyPayment payment;

    @OneToOne(cascade = CascadeType.MERGE)
    private UserAdress adress;

    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    @JsonManagedReference
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "buy", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BuyProduct> products;

    @Column
    private Date date;

    @Column
    private Date statusDate;

    @Column
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column
    private OrderStatus status;

    public String getTotalFormatted(){
        return DoubleUtil.formatRealWithSimbol(this.total);
    }

    public String getDateFormatted(){
        return DateUtil.formatDateWithMonthText(this.date);
    }

    public String getStatusDateFormatted(){
        if(this.statusDate != null) {
            return DateUtil.formatDateWithMonthText(this.statusDate);
        }
        return null;
    }

    public String getStatusLabel(){
        return this.status.getLabel();
    }

    public Double getSubTotal(){
        return products.stream().mapToDouble(BuyProduct::getTotal).sum();
    }

    public String getSubTotalFormatted(){
        return DoubleUtil.formatRealWithSimbol(this.getSubTotal());
    }

    public Double getTotalBuy(){
        Double subTotal = getSubTotal();
        Double freightValue = this.freight.getValue();
        Double discount = this.payment.getDiscounts() != null ? this.payment.getDiscounts() : 0.0;
        return (subTotal - discount) + freightValue;
    }

    public String getTotalBuyFormatted(){
        return DoubleUtil.formatRealWithSimbol(this.getTotalBuy());
    }

}

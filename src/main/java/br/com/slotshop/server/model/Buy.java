package br.com.slotshop.server.model;

import br.com.slotshop.server.enumeration.OrderStatus;
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "buy", cascade = CascadeType.ALL)
    private BuyFreight freight;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "buy", cascade = CascadeType.ALL)
    private BuyPayment payment;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "buy", cascade = CascadeType.ALL)
    private BuyAdress adress;

    @JsonManagedReference
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "buy", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BuyProduct> products;

    @Column
    private Date date;

    @Column
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column
    private OrderStatus status;

}

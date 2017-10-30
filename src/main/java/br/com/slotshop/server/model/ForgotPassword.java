package br.com.slotshop.server.model;

import br.com.slotshop.server.enumeration.YesNo;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ForgotPassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String token;

    private Date expirationDate;

    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    @Column
    @Enumerated(EnumType.STRING)
    private YesNo isValid;

}

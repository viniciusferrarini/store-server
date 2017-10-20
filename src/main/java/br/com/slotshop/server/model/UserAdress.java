package br.com.slotshop.server.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAdress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo descrição deve ser preenchido!")
    private String description;

    @NotEmpty(message = "Campo CEP deve ser preenchido!")
    private String zipCode;

    @NotEmpty(message = "Campo Rua deve ser preenchido!")
    private String street;

    @Min(value = 1, message = "Campo número deve ser preenchido!")
    private Integer number;

    @NotEmpty(message = "Campo bairro deve ser preenchido!")
    private String district;

    @NotEmpty(message = "Campo cidade deve ser preenchido!")
    private String city;

    @NotEmpty(message = "Campo estado deve ser preenchido!")
    private String state;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

}

package br.com.slotshop.server.model;

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
public class UserAdress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String zip;

    @NotEmpty
    private String street;

    @NotEmpty
    private Integer number;

    @NotEmpty
    private String district;

    @NotEmpty
    private String city;

    @NotEmpty
    private String country;

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonBackReference
    private User user;

}

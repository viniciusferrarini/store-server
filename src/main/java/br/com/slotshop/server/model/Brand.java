package br.com.slotshop.server.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vinic on 18/05/2017.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 100, nullable = false)
    private String name;

}

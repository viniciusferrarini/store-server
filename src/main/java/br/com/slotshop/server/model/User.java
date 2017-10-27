package br.com.slotshop.server.model;

import br.com.slotshop.server.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by vinic on 19/06/2017.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    //INSERT INTO `slotshop`.`user` (`email`, `name`, `password`) VALUES ('viniciusferrarini@outlook.com', 'Vinicius', '$2a$06$x7BDDZrwBUbiVeUPDpzawe8jBSbtyexcUZfz7IbUzBcWapCLRTS6S');

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String cpfCnpj;

    @Column(nullable = true)
    private Date birthday;

    @Column(nullable = true)
    private String telephone;

    @Column
    private String role;

    /*@JsonManagedReference
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<UserAdress> adress;*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_" + this.role);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getBirthdayFormatted(){
        if(this.birthday != null) {
            return DateUtil.format(this.birthday);
        }
        return "";
    }

}

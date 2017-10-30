package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.enumeration.YesNo;
import br.com.slotshop.server.model.ForgotPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ForgotPasswordData extends JpaRepository<ForgotPassword, Long> {

    ForgotPassword findByTokenAndExpirationDateGreaterThanAndIsValid(String token, Date data, YesNo y);

}

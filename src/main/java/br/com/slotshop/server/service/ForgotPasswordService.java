package br.com.slotshop.server.service;

import br.com.slotshop.server.model.ForgotPassword;
import br.com.slotshop.server.model.User;

public interface ForgotPasswordService extends CrudService<ForgotPassword, Long> {

    Boolean createTokenForUser(User user);

    ForgotPassword findByTokenIsValid(String token);

}

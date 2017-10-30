package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.enumeration.YesNo;
import br.com.slotshop.server.model.ForgotPassword;
import br.com.slotshop.server.model.User;
import br.com.slotshop.server.repository.data.ForgotPasswordData;
import br.com.slotshop.server.service.ForgotPasswordService;
import br.com.slotshop.server.util.DateUtil;
import br.com.slotshop.server.util.EmailUtil;
import br.com.slotshop.server.util.RandomKeyUtil;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class ForgotPasswodServiceImpl extends CrudServiceImpl<ForgotPassword, Long> implements ForgotPasswordService {

    @Autowired private ForgotPasswordData forgotPasswordData;

    @Override
    protected JpaRepository<ForgotPassword, Long> getRepository() {
        return forgotPasswordData;
    }

    @Override
    public Boolean createTokenForUser(User user) {
        ForgotPassword forgotPassword = forgotPasswordData.save(ForgotPassword.builder()
                .token(RandomKeyUtil.randomString(26))
                .expirationDate(DateUtil.getCurrentDataMoreHours(12))
                .user(user)
                .isValid(YesNo.Y)
                .build());
        try {
            return sendEmail(forgotPassword);
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ForgotPassword findByTokenIsValid(String token) {
        return forgotPasswordData.findByTokenAndExpirationDateGreaterThanAndIsValid(token, new Date(), YesNo.Y);
    }

    private Boolean sendEmail(ForgotPassword forgotPassword) throws EmailException {

        String link = "http://localhost:7979/forgotPassword?token=" + forgotPassword.getToken();

        StringBuilder template = new StringBuilder()
                .append("<div style=\"width: 500px; margin: 10px; padding: 0px; font-family: 'Roboto', sans-serif\">")
                .append("    <div style=\"padding: 20px; background: #F7F7F7; text-align: center;\">")
                .append("        <h3>SlotShop</h3>")
                .append("        <p>Recupere sua senha</p>")
                .append("    </div>")
                .append("    <div style=\"border: 1px solid #F7F7F7; padding: 10px; text-align: center;\">")
                .append("        <p>Olá ")
                .append(forgotPassword.getUser().getName())
                .append("</p>")
                .append("        <p>Você solicitou um e-mail de recuperação de senha. Para alterar sua senha clique <a href=\"")
                .append(link)
                .append("\">aqui</a>.</p>")
                .append("        <p>Caso não tenha solicitado, ignore este e-mail.</p>")
                .append("    </div>")
                .append("    <div style=\"padding: 20px; background: #F7F7F7; text-align: center;\">")
                .append("        <p style=\"font-size: 10px;\">Dúvidas ou demais informações acesse nossa central de atendimento ou ligue (999) 9999-9999</p>")
                .append("    </div>")
                .append("</div>");

        return EmailUtil.sendEmail(template.toString(), forgotPassword.getUser().getEmail());

    }
}

package br.com.slotshop.server.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {

    public static Boolean sendEmail(String template, String targetEmail){
        try {
            Email email = new HtmlEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("mail@gmail.com", "#####"));
            email.setSSLOnConnect(true);
            email.setFrom("contato@slotshop.com.br");
            email.setSubject("Recuperação de Senha - SlotShop");
            email.setMsg(template);
            email.addTo(targetEmail);
            email.send();
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }
}

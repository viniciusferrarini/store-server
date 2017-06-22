package br.com.slotshop.server.security;

import lombok.Data;

/**
 * Created by vinic on 19/06/2017.
 */
@Data
public class AccountCredentials {
    private String email;
    private String password;
}
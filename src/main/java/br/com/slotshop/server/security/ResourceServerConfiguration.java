package br.com.slotshop.server.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/subCategory/navbar").permitAll()
                .antMatchers(HttpMethod.GET, "/product/findFirst10").permitAll()
                .antMatchers(HttpMethod.GET, "/product/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/gallery/picture/{name}").permitAll();
    }
}
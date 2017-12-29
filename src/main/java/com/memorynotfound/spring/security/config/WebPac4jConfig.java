package com.memorynotfound.spring.security.config;

import com.memorynotfound.spring.security.service.UserService;
import org.pac4j.core.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.pac4j.springframework.web.SecurityInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "org.pac4j.springframework.web")
public class WebPac4jConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Config config;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityInterceptor(config, "FacebookClient")).addPathPatterns("/facebook/*").excludePathPatterns("/facebook/notprotected.html");
        registry.addInterceptor(new SecurityInterceptor(config, "FacebookClient", "admin")).addPathPatterns("/facebookadmin/*");
        registry.addInterceptor(new SecurityInterceptor(config, "FacebookClient", "custom")).addPathPatterns("/facebookcustom/*");
        registry.addInterceptor(new SecurityInterceptor(config, "TwitterClient,FacebookClient")).addPathPatterns("/twitter/*");
        registry.addInterceptor(new SecurityInterceptor(config, "FormClient")).addPathPatterns("/form/*");
        registry.addInterceptor(new SecurityInterceptor(config, "FormClient")).addPathPatterns("/api-rest/*");
        registry.addInterceptor(new SecurityInterceptor(config, "IndirectBasicAuthClient")).addPathPatterns("/basicauth/*");
        registry.addInterceptor(new SecurityInterceptor(config, "CasClient")).addPathPatterns("/cas/*");
        registry.addInterceptor(new SecurityInterceptor(config, "SAML2Client")).addPathPatterns("/saml/*");
        registry.addInterceptor(new SecurityInterceptor(config, "GoogleOidcClient")).addPathPatterns("/oidc/*");

        registry.addInterceptor(new SecurityInterceptor(config, "AnonymousClient")).addPathPatterns("/home");

        registry.addInterceptor(new SecurityInterceptor(config)).addPathPatterns("/app-rest/*");
        registry.addInterceptor(new SecurityInterceptor(config, "DirectBasicAuthClient,ParameterClient")).addPathPatterns("/dba/*");
        registry.addInterceptor(new SecurityInterceptor(config, "ParameterClient")).addPathPatterns("/rest-jwt/*");

//        registry.addInterceptor(new SecurityInterceptor(config, "FormClient")).addPathPatterns("/*");
    }
}
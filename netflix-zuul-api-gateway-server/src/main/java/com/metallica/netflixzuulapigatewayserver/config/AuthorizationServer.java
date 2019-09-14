package com.metallica.netflixzuulapigatewayserver.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	 /*@Autowired
	    private BCryptPasswordEncoder passwordEncoder;*/

	
	 @Override
	    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		 oauthServer.allowFormAuthenticationForClients();
	        oauthServer.tokenKeyAccess("permitAll()")
	                .checkTokenAccess("isAuthenticated()");
	        
	    }

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore())
			.authenticationManager(authenticationManager);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		String idForEncode = "bcrypt";
		Map encoders = new HashMap<>();
		encoders.put(idForEncode, new BCryptPasswordEncoder());
		encoders.put("noop", NoOpPasswordEncoder.getInstance());
		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
		encoders.put("scrypt", new SCryptPasswordEncoder());
		encoders.put("sha256", new StandardPasswordEncoder());

		PasswordEncoder passwordEncoder =
		    new DelegatingPasswordEncoder(idForEncode, encoders);
		
		
		clients.inMemory().withClient("javainuse-client").secret(passwordEncoder.encode("javainuse-secret"))
				.authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("read", "write");

	}
	
	 @Bean
	    public TokenStore tokenStore() {
	        return new InMemoryTokenStore();
	    }
	 
	 @Bean
	    public UserDetailsService userDetailsService() {

	        User.UserBuilder users = User.withDefaultPasswordEncoder();
	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	        manager.createUser(users.username("testuser").password("testpass").roles("USER").build());
	        return manager;

	    }
	 
	 /*@Bean
	 public BCryptPasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
	 }*/
	 
	 
}

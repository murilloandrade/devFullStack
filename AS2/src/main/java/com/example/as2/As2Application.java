package com.example.as2;

import com.example.as2.ui.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SpringBootApplication
public class As2Application extends VaadinWebSecurity {

	public static void main(String[] args) {
		SpringApplication.run(As2Application.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		setLoginView(http, LoginView.class);
	}

	@Bean
	public UserDetailsManager userDetailsService() {
		UserDetails user =
				User.withUsername("user")
						.password("{noop}1")
						.roles("USER")
						.build();
		UserDetails admin =
				User.withUsername("admin")
						.password("{noop}1")
						.roles("ADMIN")
						.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
}

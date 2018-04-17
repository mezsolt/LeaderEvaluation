package com.LeaderEvaluation;

import com.LeaderEvaluation.repository.WorkerRepository;
import com.LeaderEvaluation.security.MyUserDetails;
import com.LeaderEvaluation.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class LeaderEvaluationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaderEvaluationApplication.class, args);
	}

}

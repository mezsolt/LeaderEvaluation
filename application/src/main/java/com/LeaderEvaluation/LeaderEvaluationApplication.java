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



@SpringBootApplication
public class LeaderEvaluationApplication {

	/*@Autowired
	private BCryptPasswordEncoder passwordEncoder;
*/
	public static void main(String[] args) {
		SpringApplication.run(LeaderEvaluationApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, WorkerRepository repository, WorkerService service) throws Exception {
		//builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
		builder.userDetailsService(userDetailsService(repository));

	}

	private UserDetailsService userDetailsService(final WorkerRepository repository) {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return new MyUserDetails(repository.findOneByUsername(username));
			}
		};
	}
}

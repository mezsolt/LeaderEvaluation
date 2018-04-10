package com.LeaderEvaluation.security;

import java.util.ArrayList;
import java.util.List;

import com.LeaderEvaluation.entity.WorkerEntity;
import com.LeaderEvaluation.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * Created by mezsolt on 2018.04.06..
 */

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

        @Autowired
        private WorkerRepository workerRepository;

        public UserDetails loadUserByUsername(String username)
                throws UsernameNotFoundException {

            WorkerEntity user = workerRepository.findOneByUsername(username);

            if(user == null) {
                throw new UsernameNotFoundException(
                        "No user found with username: "+ username);
            }

            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            return  new org.springframework.security.core.userdetails.User
                    (user.getUsername(),
                            user.getPassword().toLowerCase(), enabled, accountNonExpired,
                            credentialsNonExpired, accountNonLocked,
                            getAuthorities(user.getRoles()));
        }

        private static List<GrantedAuthority> getAuthorities (ArrayList<String> roles) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
            return authorities;
        }

}

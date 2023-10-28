package com.tutoring.springdatajpa;

import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogRecord;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info(username);

        Optional<User> user = this.userRepository.findByUsername(username);

        if (user.isEmpty()) {
            logger.warn("could not find user");
            throw new UsernameNotFoundException("username not found");
        }

        return user.get();
    }
}

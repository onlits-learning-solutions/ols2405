package ols2405.mlm.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ols2405.mlm.form.LoginForm;
import ols2405.mlm.model.User;
import ols2405.mlm.repository.UserRepository;
import ols2405.mlm.security.CustomUserPrincipal;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CustomUserPrincipal(user);
    }

    public boolean authenticate(LoginForm loginForm) {
        
        if (userRepository.findByUserId(loginForm.getUserId()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void seedAdmin() {
        String userId = "dictator";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");

        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);

        userRepository.save(user);
    }
}

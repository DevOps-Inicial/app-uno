package tech.icei.web.api.appuno.security.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tech.icei.web.api.appuno.repository.GUserRepository;
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final GUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var gUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User name: " + username + " does not exists. Please review!"));
        return UserDetailsImpl.build(gUser);
    }
}

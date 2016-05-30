package ru.sberbank.services;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.model.User;
import ru.sberbank.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import ru.sberbank.model.UserGroupType;

/**
 * Created by Илья on 28.05.2016.
 */

@Service("authenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider  {

    @Resource
    private UserRepository userRepository;

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        final User user = userRepository.findByLoginAndPassword(login, password);
        if (user != null) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            
            grantedAuths.add(new SimpleGrantedAuthority(user.getGroup() != null ? user.getGroup().getUserGroupType().name() : UserGroupType.PUPIL.name()));
            return new UsernamePasswordAuthenticationToken(login, password, grantedAuths);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}

package sweet.dh.proj01.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sweet.dh.proj01.repository.SimpleUserRepository;

@Component
@RequiredArgsConstructor
@Transactional
public class SimpleJpaUserDetailsService implements UserDetailsService {

    private final SimpleUserRepository simpleUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return simpleUserRepository.findByUsername(username);
    }
}

package sweet.dh.proj01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sweet.dh.proj01.entity.Authority;
import sweet.dh.proj01.entity.SimpleUser;
import sweet.dh.proj01.repository.AutorityRepository;
import sweet.dh.proj01.repository.SimpleUserRepository;

@SpringBootApplication
public class Proj01Application {

    @Autowired
    private SimpleUserRepository simpleUserRepository;

    @Autowired
    private AutorityRepository autorityRepository;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            SimpleUser user = SimpleUser.builder()
                    .username("kim")
                    .password("1234")
                    .build();

            Authority auth = Authority.builder()
                    .user(user)
                    .authorityName("ADMIN")
                    .build();

            simpleUserRepository.save(user);
            autorityRepository.save(auth);

            user.addAuthority(auth);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Proj01Application.class, args);
    }

}

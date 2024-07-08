package sweet.dh.proj01.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class SimpleUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String username;

    @Column(length = 100)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Authority> authorities = new ArrayList<>();

    @Builder
    public SimpleUser(String username, String password, List<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities == null ? new ArrayList<>() : authorities;
    }

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public List<Authority> getAuthorities() {
        return authorities;
    }

}

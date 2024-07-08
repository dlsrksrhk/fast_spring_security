package sweet.dh.proj01.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Builder
@Getter @Setter
@Entity
@Table(name = "authorities")
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private SimpleUser user;

    @Column(length = 100)
    private String authorityName;

    @Override
    public String getAuthority() {
        return authorityName;
    }
}

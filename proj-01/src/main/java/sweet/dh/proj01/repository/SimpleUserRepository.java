package sweet.dh.proj01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sweet.dh.proj01.entity.SimpleUser;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, Long> {
    SimpleUser findByUsername(String username);
}

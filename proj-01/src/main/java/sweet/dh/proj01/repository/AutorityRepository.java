package sweet.dh.proj01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sweet.dh.proj01.entity.Authority;
import sweet.dh.proj01.entity.SimpleUser;

import java.util.List;

public interface AutorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByUser(SimpleUser user);
}

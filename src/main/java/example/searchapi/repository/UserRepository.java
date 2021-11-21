package example.searchapi.repository;

import example.searchapi.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select u from User u join fetch u.roles where u.login = :login")
    Optional<User> getByLogin(@Param(value = "login") String login);
}

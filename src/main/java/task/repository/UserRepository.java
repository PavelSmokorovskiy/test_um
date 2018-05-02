package task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.model.User;

/**
 * @author Pavel Smokorovskiy on 02.05.18
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}


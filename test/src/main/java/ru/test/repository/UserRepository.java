package ru.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}

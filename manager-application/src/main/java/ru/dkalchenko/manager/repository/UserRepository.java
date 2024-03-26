package ru.dkalchenko.manager.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dkalchenko.manager.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}

package org.example.kingcrabback.repository;

import org.example.kingcrabback.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

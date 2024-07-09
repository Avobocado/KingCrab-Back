package org.example.kingcrabback.domain.user.repository;

import org.example.kingcrabback.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

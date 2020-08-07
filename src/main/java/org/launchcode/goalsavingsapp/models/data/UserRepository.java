package org.launchcode.goalsavingsapp.models.data;

import org.launchcode.goalsavingsapp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}

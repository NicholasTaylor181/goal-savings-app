package org.launchcode.goalsavingsapp.models.data;

import org.launchcode.goalsavingsapp.models.Goal;
import org.springframework.data.repository.CrudRepository;

public interface GoalRepository extends CrudRepository<Goal, Integer> {

    Goal findByTitle(String title);
}

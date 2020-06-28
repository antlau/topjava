package ru.javawebinar.topjava.repository;

import org.springframework.stereotype.Component;
import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;
@Component
public interface MealRepository {
    // null if not found, when updated
    Meal save(Meal meal, int userId);

    // false if not found
    boolean delete(int id, int userId);

    // null if not found
    Meal get(int id, int userId);

    Collection<Meal> getAll(int userId);
}

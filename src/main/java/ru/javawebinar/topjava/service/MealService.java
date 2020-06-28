package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.Collection;

@Service
public class MealService {

    private MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    // null if not found, when updated
    public Meal save(Meal meal, int userId) {
        return repository.save(meal, userId);
    }

    // false if not found
    public boolean delete(int id, int userId) {
        return repository.delete(id, userId);
    }

    // null if not found
    public Meal get(int id, int userId) {
        return repository.get(id, userId);
    }

    public Collection<Meal> getAll(int userId) {
        return repository.getAll(userId);
    }
}
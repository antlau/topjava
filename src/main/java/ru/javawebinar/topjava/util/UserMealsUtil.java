package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsTo.forEach(System.out::println);

//        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime,
                                                            LocalTime endTime, int caloriesPerDay) {
        System.out.println("TODO return filtered list with excess. Implement by cycles");
        List<UserMealWithExcess> mealWithExcesses = new ArrayList<>();
        Map<LocalDate, Integer> sumCalories = new HashMap<>();
        List<UserMealWithExcess> filteredMeals = new ArrayList<>();
        for (UserMeal userMeal : meals) {
            if (sumCalories.containsKey(userMeal.getDateTime().toLocalDate())) {
                sumCalories.put(userMeal.getDateTime().toLocalDate(),
                        sumCalories.get(userMeal.getDateTime().toLocalDate()) + userMeal.getCalories());
            }
            else {
                sumCalories.put(userMeal.getDateTime().toLocalDate(), userMeal.getCalories());
            }
        }
        for (UserMeal userMeal : meals) {
            if (sumCalories.get(userMeal.getDateTime().toLocalDate()) > caloriesPerDay) {
                mealWithExcesses.add(new UserMealWithExcess(userMeal.getDateTime(), userMeal.getDescription(),
                        userMeal.getCalories(), true));
            }
            else {
                mealWithExcesses.add(new UserMealWithExcess(userMeal.getDateTime(), userMeal.getDescription(),
                        userMeal.getCalories(), false));
            }
        }
        for (UserMealWithExcess mealWithExcess : mealWithExcesses) {
            LocalTime mealLocalTime = mealWithExcess.getDateTime().toLocalTime();
            if (mealLocalTime.compareTo(startTime) > 0 && mealLocalTime.compareTo(endTime) < 0) {
                filteredMeals.add(mealWithExcess);
            }
        }
        return filteredMeals;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams
        return null;
    }
}

package by.rost.jd01_23.restaurant;

import com.rost.lesson23.restaurant.dao.RestaurantDao;
import com.rost.lesson23.restaurant.model.Restaurant;

public class RestaurantTest {

    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.builder()
                .name("Butter Bro")
                .build();

        RestaurantDao.getInstance().save(restaurant);
        System.out.println(restaurant);
    }
}

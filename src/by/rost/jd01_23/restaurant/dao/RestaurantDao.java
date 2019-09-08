package by.rost.jd01_23.restaurant.dao;

import com.rost.lesson22.jdbc.exception.DaoException;
import com.rost.lesson23.restaurant.model.Dish;
import com.rost.lesson23.restaurant.model.Restaurant;
import com.rost.lesson23.restaurant.util.ConnectionManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantDao {

    private static final RestaurantDao INSTANCE = new RestaurantDao();
    private static final String SAVE = "INSERT INTO reataurant (name) VALUES (?);";
    private static final String ADD_DISH = "INSERT INTO restauran_dish (restauran_id, dish_id) VALUES (?, ?);";
    private static final String GET_BY_ID =
            "SELECT " +
                    "r.id AS r_id, " +
                    "r.name AS r_name, " +
                    "d.id AS d_id, " +
                    "d.name AS d_name " +
                    "FROM reataurant r " +
                    "LEFT JOIN restauran_dish rd " +
                    "ON r.id = rd.restauran_id " +
                    "LEFT JOIN dish d " +
                    "ON d.id = rd.dish_id " +
                    "WHERE r.id = ?";

    public Optional<Restaurant> getById(Integer id) {
        Restaurant restaurant = null;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (restaurant == null) {
                    restaurant = Restaurant.builder()
                            .id(resultSet.getInt("r_id"))
                            .name(resultSet.getString("r_name"))
                            .dishes(new HashSet<>())
                            .build();
                }
                restaurant.getDishes().add(Dish.builder()
                        .id(resultSet.getLong("d_id"))
                        .name(resultSet.getString("d_name"))
                        .build());
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return Optional.ofNullable(restaurant);
    }

    public Restaurant addDish(Restaurant restaurant, Dish dish) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_DISH)) {
            preparedStatement.setInt(1, restaurant.getId());
            preparedStatement.setLong(2, dish.getId());
            preparedStatement.executeUpdate();

            restaurant.getDishes().add(dish);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return restaurant;
    }

    public Integer save(Restaurant restaurant) {
        Integer id = null;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                id = keys.getInt(1);
                restaurant.setId(id);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return id;
    }

    public static RestaurantDao getInstance() {
        return INSTANCE;
    }
}

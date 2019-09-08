package by.rost.jd01_23.restaurant.dao;

import com.rost.lesson23.restaurant.exception.DaoException;
import com.rost.lesson23.restaurant.model.Restaurant;
import com.rost.lesson23.restaurant.model.Review;
import com.rost.lesson23.restaurant.util.ConnectionManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewDao {

    private static final ReviewDao INSTANCE = new ReviewDao();
    private static final String SAVE = "INSERT INTO review (text, restaurant_id) VALUES (?, ?);";

    public Long save(@NonNull Review review) {
        Long id = null;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, review.getText());
            preparedStatement.setInt(2, Optional.ofNullable(review.getRestaurant()).map(Restaurant::getId).orElse(null));
            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                id = keys.getLong(1);
                review.setId(id);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return id;
    }

    public static ReviewDao getInstance() {
        return INSTANCE;
    }
}

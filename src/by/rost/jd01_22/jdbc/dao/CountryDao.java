package by.rost.jd01_22.jdbc.dao;

import com.rost.lesson22.jdbc.entity.Country;
import com.rost.lesson22.jdbc.entity.Language;
import com.rost.lesson22.jdbc.exception.DaoException;
import com.rost.lesson22.jdbc.util.ConnectionManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CountryDao {

    private static final CountryDao INSTANCE = new CountryDao();
    private static final String SAVE = "INSERT INTO lesson21.author_lesson.coutry(name, population, area, language) " +
            "VALUES (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM lesson21.author_lesson.coutry WHERE id = ?";
    private static final String GET_BY_ID = "SELECT id, name, population as population, area, language " +
            "FROM lesson21.author_lesson.coutry WHERE id = ?";

    public Optional<Country> getById(Integer id) {
        Country country = null;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                country = Country.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .population(resultSet.getInt("population"))
                        .area(resultSet.getInt("area"))
                        .language(Language.getByName(resultSet.getString("language")))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(country);
    }

    public Integer save(Country country) {
        Integer id = null;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getPopulation());
            preparedStatement.setInt(3, country.getArea());
            preparedStatement.setString(4, country.getLanguage().getName());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
                country.setId(id);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return id;
    }

    public boolean delete(Integer id) {
        boolean result = false;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }


    public static CountryDao getInstance() {
        return INSTANCE;
    }
}

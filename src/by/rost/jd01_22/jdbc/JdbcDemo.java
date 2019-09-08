package by.rost.jd01_22.jdbc;

import com.rost.lesson22.jdbc.dao.CountryDao;
import com.rost.lesson22.jdbc.entity.Country;
import com.rost.lesson22.jdbc.entity.Language;
import com.rost.lesson22.jdbc.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.rost.lesson22.jdbc.util.QueryUtil.ADD_COUNTRY;
import static com.rost.lesson22.jdbc.util.QueryUtil.GET_BOOKS_WITH_AUTHORS;
import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class JdbcDemo {

    public static void main(String[] args) {

        CountryDao.getInstance().getById(1)
                .ifPresent(System.out::println);
    }

    private static void test4() {
        Country country = Country.builder()
                .name("США5")
                .area(356456)
                .population(234234)
                .language(Language.RU)
                .build();
        CountryDao.getInstance().save(country);
        System.out.println(country);

        System.out.println(CountryDao.getInstance().delete(country.getId()));
    }

    private static void test3() {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOKS_WITH_AUTHORS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String bookName = resultSet.getString("book_name");
                System.out.print( " * ");
                String authorName = resultSet.getString("author_name");
                System.out.println(bookName + " | " + authorName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        final String countryName = "США2";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_COUNTRY,
                     RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, countryName);
            System.out.println("Inserting count: " + preparedStatement.executeUpdate());
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                System.out.println(generatedKeys.getLong(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    private static void test1() {
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement statement = connection.prepareStatement(GET_ALL_AUTHORS)) {
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                System.out.println(resultSet.getLong("id") + " " + resultSet.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

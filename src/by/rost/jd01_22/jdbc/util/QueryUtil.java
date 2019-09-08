package by.rost.jd01_22.jdbc.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class QueryUtil {

    public static final String GET_ALL_AUTHORS = "SELECT id, name, birth_day, country_id FROM book_storage.author";

    public static final String ADD_COUNTRY = "INSERT INTO country_storage.country (name) " +
            "VALUES (?)";

    public static final String GET_BOOKS_WITH_AUTHORS =
            "SELECT " +
                    "b.name as book_name, " +
                    "a.name as author_name " +
                    "FROM author_lesson.book b " +
                    "JOIN author_lesson.author a " +
                    "ON b.author_id = a.id";
}

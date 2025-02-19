package com.techcourse.dao;

import com.techcourse.domain.UserHistory;
import nextstep.jdbc.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserHistoryDao {

    private static final Logger log = LoggerFactory.getLogger(UserHistoryDao.class);

    private final JdbcTemplate jdbcTemplate;

    public UserHistoryDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(final UserHistory userHistory) {
        final var sql = "INSERT INTO user_history (user_id, account, password, email, created_at, created_by) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, userHistory.getUserId(), userHistory.getAccount(), userHistory.getPassword(),
                userHistory.getEmail(), userHistory.getCreatedAt(), userHistory.getCreateBy());

        log.debug("query : {}", sql);
    }
}

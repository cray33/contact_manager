package my.home.contact_manager.dao;

import my.home.contact_manager.entity.ApplicationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ApplicationEntity getLastApplication(Long contactId) {
        List<ApplicationEntity> result = jdbcTemplate.query(
                " SELECT * FROM application " +
                " WHERE contact_id = ? " +
                " ORDER BY dt_created DESC LIMIT 1",
                new ApplicationRowMapper(), contactId);

        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    class ApplicationRowMapper implements RowMapper<ApplicationEntity> {
        @Override
        public ApplicationEntity mapRow(ResultSet rs, int i) throws SQLException {
            ApplicationEntity entity = new ApplicationEntity();
            entity.setApplicationId(rs.getLong("application_id"));
            entity.setContactId(rs.getLong("contact_id"));
            entity.setDtCreated(rs.getTimestamp("dt_created"));
            entity.setProductName(rs.getString("product_name"));
            return entity;
        }
    }
}

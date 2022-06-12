package jp.yo41sawada.backend.domain;

import jp.yo41sawada.backend.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.mapping.JdbcValue;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.sql.JDBCType;
import java.util.List;

@Configuration
class JdbcConfiguration extends AbstractJdbcConfiguration {

    @Override
    protected List<?> userConverters() {
        return List.of(new UserStatusWritingConverter());
    }

    @WritingConverter
    static class UserStatusWritingConverter implements Converter<User.StatusEnum, JdbcValue> {
        @Override
        public JdbcValue convert(User.StatusEnum source) {
            return JdbcValue.of(source.name(), JDBCType.OTHER);
        }
    }
}
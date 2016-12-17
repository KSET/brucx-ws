package org.kset.brucx.repositories.impl;

import org.kset.brucx.models.TicketType;
import org.kset.brucx.repositories.AbstractJdbcRepository;
import org.kset.brucx.repositories.ITicketTypeRepository;
import org.kset.brucx.util.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by marin on 14.12.2016..
 */
@Repository
public class TicketTypeRepository extends AbstractJdbcRepository implements ITicketTypeRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketTypeRepository.class);

    @Override
    public TicketType getTicketTypeByName(String name, boolean active) {
        LOGGER.info("Fetching ticket type with name = {} and active = {}", name, active);
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("active", active);
        params.addValue("date", Date.valueOf(LocalDate.now()));
        TicketType ticketType = null;
        try {
            ticketType = namedParameterJdbcTemplate.queryForObject(
                    queryLoader.getQuery(Query.GET_TICKET_TYPE_BY_NAME),
                    params,
                    new BeanPropertyRowMapper<>(TicketType.class)
            );
            LOGGER.info("Found ticket type -> {}", ticketType.toString());
        } catch (EmptyResultDataAccessException e) {
            LOGGER.warn("Ticket type with name = {} and active = {} not found", name, active);
        }
        return ticketType;
    }

    @Override
    public List<TicketType> getTicketTypes(boolean active) {
        LOGGER.info("Fetching list of ticket type with active = {}", active);
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("active", active);
        params.addValue("date", Date.valueOf(LocalDate.now()));
        return namedParameterJdbcTemplate.query(
                queryLoader.getQuery(Query.GET_TICKET_TYPES),
                params,
                new BeanPropertyRowMapper<>(TicketType.class)
        );
    }
}

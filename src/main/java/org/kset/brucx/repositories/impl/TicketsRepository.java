package org.kset.brucx.repositories.impl;

import org.kset.brucx.util.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kset.brucx.models.Ticket;
import org.kset.brucx.repositories.AbstractJdbcRepository;
import org.kset.brucx.repositories.ITicketsRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvh-27 on 2.1.2017..
 */
@Repository
public class TicketsRepository extends AbstractJdbcRepository implements ITicketsRepository{

    public static final Logger LOGGER = LoggerFactory.getLogger(TicketsRepository.class);
    /**
     * Fetches student ticket.
     *
     * @param studentJmbag   student unique identifier
     * @param ticketTypeName ticket type name
     * @return single {@link Ticket} or null if student didn't bought ticket
     */
    @Override
    public Ticket getTicket(String studentJmbag, String ticketTypeName) {
        LOGGER.info("Fetching ticket for JMBAG = {} of type = {}", studentJmbag, ticketTypeName);
        MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("jmbag", studentJmbag);
            params.addValue("type", ticketTypeName);
            params.addValue("date", Date.valueOf(LocalDate.now()));

        Ticket ticket = null;
        try {
            ticket = namedParameterJdbcTemplate.queryForObject(
                    queryLoader.getQuery(Query.GET_TICKET_BY_JMBAG), params, new BeanPropertyRowMapper<>(Ticket.class)
            );
            LOGGER.info("Found ticket -> {}", ticket.toString());
        }
        catch (EmptyResultDataAccessException exc) {
            LOGGER.warn("Ticket for JMBAG = {} not found", studentJmbag);
        }
        return ticket;
    }

    /**
     * Fetches student ticket.
     *
     * @param studentJmbag student unique identifier
     * @param ticketTypeId ticket type id
     * @return single {@link Ticket} or null if student didn't bought ticket
     */
    @Override
    public Ticket getTicket(String studentJmbag, Integer ticketTypeId) {
        LOGGER.info("Fetching ticket for JMBAG = {} with typeID = {}", studentJmbag, ticketTypeId);
        MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("jmbag", studentJmbag);
            params.addValue("typeID", ticketTypeId);
            params.addValue("date", Date.valueOf(LocalDate.now()));

        Ticket ticket = null;
        try{
            ticket = namedParameterJdbcTemplate.queryForObject(
                    queryLoader.getQuery(Query.GET_TICKET_BY_ID), params, new BeanPropertyRowMapper<>(Ticket.class)
            );
            LOGGER.info("Found ticket -> {}", ticket.toString());
        }
        catch(EmptyResultDataAccessException exc){
            LOGGER.warn("Ticket for JMBAG = {} with TypeID = {} not found", studentJmbag, ticketTypeId);
        }
        return ticket;
    }

    /**
     * Fetches all student bought tickets
     *
     * @param studentJmbag student unique identifier
     * @return list of student bought {@link Ticket}s
     */
    @Override
    public List<Ticket> getStudentTickets(String studentJmbag) {
        LOGGER.info("Fetching all tickets the student with JMBAG = {} bought", studentJmbag);
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("jmbag", studentJmbag);
        params.addValue("date", Date.valueOf(LocalDate.now()));

        return namedParameterJdbcTemplate.query(
                        queryLoader.getQuery(Query.GET_STUDENT_TICKETS),
                        params,
                        new BeanPropertyRowMapper<>(Ticket.class)
        );
    }

    /**
     * Fetches all bought tickets of specific type
     *
     * @param ticketTypeName ticket type name
     * @return list of {@link Ticket} objects
     */
    @Override
    public List<Ticket> getAllTickets(String ticketTypeName) {
        LOGGER.info("Fetching all bought tickets of type = {}", ticketTypeName);
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ticketType", ticketTypeName);
        params.addValue("date", Date.valueOf(LocalDate.now()));

        return namedParameterJdbcTemplate.query(
                queryLoader.getQuery(Query.GET_TICKET_TYPE_BY_NAME_TICKETS),
                params,
                new BeanPropertyRowMapper<>(Ticket.class)
        );
    }

    /**
     * Fetches all bought tickets of specific type
     *
     * @param ticketTypeId ticket type name
     * @return list of {@link Ticket} objects
     */
    @Override
    public List<Ticket> getAllTickets(Integer ticketTypeId) {
        LOGGER.info("Fetching all bought tickets of typeID = {}", ticketTypeId);
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ticketTypeID", ticketTypeId);
        params.addValue("date", Date.valueOf(LocalDate.now()));

        return namedParameterJdbcTemplate.query(
                queryLoader.getQuery(Query.GET_TICKET_TYPE_BY_ID_TICKETS),
                params,
                new BeanPropertyRowMapper<>(Ticket.class)
        );
    }

    /**
     * Stores newly bought ticket
     *
     * @param ticket bought {@link Ticket}
     */
    @Override
    public void store(Ticket ticket) {
        LOGGER.info("Storing the newly bought ticket = {}", ticket.toString());
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ticket", ticket);
        params.addValue("date", Date.valueOf(LocalDate.now()));

        namedParameterJdbcTemplate.queryForObject(
                queryLoader.getQuery(Query.STORE_TICKET),
                params,
                new BeanPropertyRowMapper<>(Ticket.class)
        );

        LOGGER.info("Ticket = {} stored!", ticket.toString());
    }

    /**
     * Deletes bought ticket
     *
     * @param jmbag          student unique identifier
     * @param ticketTypeName ticket type name
     */
    @Override
    public void delete(String jmbag, String ticketTypeName) {
        LOGGER.info("Deleting ticket of type = {} for JMBAG = {}");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("jmbag", jmbag);
        params.addValue("ticketType", ticketTypeName);
        params.addValue("date", Date.valueOf(LocalDate.now()));

        namedParameterJdbcTemplate.queryForObject(
                queryLoader.getQuery(Query.DELETE_TICKET),
                params,
                new BeanPropertyRowMapper<>(Ticket.class)
        );

        LOGGER.info("Ticket for JMBAG = {} deleted!", jmbag);
    }
}

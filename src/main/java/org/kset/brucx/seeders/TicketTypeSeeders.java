package org.kset.brucx.seeders;

import org.kset.brucx.repositories.ITicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Class used for seeding ticket types into database.
 * Only used in development and test environment.
 */
@Profile({"dev", "test"})
@Component
public class TicketTypeSeeders implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ITicketTypeRepository ticketTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        if (ticketTypeRepository.getTicketTypeByName("brucosijada-2015", false) == null) {
            jdbcTemplate.execute("INSERT INTO ticket_type(name, default_price, active_from, active_to, required_in_table) VALUES('brucosijada-2015', '40', CURRENT_DATE, DATE '3000-10-05', 'freshmen')");
        }
        if (ticketTypeRepository.getTicketTypeByName("testType", false) == null) {
            jdbcTemplate.execute("INSERT INTO ticket_type(name, default_price, active_from, active_to, required_in_table) VALUES('testType', '40', DATE '2000-10-05', DATE '2001-10-05', NULL )");
        }
    }
}

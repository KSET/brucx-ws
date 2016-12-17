package org.kset.brucx.repositories;

import org.kset.brucx.models.TicketType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by marin on 14.12.2016..
 */
@Repository
public interface ITicketTypeRepository {

    /**
     * Fetches ticket type by name.
     * @param name ticket name
     * @param active if true ticket will be returned only if active
     * @return {@link TicketType} object or null if ticket by given name does't exists
     */
    TicketType getTicketTypeByName(String name, boolean active);

    /**
     * Fetches list of existing tickets.
     * @param active if true, only active tickets will be returned
     * @return list of {@link TicketType} objects
     */
    List<TicketType> getTicketTypes(boolean active);

}

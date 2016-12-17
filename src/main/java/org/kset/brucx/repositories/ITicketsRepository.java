package org.kset.brucx.repositories;

import org.kset.brucx.models.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by marin on 17.12.2016..
 */
@Repository
public interface ITicketsRepository {

    /**
     * Fetches student ticket.
     * @param studentJmbag student unique identifier
     * @param ticketTypeName ticket type name
     * @return single {@link Ticket} or null if student didn't bought ticket
     */
    Ticket getTicket(String studentJmbag, String ticketTypeName);

    /**
     * Fetches student ticket.
     * @param studentJmbag student unique identifier
     * @param ticketTypeId ticket type id
     * @return single {@link Ticket} or null if student didn't bought ticket
     */
    Ticket getTicket(String studentJmbag, Integer ticketTypeId);

    /**
     * Fetches all student bought tickets
     * @param studentJmbag student unique identifier
     * @return list of student bought {@link Ticket}s
     */
    List<Ticket> getStudentTickets(String studentJmbag);

    /**
     * Fetches all bought tickets of specific type
     * @param ticketTypeName ticket type name
     * @return list of {@link Ticket} objects
     */
    List<Ticket> getAllTickets(String ticketTypeName);

    /**
     * Fetches all bought tickets of specific type
     * @param ticketTypeId ticket type name
     * @return list of {@link Ticket} objects
     */
    List<Ticket> getAllTickets(Integer ticketTypeId);

    /**
     * Stores newly bought ticket
     * @param ticket bought {@link Ticket}
     */
    void store(Ticket ticket);

    /**
     * Deletes bought ticket
     * @param jmbag student unique identifier
     * @param ticketTypeName ticket type name
     */
    void delete(String jmbag, String ticketTypeName);
}

package org.kset.brucx.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kset.brucx.models.TicketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by marin on 17.12.2016..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketTypeRepositoryTest {

    @Autowired
    private ITicketTypeRepository ticketTypeRepository;

    @Test
    public void testGetTicketType() {
        TicketType ticketType = ticketTypeRepository.getTicketTypeByName("brucosijada-2015", false);
        Assert.assertNotNull(ticketType);
        Assert.assertEquals("brucosijada-2015", ticketType.getName());
        Assert.assertEquals("freshmen", ticketType.getRequiredInTable());
        Assert.assertEquals(40d, ticketType.getDefaultPrice(), 0.01);
    }

    @Test
    public void testGetActiveTicketType() {
        TicketType ticketType = ticketTypeRepository.getTicketTypeByName("brucosijada-2015", true);
        Assert.assertNotNull(ticketType);
        Assert.assertEquals("brucosijada-2015", ticketType.getName());
        Assert.assertEquals("freshmen", ticketType.getRequiredInTable());
        Assert.assertEquals(40d, ticketType.getDefaultPrice(), 0.01);
    }

     @Test
    public void testGetExpiredTicketType() {
        TicketType ticketType = ticketTypeRepository.getTicketTypeByName("testType", false);
        Assert.assertNotNull(ticketType);
        Assert.assertEquals("testType", ticketType.getName());
        Assert.assertNull(ticketType.getRequiredInTable());
    }

    @Test
    public void testGetExpiredTicketTypeFail() {
        TicketType ticketType = ticketTypeRepository.getTicketTypeByName("testType", true);
        Assert.assertNull(ticketType);
    }

    @Test
    public void testGetActiveTicketTypes() {
        List<TicketType> ticketTypes = ticketTypeRepository.getTicketTypes(true);
        Assert.assertEquals(1, ticketTypes.size());
    }

    @Test
    public void testGetTicketTypes() {
        List<TicketType> ticketTypes = ticketTypeRepository.getTicketTypes(false);
        Assert.assertEquals(2, ticketTypes.size());
    }
}

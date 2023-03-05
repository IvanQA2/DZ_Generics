package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketManagerTest {

    @Test
    public void testSortTicket() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        Ticket ticket1 = new Ticket(1, 200, "MSK", "IZ", 23);
        Ticket ticket2 = new Ticket(2, 100, "MSK", "IZ", 23);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "IZ", 23);
        Ticket ticket4 = new Ticket(4, 2700, "MSK", "IZ", 23);
        Ticket ticket5 = new Ticket(5, 400, "MSK", "IZ", 23);
        Ticket ticket6 = new Ticket(6, 7700, "MSK", "IZ", 23);
        Ticket ticket7 = new Ticket(7, 500, "MSK", "IZ", 23);
        Ticket ticket8 = new Ticket(8, 40, "MSK", "IZ", 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] expected = {ticket8, ticket2, ticket1, ticket3, ticket5, ticket7, ticket4, ticket6};
        Ticket[] actual = manager.findAll("MSK", "IZ");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortTicketDifferentDirections() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        Ticket ticket1 = new Ticket(1, 200, "MSK", "IZ", 23);
        Ticket ticket2 = new Ticket(2, 100, "MSK", "IZ", 23);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "IZ", 23);
        Ticket ticket4 = new Ticket(4, 2700, "IZ", "MSK", 23);
        Ticket ticket5 = new Ticket(5, 400, "MSK", "IZ", 23);
        Ticket ticket6 = new Ticket(6, 7700, "MSK", "IZ", 23);
        Ticket ticket7 = new Ticket(7, 500, "LO", "IZ", 23);
        Ticket ticket8 = new Ticket(8, 40, "MSK", "IZ", 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] expected = {ticket8, ticket2, ticket1, ticket3, ticket5, ticket6};
        Ticket[] actual = manager.findAll("MSK", "IZ");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortOneTicket() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        Ticket ticket1 = new Ticket(1, 200, "MSK", "IZ", 23);
        Ticket ticket2 = new Ticket(2, 100, "MSK", "IZ", 23);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "IZ", 23);
        Ticket ticket4 = new Ticket(4, 2700, "IZ", "MSK", 23);
        Ticket ticket5 = new Ticket(5, 400, "MSK", "IZ", 23);
        Ticket ticket6 = new Ticket(6, 7700, "MSK", "IZ", 23);
        Ticket ticket7 = new Ticket(7, 500, "LO", "IZ", 23);
        Ticket ticket8 = new Ticket(8, 40, "MSK", "IZ", 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.findAll("LO", "IZ");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortNotDepartureAirport() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        Ticket ticket1 = new Ticket(1, 200, "MSK", "IZ", 23);
        Ticket ticket2 = new Ticket(2, 100, "MSK", "IZ", 23);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "IZ", 23);
        Ticket ticket4 = new Ticket(4, 2700, "IZ", "MSK", 23);
        Ticket ticket5 = new Ticket(5, 400, "MSK", "IZ", 23);
        Ticket ticket6 = new Ticket(6, 7700, "MSK", "IZ", 23);
        Ticket ticket7 = new Ticket(7, 500, "LO", "IZ", 23);
        Ticket ticket8 = new Ticket(8, 40, "MSK", "IZ", 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SPB", "IZ");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testCompareTo() {
        Ticket ticket1 = new Ticket(1, 100, "MSK", "IZ", 23);
        Ticket ticket2 = new Ticket(2, 200, "MSK", "IZ", 23);
        Ticket ticket3 = new Ticket(3, 150, "MSK", "IZ", 23);

        Assertions.assertTrue(ticket1.compareTo(ticket2) < 0);
        Assertions.assertTrue(ticket2.compareTo(ticket1) > 0);
        Assertions.assertTrue(ticket2.compareTo(ticket3) > 0);
        Assertions.assertTrue(ticket3.compareTo(ticket2) < 0);
        Assertions.assertTrue(ticket2.compareTo(ticket2) == 0);
    }

    @Test
    public void testMatchesWhenTrue() {

        Ticket ticket = new Ticket(1, 100, "MSK", "IZ", 23);

        boolean result = TicketManager.matches(ticket, "MSK", "IZ");
        Assertions.assertTrue(result);
    }

    @Test
    public void testGetId() {

        Ticket ticket = new Ticket(1, 100, "MSK", "IZ", 120);
        Assertions.assertEquals(1, ticket.getId());
    }

    @Test
    public void testGetPrice() {
        Ticket ticket = new Ticket(1, 100, "MSK", "IZ", 120);
        Assertions.assertEquals(100, ticket.getPrice());
    }

    @Test
    public void testGetDepartureAirport() {
        Ticket ticket = new Ticket(1, 100, "MSK", "IZ", 120);
        Assertions.assertEquals("MSK", ticket.getDepartureAirport());
    }

    @Test
    public void testGetDestinationAirport() {
        Ticket ticket = new Ticket(1, 100, "MSK", "IZ", 120);
        Assertions.assertEquals("IZ", ticket.getDestinationAirport());
    }

    @Test
    public void testGetTravelTime() {
        Ticket ticket = new Ticket(1, 100, "MSK", "IZ", 120);
        Assertions.assertEquals(120, ticket.getTravelTime());
    }
}
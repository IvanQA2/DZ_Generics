package org.example;

import java.util.*;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket product) {
        repository.add(product);
    }

    public Ticket[] findAll(String departureAirport, String destinationAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, departureAirport, destinationAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = ticket;
                result = tmp;
            }

        }
        Arrays.sort(result);
        return result;
    }

    public static boolean matches(Ticket ticket, String departureAirport, String destinationAirport) {
        if (ticket.getDepartureAirport().equals(departureAirport)) {
            if (ticket.getDestinationAirport().equals(destinationAirport)) {
                return true;
            }
        }
        return false;
    }
}

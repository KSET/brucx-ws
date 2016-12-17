package org.kset.brucx.models;

import java.time.LocalDateTime;

/**
 * Created by marin on 17.12.2016..
 */
public class Ticket {

    private String studentJmbag;

    private Integer ticketTypeId;

    private TicketType ticketType;

    private LocalDateTime boughtOn;

    private Double price;

    public String getStudentJmbag() {
        return studentJmbag;
    }

    public void setStudentJmbag(String studentJmbag) {
        this.studentJmbag = studentJmbag;
    }

    public Integer getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Integer ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public LocalDateTime getBoughtOn() {
        return boughtOn;
    }

    public void setBoughtOn(LocalDateTime boughtOn) {
        this.boughtOn = boughtOn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (studentJmbag != null ? !studentJmbag.equals(ticket.studentJmbag) : ticket.studentJmbag != null)
            return false;
        return ticketTypeId != null ? ticketTypeId.equals(ticket.ticketTypeId) : ticket.ticketTypeId == null;

    }

    @Override
    public int hashCode() {
        int result = studentJmbag != null ? studentJmbag.hashCode() : 0;
        result = 31 * result + (ticketTypeId != null ? ticketTypeId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "studentJmbag='" + studentJmbag + '\'' +
                ", ticketTypeId=" + ticketTypeId +
                ", ticketType=" + ticketType +
                ", boughtOn=" + boughtOn +
                ", price=" + price +
                '}';
    }
}

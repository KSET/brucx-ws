package org.kset.brucx.models;

import java.time.LocalDate;

/**
 * Created by marin on 14.12.2016..
 */
public class TicketType {

    private Integer id;

    private String name;

    private Double defaultPrice;

    private LocalDate activeFrom;

    private LocalDate activeTo;

    private String requiredInTable;

    public TicketType() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(LocalDate activeFrom) {
        this.activeFrom = activeFrom;
    }

    public LocalDate getActiveTo() {
        return activeTo;
    }

    public void setActiveTo(LocalDate activeTo) {
        this.activeTo = activeTo;
    }

    public String getRequiredInTable() {
        return requiredInTable;
    }

    public void setRequiredInTable(String requiredInTable) {
        this.requiredInTable = requiredInTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketType that = (TicketType) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", defaultPrice=" + defaultPrice +
                ", activeFrom=" + activeFrom +
                ", activeTo=" + activeTo +
                ", requiredInTable='" + requiredInTable + '\'' +
                '}';
    }
}

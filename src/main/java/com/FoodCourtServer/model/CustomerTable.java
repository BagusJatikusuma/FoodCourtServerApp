package com.FoodCourtServer.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bagus on 25/06/17.
 */
@Entity
@Table(name = "CustomerTable")
public class CustomerTable {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "sector")
    private String sector;

    @Column(name = "table_total")
    private Short tableTotal;

    @OneToMany(mappedBy = "customerTable", cascade = CascadeType.ALL)
    private List<Order> orders;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Short getTableTotal() {
        return tableTotal;
    }

    public void setTableTotal(Short tableTotal) {
        this.tableTotal = tableTotal;
    }
}

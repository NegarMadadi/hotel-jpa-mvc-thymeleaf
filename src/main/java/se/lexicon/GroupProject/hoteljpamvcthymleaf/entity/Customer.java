package se.lexicon.GroupProject.hoteljpamvcthymleaf.entity;

import org.hibernate.annotations.GenericGenerator;


import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private LocalDate bookingDate;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookingList;


    public Customer() {
    }

    public Customer(String customerFirstName, String customerLastName, String customerEmail, LocalDate bookingDate, List<Booking> bookingList) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.bookingDate = bookingDate;
        this.bookingList = bookingList;
    }

    public Customer(String customerId, String customerFirstName, String customerLastName, String customerEmail, LocalDate bookingDate) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.bookingDate = bookingDate;
    }

    ////****
    public Customer(String customerFirstName, String customerLastName, String customerEmail, LocalDate bookingDate) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.bookingDate = bookingDate;
    }

    public String getCustomerId() {
        return customerId;
    }


    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(customerFirstName, customer.customerFirstName) && Objects.equals(customerLastName, customer.customerLastName) && Objects.equals(customerEmail, customer.customerEmail) && Objects.equals(bookingDate, customer.bookingDate) && Objects.equals(bookingList, customer.bookingList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerFirstName, customerLastName, customerEmail, bookingDate, bookingList);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", bookingDate=" + bookingDate +
                ", bookingList=" + bookingList +
                '}';
    }
}

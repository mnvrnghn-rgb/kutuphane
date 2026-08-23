package com.example.kutuphane.dto;

public class CreateRentalRequest {
    private Long bookId;
    private String customerName;

    // Getter ve Setter Metotları
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
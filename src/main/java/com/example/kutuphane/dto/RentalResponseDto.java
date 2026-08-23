package com.example.kutuphane.dto;

public class RentalResponseDto {
    private Long id;
    private String customerName;
    private String bookTitle;

    public RentalResponseDto(Long id, String customerName, String bookTitle) {
        this.id = id;
        this.customerName = customerName;
        this.bookTitle = bookTitle;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
}
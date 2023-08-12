package com.wellsfargo.counselor.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//Advisor Entity
@Entity
public class Advisor {

    @Id
    @GeneratedValue()
    private Long advisorId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @OneToMany (mappedBy = advisorId)
    private List<Client> clients;

    protected Advisor() {

    }

//Constructors of Advisor
    public Advisor(String firstName, String lastName, String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

//Getters and setters of Advisor
    public Long getAdvisorId() {
        return advisorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

// Client Entity
@Entity
public class Client {

    @Id
    @GeneratedValue()
    private Long clientId;

     @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

// Other fields
    @ManyToOne
    @JoinColumn (name = "advisorId")
    private Advisor advisorId;

    @OneToMany (mappedBy = "clientId")
    private List<Portfolio> portfolios;

    protected Client() {

    }

// Constructors of Client
    public Client(String firstName, String lastName, String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

//Getters and setters of Client
    public Long getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

// Getter and setter of FK
    public Advisor getAdvisorId(){
        return advisorId;
    }

}

//Portfolio entity
@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private Long portfolioId;

     @Column(nullable = false)
    private LocalDate creationDate;

   // Other fields
    @ManyToOne
    @JoinColumn (name = "clientId")
    private Client clientId;

    @OneToMany (mappedBy = "portfolioId")
    private List<Security> securities;

    protected Portfolio() {

    }

// Constructors of Portfolio
    public Portfolio(LocalDate creationDate) {
        this.creationDate = creationDate;
            }

//Getters and setters of Portfolio
    public Long getportfolioId() {
        return portfolioId;
    }

    public LocalDate getcreationDate() {
        return creationDate;
    }

    public void setCreationDate (LocalDate creationDate) {
        this.creationDate = creationDate;
    }

// Getter and setter of FK
    public Client getClientId(){
        return clientId;
    }

}

//Security entity
@Entity
public class Security {

    @Id
    @GeneratedValue()
    private Long securityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Float purchasePrice;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private Int quantity;

   // Other fields
    @ManyToOne
    @JoinColumn (name = "portfolioId")
    private Portfolio portfolioId;


    protected Security() {

    }

// Constructors of Security
    public Security(String name,  String category,  Float purchasePrice, LocalDate purchaseDate, Int quantity) {
        this.name = name;
        this.category = category;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
            }

//Getters and setters of Security
    public Long getSecurityId() {
        return securityId;
    }

    public String getName() {
        return name;
    }
   
    public void setName (String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
   
    public void setCategory (String category) {
        this.category = category;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }
   
    public void setPurchasePrice (Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
   
    public void setPurchaseDate (LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Int getQuantity() {
        return quantity;
    }
   
    public void setQuantity (Int quantity) {
        this.quantity = quantity;
    }
    
// Getter and setter of FK
    public Portfolio getPortfolioId(){
        return portfolioId;
    }

}
package com.microlending.microlendingapp.entities.borrower;


import com.microlending.microlendingapp.entities.converters.ZipcodeConverter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converts;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BORROWERS")
public class Borrower {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

//    @NotNull
//    @Convert(converter = ZipcodeConverter.class, attributeName = "postalCode")
//    private Address currentAddress;
//
//    @NotNull
//    @Convert(converter = ZipcodeConverter.class, attributeName = "postalCode")
//    @AttributeOverrides({
//            @AttributeOverride(name = "street",
//                    column = @Column(name = "BILLING_STREET")),
//            @AttributeOverride(name = "postalCode",
//                    column = @Column(name = "BILLING_POSTAL_CODE", length = 5)),
//            @AttributeOverride(name = "city.name",
//                    column = @Column(name = "BILLING_CITY")),
//            @AttributeOverride(name = "city.country",
//                    column = @Column(name = "BILLING_COUNTRY"))
//    })
//    private Address billingAddress;
//
//    private String contactNumber;
//    private Date dateOfBirth;
//
//    @org.hibernate.annotations.Type(type = "yes_no")
//    private Boolean kycComplete;
//
//    private String highestQualification;
//    private String passoutYear;
//    private String universityName;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(updatable = false)
//    @org.hibernate.annotations.CreationTimestamp
//    protected Date createdOn;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(insertable = false, updatable = false)
//    @org.hibernate.annotations.Generated(
//            org.hibernate.annotations.GenerationTime.ALWAYS
//    )
//    protected Date lastModified;
//
//    //which approach for image storage is better
//    @Basic(fetch = FetchType.LAZY)
//    @Column(length = 131072) // 128 kilobyte maximum for the picture
//    protected byte[] image; // Maps to SQL VARBINARY type
//
//    @Lob
//    protected Blob imageBlob;
//
    @OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    protected List<LoanTicket> loanTickets = new ArrayList<>();

    public Borrower() {
    }

    public Borrower(@NotNull String firstName, @NotNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //    public Borrower(String firstName, String lastName, Address currentAddress, Address billingAddress, String contactNumber, Date dateOfBirth, Boolean kycComplete, String highestQualification, String passoutYear, String universityName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.currentAddress = currentAddress;
//        this.billingAddress = billingAddress;
//        this.contactNumber = contactNumber;
//        this.dateOfBirth = dateOfBirth;
//        this.kycComplete = kycComplete;
//        this.highestQualification = highestQualification;
//        this.passoutYear = passoutYear;
//        this.universityName = universityName;
//    }

    public Long getId() {
        return id;
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

//    public Address getCurrentAddress() {
//        return currentAddress;
//    }
//
//    public void setCurrentAddress(Address currentAddress) {
//        this.currentAddress = currentAddress;
//    }
//
//
//    public String getContactNumber() {
//        return contactNumber;
//    }
//
//    public void setContactNumber(String contactNumber) {
//        this.contactNumber = contactNumber;
//    }
//
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public Boolean getKycComplete() {
//        return kycComplete;
//    }
//
//    public void setKycComplete(Boolean kycComplete) {
//        this.kycComplete = kycComplete;
//    }
//
//    public String getHighestQualification() {
//        return highestQualification;
//    }
//
//    public void setHighestQualification(String highestQualification) {
//        this.highestQualification = highestQualification;
//    }
//
//    public String getPassoutYear() {
//        return passoutYear;
//    }
//
//    public void setPassoutYear(String passoutYear) {
//        this.passoutYear = passoutYear;
//    }
//
//    public String getUniversityName() {
//        return universityName;
//    }
//
//    public void setUniversityName(String universityName) {
//        this.universityName = universityName;
//    }
//
//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
//
//    public Blob getImageBlob() {
//        return imageBlob;
//    }
//
//    public void setImageBlob(Blob imageBlob) {
//        this.imageBlob = imageBlob;
//    }
//
//    public Address getBillingAddress() {
//        return billingAddress;
//    }
//
//    public void setBillingAddress(Address billingAddress) {
//        this.billingAddress = billingAddress;
//    }

    public List<LoanTicket> getLoanTickets() {
        return loanTickets;
    }

    public void addLoanTicket(LoanTicket loanTicket) {
        if (loanTicket == null) {
            throw new NullPointerException("Can't add null LoanTicket");
        }

        if (loanTicket.getBorrower() != null) {
            throw new IllegalStateException("LoanTicket is already assigned to a Borrower");
        }

        getLoanTickets().add(loanTicket);
        loanTicket.setBorrower(this);
    }
}

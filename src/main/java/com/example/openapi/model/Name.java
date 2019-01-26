/**
 * 
 */
package com.example.openapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 86211
 *
 */
@Entity
@Table(name="CUSTOMER_NAME")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Name implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -3962013815721041370L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name="customerNameId")
    private long customerNameId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="clientId",referencedColumnName="clientId",nullable=false)
    @JsonIgnore
    private CustomerProfile customerProfile;
    
    @JsonProperty("nameType")
    @Column(name="nameType")
    private String nameType;

    @NotNull
    @ApiModelProperty(required = true, value = "The first name of the customer. Also known as first name")
    @JsonProperty("firstName")
    @Column(name="firstName")
    private String firstName;
    
    @JsonProperty("lastName")
    @Column(name="lastName")
    private String lastName;
    
    @JsonProperty("fullName")
    @Column(name="fullName")
    private String fullName;
    
    @JsonProperty("middleName")
    @Column(name="middleName")
    private String middleName;

    public long getCustomerNameId() {
        return customerNameId;
    }

    public void setCustomerNameId(long customerNameId) {
        this.customerNameId = customerNameId;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (customerNameId ^ (customerNameId >>> 32));
        result = prime * result + ((customerProfile == null) ? 0 : customerProfile.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
        result = prime * result + ((nameType == null) ? 0 : nameType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Name other = (Name) obj;
        if (customerNameId != other.customerNameId)
            return false;
        if (customerProfile == null) {
            if (other.customerProfile != null)
                return false;
        } else if (!customerProfile.equals(other.customerProfile))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (middleName == null) {
            if (other.middleName != null)
                return false;
        } else if (!middleName.equals(other.middleName))
            return false;
        if (nameType == null) {
            if (other.nameType != null)
                return false;
        } else if (!nameType.equals(other.nameType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Name [customerNameId=" + customerNameId + ", customerParticulars=" + customerProfile + ", nameType="
                + nameType + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName
                + ", middleName=" + middleName + "]";
    }

    

}

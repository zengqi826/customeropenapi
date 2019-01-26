/**
 * 
 */
package com.example.openapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 86211
 *
 */
@Entity
@Table(name = "CUSTOMER_ADDRESS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4010024452454541127L;

    @EmbeddedId
    @JsonIgnore
    private AddressIdentity addressIentity;

    @JsonProperty(value="addressKey" ,access=Access.WRITE_ONLY)
    @Transient
    private int addressKeyForWrite;

    @JsonProperty("city")
    @Column(name = "city")
    private String city;

    @NotNull
    @ApiModelProperty(required = true, value = "Type of the address. This is a reference data field. Please use \\/utilities\\/referenceData\\/{addressType} resource to get valid values of this field with descriptions.")
    @JsonProperty("addressType")
    @Column(name = "addressType")
    private String addressType;

    @NotNull
    @ApiModelProperty(required = true, value = "Postal code the mailing address")
    @JsonProperty("postalCode")
    @Column(name = "postalCode")
    private String postalCode;

    @JsonProperty("addressline3")
    @Column(name = "addressline3")
    private String addressline3;

    @JsonProperty("addressline2")
    @Column(name = "addressline2")
    private String addressline2;

    @JsonProperty("addressline1")
    @Column(name = "addressline1")
    private String addressline1;

    @JsonProperty("state")
    @Column(name = "state")
    private String state;

    @NotNull
    @ApiModelProperty(required = true, value = "Country Name.This is a reference data field. Please use \\/v1\\/apac\\/utilities\\/referenceData\\/{countryName} resource to get valid value of this field with description.")
    @JsonProperty("countryName")
    @Column(name = "countryName")
    private String countryName;

    @JsonProperty("addressline4")
    @Column(name = "addressline4")
    private String addressline4;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", referencedColumnName = "clientId", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    @NotNull
    private CustomerProfile customerProfile;

    public int getAddressKeyForWrite() {
        return addressKeyForWrite;
    }

    public void setAddressKeyForWrite(int addressKeyForWrite) {
        this.addressKeyForWrite = addressKeyForWrite;
    }
    
    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public AddressIdentity getAddressIentity() {
        return addressIentity;
    }

    public void setAddressIentity(AddressIdentity addressIentity) {
        this.addressIentity = addressIentity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressline3() {
        return addressline3;
    }

    public void setAddressline3(String addressline3) {
        this.addressline3 = addressline3;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAddressline4() {
        return addressline4;
    }

    public void setAddressline4(String addressline4) {
        this.addressline4 = addressline4;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addressIentity == null) ? 0 : addressIentity.hashCode());
        result = prime * result + ((addressType == null) ? 0 : addressType.hashCode());
        result = prime * result + ((addressline1 == null) ? 0 : addressline1.hashCode());
        result = prime * result + ((addressline2 == null) ? 0 : addressline2.hashCode());
        result = prime * result + ((addressline3 == null) ? 0 : addressline3.hashCode());
        result = prime * result + ((addressline4 == null) ? 0 : addressline4.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
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
        Address other = (Address) obj;
        if (addressIentity == null) {
            if (other.addressIentity != null)
                return false;
        } else if (!addressIentity.equals(other.addressIentity))
            return false;
        if (addressType == null) {
            if (other.addressType != null)
                return false;
        } else if (!addressType.equals(other.addressType))
            return false;
        if (addressline1 == null) {
            if (other.addressline1 != null)
                return false;
        } else if (!addressline1.equals(other.addressline1))
            return false;
        if (addressline2 == null) {
            if (other.addressline2 != null)
                return false;
        } else if (!addressline2.equals(other.addressline2))
            return false;
        if (addressline3 == null) {
            if (other.addressline3 != null)
                return false;
        } else if (!addressline3.equals(other.addressline3))
            return false;
        if (addressline4 == null) {
            if (other.addressline4 != null)
                return false;
        } else if (!addressline4.equals(other.addressline4))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (countryName == null) {
            if (other.countryName != null)
                return false;
        } else if (!countryName.equals(other.countryName))
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Address [addressIentity=" + addressIentity + ", city=" + city + ", addressType=" + addressType
                + ", postalCode=" + postalCode + ", addressline3=" + addressline3 + ", addressline2=" + addressline2
                + ", addressline1=" + addressline1 + ", state=" + state + ", countryName=" + countryName
                + ", addressline4=" + addressline4 + "]";
    }

    @JsonProperty(value = "addressKey", access = Access.READ_ONLY)
    public int getAddressKey() {
        return addressIentity.getAddressKey();
    }
}

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
@Table(name = "CUSTOMER_PHONE")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Phone implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -2527431471199581484L;

    /**
     * 
     */

    @EmbeddedId
    @JsonIgnore
    private PhoneIdentity phoneIdentity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", referencedColumnName = "clientId", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private CustomerProfile customerProfile;

    @NotNull
    @ApiModelProperty(required = true, value = "The type of phone.This is a reference data field. Please use \\/utilities\\/referenceData\\/{phoneType} resource to get valid values of this field with descriptions")
    @JsonProperty("phoneType")
    @Column(name = "phoneType")
    private String phoneType;

    @JsonProperty("areaCode")
    @Column(name = "areaCode")
    private String areaCode;

    @JsonProperty("extension")
    @Column(name = "extension")
    private String extension;

    @NotNull
    @ApiModelProperty(required = true, value = "Unique identifier of the phone number")
    @JsonProperty("phoneNumber")
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotNull
    @ApiModelProperty(required = true, value = "Country calling code. This is a reference data field. Please use \\/utilities\\/referenceData\\/{phoneCountryCode} resource to get valid values of this field with description")
    @JsonProperty("phoneCountryCode")
    @Column(name = "phoneCountryCode")
    private String phoneCountryCode;

    @JsonProperty(value = "phoneKey", access = Access.WRITE_ONLY)
    @Transient
    private int phoneKeyForWrite;

    public int getPhoneKeyForWrite() {
        return phoneKeyForWrite;
    }

    public void setPhoneKeyForWrite(int phoneKeyForWrite) {
        this.phoneKeyForWrite = phoneKeyForWrite;
    }

    public PhoneIdentity getPhoneIdentity() {
        return phoneIdentity;
    }

    public void setPhoneIdentity(PhoneIdentity phoneIdentity) {
        this.phoneIdentity = phoneIdentity;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
        result = prime * result + ((customerProfile == null) ? 0 : customerProfile.hashCode());
        result = prime * result + ((extension == null) ? 0 : extension.hashCode());
        result = prime * result + ((phoneCountryCode == null) ? 0 : phoneCountryCode.hashCode());
        result = prime * result + ((phoneIdentity == null) ? 0 : phoneIdentity.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((phoneType == null) ? 0 : phoneType.hashCode());
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
        Phone other = (Phone) obj;
        if (areaCode == null) {
            if (other.areaCode != null)
                return false;
        } else if (!areaCode.equals(other.areaCode))
            return false;
        if (customerProfile == null) {
            if (other.customerProfile != null)
                return false;
        } else if (!customerProfile.equals(other.customerProfile))
            return false;
        if (extension == null) {
            if (other.extension != null)
                return false;
        } else if (!extension.equals(other.extension))
            return false;
        if (phoneCountryCode == null) {
            if (other.phoneCountryCode != null)
                return false;
        } else if (!phoneCountryCode.equals(other.phoneCountryCode))
            return false;
        if (phoneIdentity == null) {
            if (other.phoneIdentity != null)
                return false;
        } else if (!phoneIdentity.equals(other.phoneIdentity))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (phoneType == null) {
            if (other.phoneType != null)
                return false;
        } else if (!phoneType.equals(other.phoneType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Phone [phoneIdentity=" + phoneIdentity + ", customerProfile=" + customerProfile + ", phoneType="
                + phoneType + ", areaCode=" + areaCode + ", extension=" + extension + ", phoneNumber=" + phoneNumber
                + ", phoneCountryCode=" + phoneCountryCode + "]";
    }
    
    @JsonProperty(value = "phoneKey", access = Access.READ_ONLY)
    public int getPhoneKey() {
        return phoneIdentity.getPhoneKey();
    }

}

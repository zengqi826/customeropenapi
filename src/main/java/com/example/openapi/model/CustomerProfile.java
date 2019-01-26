/**
 * 
 */
package com.example.openapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 86211
 *
 */
@Entity
@Table(name="CUSTOMER_PROFILE")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"customerProfileId","clientId"}) 
public class CustomerProfile implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4169639948004051831L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerProfileId")
    private long customerProfileId;
    
    @NotNull
    @JsonProperty("clientId")
    @Column(name="clientId")
    private String clientId;
    
    @JsonProperty("customerType")
    @Column(name="customerType")
    private String customerType;
    
    @NotNull
    @ApiModelProperty(required = true, value = "Type of the customer. This is applicable only for Individual customers.This is a reference data field. Please use \\/v1\\/apac\\/utilities\\/referenceData\\/{customerSegment} resource to get valid value of this field with description. You can use customerSegment as the referenceCode parameter to retrieve the values.")
    @JsonProperty("customerSegment")
    @Column(name="customerSegment")
    private String customerSegment;
    
    @JsonProperty("partnerCustomerSegment")
    @Column(name="partnerCustomerSegment")
    private String partnerCustomerSegment;

    @Embedded
    @JsonProperty("customerParticulars")
    private CustomerParticulars customerParticulars;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customerProfile")
    @JsonProperty("emails")
    private List<Email> emails;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customerProfile")
    @JsonProperty("addressList")
    private List<Address> addressList;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customerProfile")
    @JsonProperty("phones")
    private List<Phone> phones;

    public long getCustomerProfileId() {
        return customerProfileId;
    }

    public void setCustomerProfileId(long customerProfileId) {
        this.customerProfileId = customerProfileId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public String getPartnerCustomerSegment() {
        return partnerCustomerSegment;
    }

    public void setPartnerCustomerSegment(String partnerCustomerSegment) {
        this.partnerCustomerSegment = partnerCustomerSegment;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public CustomerParticulars getCustomerParticulars() {
        return customerParticulars;
    }

    public void setCustomerParticulars(CustomerParticulars customerParticulars) {
        this.customerParticulars = customerParticulars;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addressList == null) ? 0 : addressList.hashCode());
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
        result = prime * result + ((customerParticulars == null) ? 0 : customerParticulars.hashCode());
        result = prime * result + ((customerSegment == null) ? 0 : customerSegment.hashCode());
        result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
        result = prime * result + (int) (customerProfileId ^ (customerProfileId >>> 32));
        result = prime * result + ((emails == null) ? 0 : emails.hashCode());
        result = prime * result + ((partnerCustomerSegment == null) ? 0 : partnerCustomerSegment.hashCode());
        result = prime * result + ((phones == null) ? 0 : phones.hashCode());
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
        CustomerProfile other = (CustomerProfile) obj;
        if (addressList == null) {
            if (other.addressList != null)
                return false;
        } else if (!addressList.equals(other.addressList))
            return false;
        if (clientId == null) {
            if (other.clientId != null)
                return false;
        } else if (!clientId.equals(other.clientId))
            return false;
        if (customerParticulars == null) {
            if (other.customerParticulars != null)
                return false;
        } else if (!customerParticulars.equals(other.customerParticulars))
            return false;
        if (customerSegment == null) {
            if (other.customerSegment != null)
                return false;
        } else if (!customerSegment.equals(other.customerSegment))
            return false;
        if (customerType == null) {
            if (other.customerType != null)
                return false;
        } else if (!customerType.equals(other.customerType))
            return false;
        if (customerProfileId != other.customerProfileId)
            return false;
        if (emails == null) {
            if (other.emails != null)
                return false;
        } else if (!emails.equals(other.emails))
            return false;
        if (partnerCustomerSegment == null) {
            if (other.partnerCustomerSegment != null)
                return false;
        } else if (!partnerCustomerSegment.equals(other.partnerCustomerSegment))
            return false;
        if (phones == null) {
            if (other.phones != null)
                return false;
        } else if (!phones.equals(other.phones))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerProfile [cutomerProfileId=" + customerProfileId + ", customerType=" + customerType
                + ", customerSegment=" + customerSegment + ", partnerCustomerSegment=" + partnerCustomerSegment
                + ", clientId=" + clientId + ", customerParticulars=" + customerParticulars + ", emails=" + emails
                + ", addressList=" + addressList + ", phones=" + phones + "]";
    }
    
    

}

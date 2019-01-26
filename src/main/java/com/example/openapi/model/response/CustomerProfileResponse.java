/**
 * 
 */
package com.example.openapi.model.response;

import java.io.Serializable;
import java.util.List;

import com.example.openapi.model.Address;
import com.example.openapi.model.CustomerParticulars;
import com.example.openapi.model.Email;
import com.example.openapi.model.Phone;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 86211
 *
 */
public class CustomerProfileResponse implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5817652016285033229L;

    @JsonProperty("emails")
    private List<Email> emails;
    
    @JsonProperty("customerType")
    private String customerType;
    
    @JsonProperty("customerParticulars")
    private CustomerParticulars customerParticulars;
    
    @ApiModelProperty(required = true, value = "Type of the customer. This is applicable only for Individual customers.This is a reference data field. Please use \\/v1\\/apac\\/utilities\\/referenceData\\/{customerSegment} resource to get valid value of this field with description. You can use customerSegment as the referenceCode parameter to retrieve the values.")
    @JsonProperty("customerSegment")
    private String customerSegment;
    
    @JsonProperty("partnerCustomerSegment")
    private String partnerCustomerSegment;
    
    @JsonProperty("addressList")
    private List<Address> addressList;
    
    @JsonProperty("phones")
    private List<Phone> phones;

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public CustomerParticulars getCustomerParticulars() {
        return customerParticulars;
    }

    public void setCustomerParticulars(CustomerParticulars customerParticulars) {
        this.customerParticulars = customerParticulars;
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
        result = prime * result + ((customerParticulars == null) ? 0 : customerParticulars.hashCode());
        result = prime * result + ((customerSegment == null) ? 0 : customerSegment.hashCode());
        result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
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
        CustomerProfileResponse other = (CustomerProfileResponse) obj;
        if (addressList == null) {
            if (other.addressList != null)
                return false;
        } else if (!addressList.equals(other.addressList))
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
        return "CustomerProfileResponse [emails=" + emails + ", customerType=" + customerType + ", customerParticulars="
                + customerParticulars + ", customerSegment=" + customerSegment + ", partnerCustomerSegment="
                + partnerCustomerSegment + ", addressList=" + addressList + ", phones=" + phones + "]";
    }
    
    
}

/**
 * 
 */
package com.example.openapi.model.response;

import java.io.Serializable;

import com.example.openapi.model.CustomerParticulars;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 86211
 *
 */
public class CustomerParticularsResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8343339333537611352L;

    @JsonProperty("customerType")
    private String customerType;

    @JsonProperty("customerParticulars")
    private CustomerParticulars customerParticulars;

    @JsonProperty("customerSegment")
    private String customerSegment;

    @JsonProperty("partnerCustomerSegment")
    private String partnerCustomerSegment;


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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerParticulars == null) ? 0 : customerParticulars.hashCode());
        result = prime * result + ((customerSegment == null) ? 0 : customerSegment.hashCode());
        result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
        result = prime * result + ((partnerCustomerSegment == null) ? 0 : partnerCustomerSegment.hashCode());
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
        CustomerParticularsResponse other = (CustomerParticularsResponse) obj;
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
        if (partnerCustomerSegment == null) {
            if (other.partnerCustomerSegment != null)
                return false;
        } else if (!partnerCustomerSegment.equals(other.partnerCustomerSegment))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerParticularsResponse [customerType=" + customerType + ", customerParticulars="
                + customerParticulars + ", customerSegment=" + customerSegment + ", partnerCustomerSegment="
                + partnerCustomerSegment + "]";
    }

}

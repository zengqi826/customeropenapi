/**
 * 
 */
package com.example.openapi.model.request;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.example.openapi.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 86211
 *
 */
public class CustomerAddressUpdateRequest {

    @NotNull
    @JsonProperty("addresses")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customerAddressUpdateRequest")
    private List<Address> address;

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
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
        CustomerAddressUpdateRequest other = (CustomerAddressUpdateRequest) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerAddressUpdateRequest [address=" + address + "]";
    }
    
    
}

/**
 * 
 */
package com.example.openapi.model.response;

import java.io.Serializable;
import java.util.List;

import com.example.openapi.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 86211
 *
 */

public class CustomerAddressResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9194931237944449970L;

    @JsonProperty("addressList")
    private List<Address> addressList;

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addressList == null) ? 0 : addressList.hashCode());
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
        CustomerAddressResponse other = (CustomerAddressResponse) obj;
        if (addressList == null) {
            if (other.addressList != null)
                return false;
        } else if (!addressList.equals(other.addressList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerAddressResponse [addressList=" + addressList + "]";
    }

}

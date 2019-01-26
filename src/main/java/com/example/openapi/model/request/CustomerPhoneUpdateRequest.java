/**
 * 
 */
package com.example.openapi.model.request;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.example.openapi.model.Phone;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 86211
 *
 */
public class CustomerPhoneUpdateRequest {
    
    @NotNull
    @JsonProperty("phones")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customerPhoneUpdateRequest")
    private List<Phone> phones;

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
        CustomerPhoneUpdateRequest other = (CustomerPhoneUpdateRequest) obj;
        if (phones == null) {
            if (other.phones != null)
                return false;
        } else if (!phones.equals(other.phones))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerPhoneUpdateRequest [phones=" + phones + "]";
    }
    

}

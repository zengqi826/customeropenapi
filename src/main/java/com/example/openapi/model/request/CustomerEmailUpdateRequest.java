/**
 * 
 */
package com.example.openapi.model.request;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.example.openapi.model.Email;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 86211
 *
 */
public class CustomerEmailUpdateRequest {

    @NotNull
    @JsonProperty("emails")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customerEmailUpdateRequest")
    private List<Email> emails;

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((emails == null) ? 0 : emails.hashCode());
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
        CustomerEmailUpdateRequest other = (CustomerEmailUpdateRequest) obj;
        if (emails == null) {
            if (other.emails != null)
                return false;
        } else if (!emails.equals(other.emails))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerEmailUpdateRequest [emails=" + emails + "]";
    }

    
    
}

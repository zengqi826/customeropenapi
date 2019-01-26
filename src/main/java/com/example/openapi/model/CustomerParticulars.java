/**
 * 
 */
package com.example.openapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 86211
 *
 */
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerParticulars implements Serializable{


    
    /**
     * 
     */
    private static final long serialVersionUID = -1102111467342199793L;

    @JsonProperty("names")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customerProfile")
    private List<Name> names;
    
    @JsonProperty("gender")
    @Column(name = "gender")
    private String gender;
    
    @JsonProperty("prefix")
    @Column(name = "prefix")
    private String prefix;
    
    @JsonProperty("suffix")
    @Column(name = "suffix")
    private String suffix;

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((names == null) ? 0 : names.hashCode());
        result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
        result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
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
        CustomerParticulars other = (CustomerParticulars) obj;
        if (gender == null) {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        if (names == null) {
            if (other.names != null)
                return false;
        } else if (!names.equals(other.names))
            return false;
        if (prefix == null) {
            if (other.prefix != null)
                return false;
        } else if (!prefix.equals(other.prefix))
            return false;
        if (suffix == null) {
            if (other.suffix != null)
                return false;
        } else if (!suffix.equals(other.suffix))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerParticulars [ names=" + names + ", gender=" + gender + ", prefix=" + prefix + ", suffix="
                + suffix + "]";
    }


    
}

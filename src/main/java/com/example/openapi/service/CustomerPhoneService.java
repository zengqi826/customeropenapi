/**
 * 
 */
package com.example.openapi.service;

import java.util.List;
import java.util.Optional;

import com.example.openapi.model.Phone;

/**
 * @author 86211
 *
 */
public interface CustomerPhoneService {
    Optional<List<Phone>> getCustomerPhonesByClientId(String clientId);
    
    void savePhonesByClientId(List<Phone> phonesList);
}

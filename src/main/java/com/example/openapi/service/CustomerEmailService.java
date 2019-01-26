/**
 * 
 */
package com.example.openapi.service;

import java.util.List;
import java.util.Optional;

import com.example.openapi.model.Email;

/**
 * @author 86211
 *
 */
public interface CustomerEmailService {
    Optional<List<Email>> getCustomerEmailsByClientId(String clientId);

    void saveEmailsByClientId(List<Email> emailsList);
}

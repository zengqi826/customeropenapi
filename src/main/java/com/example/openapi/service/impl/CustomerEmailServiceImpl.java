/**
 * 
 */
package com.example.openapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.openapi.model.Email;
import com.example.openapi.repository.CustomerEmailRepository;
import com.example.openapi.service.CustomerEmailService;

/**
 * @author 86211
 *
 */
@Service
public class CustomerEmailServiceImpl implements CustomerEmailService {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.example.openapi.service.CustomerEmailService#getCustomerEmailsByClientId(
     * java.lang.String)
     */
    @Autowired
    CustomerEmailRepository customerEmailRepository;

    @Override
    public Optional<List<Email>> getCustomerEmailsByClientId(String clientId) {
        return customerEmailRepository.findByClientId(clientId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.example.openapi.service.CustomerEmailService#saveEmailsByClientId(java.
     * util.List)
     */
    @Override
    public void saveEmailsByClientId(List<Email> emailsList) {
        customerEmailRepository.saveAll(emailsList);

    }

}

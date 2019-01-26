/**
 * 
 */
package com.example.openapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.openapi.model.CustomerProfile;

/**
 * @author 86211
 *
 */
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {
    CustomerProfile findByClientId(String clientId);

}

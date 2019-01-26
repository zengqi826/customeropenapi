/**
 * 
 */
package com.example.openapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.openapi.model.Email;
import com.example.openapi.model.EmailIdentity;

/**
 * @author 86211
 *
 */
public interface CustomerEmailRepository extends JpaRepository<Email,EmailIdentity> {
    @Query(value="select * FROM customer_email WHERE CLIENT_ID=?1" ,nativeQuery=true)
    Optional<List<Email>> findByClientId(String clientId);
    
}

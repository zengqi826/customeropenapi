/**
 * 
 */
package com.example.openapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.openapi.model.Phone;
import com.example.openapi.model.PhoneIdentity;

/**
 * @author 86211
 *
 */
public interface CustomerPhoneRepository extends JpaRepository<Phone,PhoneIdentity> {
    @Query(value="select * FROM customer_phone WHERE CLIENT_ID=?1" ,nativeQuery=true)
    Optional<List<Phone>> findByClientId(String clientId);
    
}

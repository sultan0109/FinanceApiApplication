package com.example.Finance_api.repo;

import com.example.Finance_api.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByUsername(String username);
    boolean existsUserByUsername(String username);


        @Lock(LockModeType.PESSIMISTIC_WRITE)
        @Query("select u from UserInfo u where u.id = :id")
        Optional<UserInfo> findByIdForUpdate(@Param("id") Long id);


}


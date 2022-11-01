package com.Luckystar.UserManagement.ports;

import com.Luckystar.UserManagement.business.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,String>, QuerydslPredicateExecutor<UserEntity> {
    List<UserEntity> findByMacId(String macId);
}

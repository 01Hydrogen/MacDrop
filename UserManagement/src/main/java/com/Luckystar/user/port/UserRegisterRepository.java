package com.Luckystar.user.port;

import com.Luckystar.user.business.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRegisterRepository extends JpaRepository<UserEntity,String>, QuerydslPredicateExecutor<UserEntity> {
}

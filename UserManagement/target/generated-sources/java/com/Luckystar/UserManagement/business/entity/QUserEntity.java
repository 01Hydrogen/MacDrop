package com.Luckystar.UserManagement.business.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = 1812847498L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final StringPath emailAddress = createString("emailAddress");

    public final StringPath id = createString("id");

    public final StringPath macId = createString("macId");

    public final NumberPath<Double> MMD = createNumber("MMD", Double.class);

    public final StringPath password = createString("password");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final StringPath username = createString("username");

    public QUserEntity(String variable) {
        super(UserEntity.class, forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata metadata) {
        super(UserEntity.class, metadata);
    }

}


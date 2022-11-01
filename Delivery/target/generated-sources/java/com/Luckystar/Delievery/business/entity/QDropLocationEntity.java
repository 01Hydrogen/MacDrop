package com.Luckystar.Delievery.business.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDropLocationEntity is a Querydsl query type for DropLocationEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDropLocationEntity extends EntityPathBase<DropLocationEntity> {

    private static final long serialVersionUID = 2025360150L;

    public static final QDropLocationEntity dropLocationEntity = new QDropLocationEntity("dropLocationEntity");

    public final StringPath id = createString("id");

    public final StringPath locationName = createString("locationName");

    public QDropLocationEntity(String variable) {
        super(DropLocationEntity.class, forVariable(variable));
    }

    public QDropLocationEntity(Path<? extends DropLocationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDropLocationEntity(PathMetadata metadata) {
        super(DropLocationEntity.class, metadata);
    }

}


package com.Luckystar.Delievery.business.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDeliveryEntity is a Querydsl query type for DeliveryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDeliveryEntity extends EntityPathBase<DeliveryEntity> {

    private static final long serialVersionUID = 1415278278L;

    public static final QDeliveryEntity deliveryEntity = new QDeliveryEntity("deliveryEntity");

    public final StringPath bikerId = createString("bikerId");

    public final StringPath cartItems = createString("cartItems");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> deliveredTime = createDateTime("deliveredTime", java.util.Date.class);

    public final StringPath deliverLocation = createString("deliverLocation");

    public final StringPath deliverTimeSlot = createString("deliverTimeSlot");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath studentId = createString("studentId");

    public final NumberPath<Double> totalPrice = createNumber("totalPrice", Double.class);

    public QDeliveryEntity(String variable) {
        super(DeliveryEntity.class, forVariable(variable));
    }

    public QDeliveryEntity(Path<? extends DeliveryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDeliveryEntity(PathMetadata metadata) {
        super(DeliveryEntity.class, metadata);
    }

}


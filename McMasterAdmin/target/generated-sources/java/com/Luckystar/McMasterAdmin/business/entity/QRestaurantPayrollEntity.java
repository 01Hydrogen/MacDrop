package com.Luckystar.McMasterAdmin.business.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRestaurantPayrollEntity is a Querydsl query type for RestaurantPayrollEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurantPayrollEntity extends EntityPathBase<RestaurantPayrollEntity> {

    private static final long serialVersionUID = 2106412342L;

    public static final QRestaurantPayrollEntity restaurantPayrollEntity = new QRestaurantPayrollEntity("restaurantPayrollEntity");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final BooleanPath approved = createBoolean("approved");

    public final StringPath id = createString("id");

    public final BooleanPath MDDChecked = createBoolean("MDDChecked");

    public final StringPath menuName = createString("menuName");

    public final StringPath orderId = createString("orderId");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final StringPath restaurantId = createString("restaurantId");

    public final StringPath studentId = createString("studentId");

    public final NumberPath<Double> totalPrice = createNumber("totalPrice", Double.class);

    public QRestaurantPayrollEntity(String variable) {
        super(RestaurantPayrollEntity.class, forVariable(variable));
    }

    public QRestaurantPayrollEntity(Path<? extends RestaurantPayrollEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRestaurantPayrollEntity(PathMetadata metadata) {
        super(RestaurantPayrollEntity.class, metadata);
    }

}


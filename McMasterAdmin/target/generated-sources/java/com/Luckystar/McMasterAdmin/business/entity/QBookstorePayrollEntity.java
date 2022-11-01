package com.Luckystar.McMasterAdmin.business.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookstorePayrollEntity is a Querydsl query type for BookstorePayrollEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookstorePayrollEntity extends EntityPathBase<BookstorePayrollEntity> {

    private static final long serialVersionUID = -1707249851L;

    public static final QBookstorePayrollEntity bookstorePayrollEntity = new QBookstorePayrollEntity("bookstorePayrollEntity");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath id = createString("id");

    public final BooleanPath paid = createBoolean("paid");

    public final NumberPath<Double> revenue = createNumber("revenue", Double.class);

    public QBookstorePayrollEntity(String variable) {
        super(BookstorePayrollEntity.class, forVariable(variable));
    }

    public QBookstorePayrollEntity(Path<? extends BookstorePayrollEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookstorePayrollEntity(PathMetadata metadata) {
        super(BookstorePayrollEntity.class, metadata);
    }

}


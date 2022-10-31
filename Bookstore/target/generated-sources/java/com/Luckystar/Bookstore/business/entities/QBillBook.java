package com.Luckystar.Bookstore.business.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBillBook is a Querydsl query type for BillBook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBillBook extends EntityPathBase<BillBook> {

    private static final long serialVersionUID = 1594047782L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBillBook billBook = new QBillBook("billBook");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final BooleanPath checked = createBoolean("checked");

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final StringPath Id = createString("Id");

    public final QItem item;

    public QBillBook(String variable) {
        this(BillBook.class, forVariable(variable), INITS);
    }

    public QBillBook(Path<? extends BillBook> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBillBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBillBook(PathMetadata metadata, PathInits inits) {
        this(BillBook.class, metadata, inits);
    }

    public QBillBook(Class<? extends BillBook> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.item = inits.isInitialized("item") ? new QItem(forProperty("item")) : null;
    }

}


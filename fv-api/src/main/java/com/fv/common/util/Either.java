package com.fv.common.util;

import org.springframework.validation.Errors;

public class Either<T> {
    private final T entity;
    private final Errors errors;

    public Either(T entity, Errors errors) {
        this.entity = entity;
        this.errors = errors;
    }

    public static <T> Either<T> buildEntity(T entity) {
        return new Either<>(entity, null);
    }

    public static <T> Either<T> buildErrors(Errors errors) {
        return new Either<>(null, errors);
    }

    public boolean hasResult() {
        return errors == null;
    }

    public boolean hasErrors() {
        return !hasResult();
    }

    public Errors getErrors() {
        return errors;
    }

    public T getEntity() {
        return entity;
    }

}

package org.ohdsi.webapi.check.validator.common;

import org.ohdsi.webapi.check.validator.Validator;

import java.util.function.Predicate;

public class PredicateValidator<T> extends Validator<T> {
    private static final String INVALID = "%s - invalid";

    private Predicate<T> predicate;

    public PredicateValidator() {
    }

    public PredicateValidator setPredicate(Predicate<T> predicate) {
        this.predicate = predicate;
        return this;
    }

    @Override
    public boolean validate(T value) {
        boolean isValid = predicate.test(value);
        if (!isValid) {
            fillErrorReport();
        }
        return isValid;
    }

    protected String getDefaultErrorTemplate() {
        return INVALID;
    }
}

package com.joe.springbootmedium.form;

public interface FormConver<S,T> {
    T convert(S s);
}

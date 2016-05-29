package com.akos.models;


/**
 * Created by Ákos on 2016.4.02.
 * Email: akoshervay@gmail.com
 */

/*
    Interface to differentiate models, which have parameters,
    that need to be validated on input.
 */
public interface Validatable {

    /*
        return boolean;
     */
    boolean validate();
}

package org.kset.brucx.exceptions.handlers;

/**
 * Used when some requested resource or method cannot be found.
 * Created by marin on 19.12.2016..
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Requested resource cannot be found");
    }

}

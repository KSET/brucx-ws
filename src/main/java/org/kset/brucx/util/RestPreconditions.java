package org.kset.brucx.util;

import org.kset.brucx.exceptions.handlers.ResourceNotFoundException;

/**
 * Utility class for testing common rest preconditions
 * Created by marin on 19.12.2016..
 */
public class RestPreconditions {

    /**
     * Checks if resource exists aka it isn't null.
     * @param resource resource whose existence is being checked
     * @param <T> resource type
     * @return resource object
     * @throws ResourceNotFoundException if given resource is null
     */
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }
}

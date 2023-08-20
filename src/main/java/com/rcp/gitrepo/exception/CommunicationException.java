package com.rcp.gitrepo.exception;

/**
 * The class represent exception thrown incase of a Communication Problem with Git api
 */
public class CommunicationException extends RuntimeException {

    public CommunicationException(String message) {
        super(message);
    }

}

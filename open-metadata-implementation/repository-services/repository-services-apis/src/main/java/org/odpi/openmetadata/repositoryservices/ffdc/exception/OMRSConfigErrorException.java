/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.repositoryservices.ffdc.exception;

/**
 * OMRSConfigErrorException is used for all runtime exceptions generated by the Open Metadata Repository Services (OMRS)
 * components that indicate a configuration error.
 * It is used in conjunction with the OMRSErrorCode to provide first failure data capture for these errors.
 */
public class OMRSConfigErrorException extends OMRSRuntimeException
{
    /*
     * These default values are only seen if this exception is initialized using one of its superclass constructors.
     */
    private int          reportedHTTPCode = 500;
    private String       reportingClassName = "<Unknown>";
    private String       reportingActionDescription = "<Unknown>";
    private String       reportedErrorMessage = "<Unknown>";
    private String       reportedSystemAction = "<Unknown>";
    private String       reportedUserAction = "<Unknown>";
    private Throwable [] reportedCaughtExceptions = null;


    /**
     * This is the typical constructor used for creating an OMRSConfigErrorException.
     *
     * @param httpCode  http response code to use if this exception flows over a REST call
     * @param className  name of class reporting error
     * @param actionDescription  description of function it was performing when error detected
     * @param errorMessage  description of error
     * @param systemAction  actions of the system as a result of the error
     * @param userAction  instructions for correcting the error
     */
    public OMRSConfigErrorException(int  httpCode, String className, String  actionDescription, String errorMessage, String systemAction, String userAction)
    {
        super(httpCode, className, actionDescription, errorMessage, systemAction, userAction);

        this.reportedHTTPCode = httpCode;
        this.reportingClassName = className;
        this.reportingActionDescription = actionDescription;
        this.reportedErrorMessage = errorMessage;
        this.reportedSystemAction = systemAction;
        this.reportedUserAction = userAction;
    }


    /**
     * This is the constructor used for creating a OMRSConfigErrorException when an unexpected exception has been caught.
     *
     * @param httpCode  http response code to use if this exception flows over a REST call
     * @param className  name of class reporting error
     * @param actionDescription  description of function it was performing when error detected
     * @param errorMessage  description of error
     * @param systemAction  actions of the system as a result of the error
     * @param userAction  instructions for correcting the error
     * @param caughtError  previous error causing this exception
     */
    public OMRSConfigErrorException(int  httpCode, String className, String  actionDescription, String errorMessage, String systemAction, String userAction, Throwable caughtError)
    {
        super(httpCode, className, actionDescription, errorMessage, systemAction, userAction, caughtError);

        this.reportedHTTPCode = httpCode;
        this.reportingClassName = className;
        this.reportingActionDescription = actionDescription;
        this.reportedErrorMessage = errorMessage;
        this.reportedSystemAction = systemAction;
        this.reportedUserAction = userAction;
        this.reportedCaughtExceptions = new Throwable[1];
        this.reportedCaughtExceptions[0] = caughtError;
    }

    /**
     * This is the constructor used for creating a OMRSConfigErrorException when multiple unexpected errors
     * have been caught.
     *
     * @param httpCode  http response code to use if this exception flows over a rest call
     * @param className  name of class reporting error
     * @param actionDescription  description of function it was performing when error detected
     * @param errorMessage  description of error
     * @param systemAction  actions of the system as a result of the error
     * @param userAction  instructions for correcting the error
     * @param caughtErrors  previous errors causing this exception
     */
    public OMRSConfigErrorException(int  httpCode, String className, String  actionDescription, String errorMessage, String systemAction, String userAction, Throwable[] caughtErrors)
    {
        super(httpCode, className, actionDescription, errorMessage, systemAction, userAction, caughtErrors);

        this.reportedHTTPCode = httpCode;
        this.reportingClassName = className;
        this.reportingActionDescription = actionDescription;
        this.reportedErrorMessage = errorMessage;
        this.reportedSystemAction = systemAction;
        this.reportedUserAction = userAction;
        this.reportedCaughtExceptions = caughtErrors;
    }

    /**
     * Return the HTTP response code to use with this exception.
     *
     * @return reportedHTTPCode
     */
    public int getReportedHTTPCode()
    {
        return reportedHTTPCode;
    }

    /**
     * The class that created this exception.
     *
     * @return reportingClassName
     */
    public String getReportingClassName()
    {
        return reportingClassName;
    }


    /**
     * The type of request that the class was performing when the condition occurred that resulted in this
     * exception.
     *
     * @return reportingActionDescription
     */
    public String getReportingActionDescription()
    {
        return reportingActionDescription;
    }


    /**
     * A formatted short description of the cause of the condition that resulted in this exception.
     *
     * @return reportedErrorMessage
     */
    public String getErrorMessage()
    {
        return reportedErrorMessage;
    }


    /**
     * A description of the action that the system took as a result of the error condition.
     *
     * @return reportedSystemAction
     */
    public String getReportedSystemAction()
    {
        return reportedSystemAction;
    }


    /**
     * A description of the action necessary to correct the error.
     *
     * @return reportedUserAction
     */
    public String getReportedUserAction()
    {
        return reportedUserAction;
    }


    /**
     * An exception that was caught and wrapped by this exception.  If a null is returned, then this exception is
     * newly created and not the result of a previous exception.
     *
     * @return reportedCaughtException
     */
    public Throwable[] getReportedCaughtExceptions() { return reportedCaughtExceptions; }
}

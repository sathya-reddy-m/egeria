/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.viewservices.dino.api.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;


@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class DinoPlatformRequestBody {


    /*
     * The DinoPlatformRequestBody class provides a body for REST requests to the platform-oriented Dino REST APIs
     */

    private String                    platformName;                    // must be non-null



    public DinoPlatformRequestBody() {
       // No initialization yet
    }

    /*
     * Getters for Jackson
     */

    public String getPlatformName() { return platformName; }

    public void setPlatformName(String platformName) { this.platformName = platformName; }
    

    @Override
    public String toString()
    {
        return "DinoPlatformRequestBody{" +
                ", platformName=" + platformName +
                '}';
    }



}

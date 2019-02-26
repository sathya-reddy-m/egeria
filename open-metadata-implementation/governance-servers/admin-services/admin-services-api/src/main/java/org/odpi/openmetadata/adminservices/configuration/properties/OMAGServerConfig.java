/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adminservices.configuration.properties;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * OMAGServerConfig provides the properties used to initialize an open metadata and governance (OMAG) server.
 *
 * The OMAG server configuration has the following basic properties, plus configuration for the subsystems
 * that should be activated in the OMAG Server:
 * <ul>
 *     <li>
 *         localServerId - Unique identifier for this server.
 *
 *         By default, this is initialized to a randomly generated Universal Unique identifier (UUID).
 *     </li>
 *     <li>
 *         localServerName - meaningful name for the server for use in messages and UIs.
 *         Ideally this value is unique to aid administrators in understanding the source of messages and events
 *         from the server.
 *
 *         This value is set to the server name assigned when the configuration is created.
 *     </li>
 *     <li>
 *         localServerType - descriptive type name for the server.  Again this is useful information for the
 *         administrator to understand the role of the server.
 *
 *         The default value is "Open Metadata and Governance Server".
 *     </li>
 *     <li>
 *         organizationName - descriptive name for the organization that owns the local server/repository.
 *         This is useful when the open metadata repository cluster consists of metadata servers from different
 *         organizations, or different departments of an enterprise.
 *
 *         The default value is null.
 *     </li>
 *     <li>
 *         localServerURL - network address of the OMAG server platform where this server runs
 *         (typically host and port number but may also include the initial part of the URL before "open-metadata").
 *
 *         The default value is "http://localhost:8080".
 *     </li>
 *     <li>
 *         localServerUserId - UserId to use for server initiated REST calls.
 *
 *         The default is "OMAGServer".
 *     </li>
 *     <li>
 *         maxPageSize - the maximum page size that can be set on requests to the server.
 *
 *         The default value is 1000.
 *     </li>
 * </ul>
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class OMAGServerConfig extends AdminServicesConfigHeader
{
    /*
     * Default values used when the server configuration does not provide a value.
     */
    private static final String  defaultLocalServerType                   = "Open Metadata and Governance Server";
    private static final String  defaultLocalOrganizationName             = null;
    private static final String  defaultLocalServerURL                    = "http://localhost:8080";
    private static final String  defaultLocalServerUserId                 = "OMAGServer";
    private static final int     defaultMaxPageSize                       = 1000;


    /*
     * Values in use by this server.
     */
    private String                    localServerId             = UUID.randomUUID().toString();
    private String                    localServerName           = null;
    private String                    localServerType           = defaultLocalServerType;
    private String                    organizationName          = defaultLocalOrganizationName;
    private String                    localServerURL            = defaultLocalServerURL;
    private String                    localServerUserId         = defaultLocalServerUserId;
    private int                       maxPageSize               = defaultMaxPageSize;
    private EventBusConfig            eventBusConfig            = null;
    private List<AccessServiceConfig> accessServicesConfig      = null;
    private RepositoryServicesConfig  repositoryServicesConfig  = null;
    private DiscoveryEngineConfig     discoveryEngineConfig     = null;
    private StewardshipServicesConfig stewardshipServicesConfig = null;
    private SecuritySyncConfig        securitySyncConfig        = null;
    private List<String>              auditTrail                = null;
    private VirtualizationConfig virtualizationConfig = null;


    /**
     * Default constructor.
     */
    public OMAGServerConfig()
    {
        super();
    }


    /**
     * Copy/clone constructor.
     */
    public OMAGServerConfig(OMAGServerConfig  template)
    {
        super(template);

        if (template != null)
        {
            localServerId = template.getLocalServerId();
            localServerName = template.getLocalServerName();
            localServerType = template.getLocalServerType();
            organizationName = template.getOrganizationName();
            localServerURL = template.getLocalServerURL();
            localServerUserId = template.getLocalServerUserId();
            maxPageSize = template.getMaxPageSize();
            eventBusConfig = template.getEventBusConfig();
            accessServicesConfig = template.getAccessServicesConfig();
            repositoryServicesConfig = template.getRepositoryServicesConfig();
            discoveryEngineConfig = template.getDiscoveryEngineConfig();
            stewardshipServicesConfig = template.getStewardshipServicesConfig();
            securitySyncConfig = template.getSecuritySyncConfig();
            auditTrail = template.getAuditTrail();
            virtualizationConfig = template.getVirtualizationConfig();
        }
    }


    /**
     * Return an unique identifier for this server.
     *
     * @return string guid
     */
    public String getLocalServerId()
    {
        return localServerId;
    }


    /**
     * Set up a unique identifier for this server.
     *
     * @param localServerId string guid
     */
    public void setLocalServerId(String localServerId)
    {
        this.localServerId = localServerId;
    }


    /**
     * Return the name of the local server.
     *
     * @return String server name
     */
    public String getLocalServerName()
    {
        return localServerName;
    }


    /**
     * Set up the name of the local server.
     *
     * @param localServerName String local server name
     */
    public void setLocalServerName(String localServerName)
    {
        this.localServerName = localServerName;
    }


    /**
     * Return the descriptive name for the server type.
     *
     * @return String server type
     */
    public String getLocalServerType()
    {
        return localServerType;
    }


    /**
     * Set up the descriptive name for the server type.
     *
     * @param localServerType String server type
     */
    public void setLocalServerType(String localServerType)
    {
        this.localServerType = localServerType;
    }


    /**
     * Return the name of the organization that is running the server.
     *
     * @return String organization name
     */
    public String getOrganizationName()
    {
        return organizationName;
    }


    /**
     * Set up the name of the organization that is running the server.
     *
     * @param organizationName String organization name
     */
    public void setOrganizationName(String organizationName)
    {
        this.organizationName = organizationName;
    }


    /**
     * Return the base URL for calling the local server.
     *
     * @return String URL
     */
    public String getLocalServerURL()
    {
        return localServerURL;
    }


    /**
     * Set up the base URL for calling the local server.
     *
     * @param localServerURL String URL
     */
    public void setLocalServerURL(String localServerURL)
    {
        this.localServerURL = localServerURL;
    }


    /**
     * Return the userId that the local server should use when processing events and there is no external user
     * driving the operation.
     *
     * @return user id
     */
    public String getLocalServerUserId()
    {
        return localServerUserId;
    }


    /**
     * Set up the userId that the local server should use when processing events and there is no external user
     * driving the operation.
     *
     * @param localServerUserId string user id
     */
    public void setLocalServerUserId(String localServerUserId)
    {
        this.localServerUserId = localServerUserId;
    }


    /**
     * Return the maximum page size supported by this server.
     *
     * @return int number of elements
     */
    public int getMaxPageSize()
    {
        return maxPageSize;
    }


    /**
     * Set up the  maximum page size supported by this server.
     *
     * @param maxPageSize int number of elements
     */
    public void setMaxPageSize(int maxPageSize)
    {
        this.maxPageSize = maxPageSize;
    }


    /**
     * Set up the information used to create connections to an event bus.
     *
     * @return EventBusConfig object
     */
    public EventBusConfig getEventBusConfig()
    {
        return eventBusConfig;
    }


    /**
     * Set up the information used to create connections to an event bus.
     *
     * @param eventBusConfig EventBusConfig object
     */
    public void setEventBusConfig(EventBusConfig eventBusConfig)
    {
        this.eventBusConfig = eventBusConfig;
    }

    /**
     * Return the configuration for the registered Open Metadata Access Services (OMAS).
     *
     * @return array of configuration properties one for each OMAS
     */
    public List<AccessServiceConfig> getAccessServicesConfig()
    {
        return accessServicesConfig;
    }


    /**
     * Set up the configuration for the registered Open Metadata Access Services (OMAS).
     *
     * @param accessServicesConfig array of configuration properties one for each OMAS
     */
    public void setAccessServicesConfig(List<AccessServiceConfig> accessServicesConfig)
    {
        this.accessServicesConfig = accessServicesConfig;
    }


    /**
     * Return the Open Metadata Repository Services (OMRS) config.
     *
     * @return configuration properties that control OMRS
     */
    public RepositoryServicesConfig getRepositoryServicesConfig()
    {
        return repositoryServicesConfig;
    }


    /**
     * Set up the Open Metadata Repository Services (OMRS) config.
     *
     * @param repositoryServicesConfig configuration properties that control OMRS
     */
    public void setRepositoryServicesConfig(RepositoryServicesConfig repositoryServicesConfig)
    {
        this.repositoryServicesConfig = repositoryServicesConfig;
    }


    /**
     * Return the configuration for a discovery engine.
     *
     * @return DiscoveryEngineConfig properties
     */
    public DiscoveryEngineConfig getDiscoveryEngineConfig()
    {
        return discoveryEngineConfig;
    }


    /**
     * Set up the configuration for a discovery engine.
     *
     * @param discoveryEngineConfig DiscoveryEngineConfig properties
     */
    public void setDiscoveryEngineConfig(DiscoveryEngineConfig discoveryEngineConfig)
    {
        this.discoveryEngineConfig = discoveryEngineConfig;
    }


    /**
     * Return the configuration for the stewardship services in a server.
     *
     * @return StewardshipServicesConfig properties
     */
    public StewardshipServicesConfig getStewardshipServicesConfig()
    {
        return stewardshipServicesConfig;
    }


    /**
     * Set up the configuration for the stewardship services in a server.
     *
     * @param stewardshipServicesConfig StewardshipServicesConfig properties
     */
    public void setStewardshipServicesConfig(StewardshipServicesConfig stewardshipServicesConfig)
    {
        this.stewardshipServicesConfig = stewardshipServicesConfig;
    }


    /**
     * Return the configuration for the security synchronization services.
     *
     * @return SecuritySyncConfig properties
     */
    public SecuritySyncConfig getSecuritySyncConfig()
    {
        return securitySyncConfig;
    }


    /**
     * Set up the configuration for the security synchronization services.
     *
     * @param securitySyncConfig SecuritySyncConfig properties
     */
    public void setSecuritySyncConfig(SecuritySyncConfig securitySyncConfig)
    {
        this.securitySyncConfig = securitySyncConfig;
    }


    /**
     * Return the list of audit log entries associated with this config file.
     * The audit log simply keep track of the changed to the configuration.
     *
     * @return list of audit messages
     */
    public List<String> getAuditTrail()
    {
        return auditTrail;
    }


    /**
     * Set up the audit log messages.
     *
     * @param auditTrail list of audit messages
     */
    public void setAuditTrail(List<String> auditTrail)
    {
        this.auditTrail = auditTrail;
    }

    /**
     * Return the configuration for the virtualization services.
     *
     * @return VirtualizationConfig properties
     */
    public VirtualizationConfig getVirtualizationConfig() {
        return virtualizationConfig;
    }

    /**
     * Set up the configuration for the virtualization services.
     *
     * @param virtualizationConfig properties
     */
    public void setVirtualizationConfig(VirtualizationConfig virtualizationConfig) {
        this.virtualizationConfig = virtualizationConfig;
    }


    /**
     * Standard toString method.
     *
     * @return JSON style description of variables.
     */
    @Override
    public String toString()
    {
        return "OMAGServerConfig{" +
                "localServerId='" + localServerId + '\'' +
                ", localServerName='" + localServerName + '\'' +
                ", localServerType='" + localServerType + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", localServerURL='" + localServerURL + '\'' +
                ", localServerUserId='" + localServerUserId + '\'' +
                ", maxPageSize=" + maxPageSize +
                ", eventBusConfig=" + eventBusConfig +
                ", accessServicesConfig=" + accessServicesConfig +
                ", repositoryServicesConfig=" + repositoryServicesConfig +
                ", discoveryEngineConfig=" + discoveryEngineConfig +
                ", stewardshipServicesConfig=" + stewardshipServicesConfig +
                ", securitySyncConfig=" + securitySyncConfig +
                ", auditTrail=" + auditTrail +
                '}';
    }


    /**
     * Validate that an object is equal depending on their stored values.
     *
     * @param objectToCompare object
     * @return boolean result
     */
    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare)
        {
            return true;
        }
        if (objectToCompare == null || getClass() != objectToCompare.getClass())
        {
            return false;
        }
        OMAGServerConfig that = (OMAGServerConfig) objectToCompare;
        return getMaxPageSize() == that.getMaxPageSize() &&
                Objects.equals(getLocalServerId(), that.getLocalServerId()) &&
                Objects.equals(getLocalServerName(), that.getLocalServerName()) &&
                Objects.equals(getLocalServerType(), that.getLocalServerType()) &&
                Objects.equals(getOrganizationName(), that.getOrganizationName()) &&
                Objects.equals(getLocalServerURL(), that.getLocalServerURL()) &&
                Objects.equals(getLocalServerUserId(), that.getLocalServerUserId()) &&
                Objects.equals(getEventBusConfig(), that.getEventBusConfig()) &&
                Objects.equals(getAccessServicesConfig(), that.getAccessServicesConfig()) &&
                Objects.equals(getRepositoryServicesConfig(), that.getRepositoryServicesConfig()) &&
                Objects.equals(getDiscoveryEngineConfig(), that.getDiscoveryEngineConfig()) &&
                Objects.equals(getStewardshipServicesConfig(), that.getStewardshipServicesConfig()) &&
                Objects.equals(getSecuritySyncConfig(), that.getSecuritySyncConfig()) &&
                Objects.equals(getVirtualizationConfig(), that.getVirtualizationConfig()) &&
                Objects.equals(getAuditTrail(), that.getAuditTrail());
    }


    /**
     * Return a hash code based on the values of this object.
     *
     * @return in hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(getLocalServerId(), getLocalServerName(), getLocalServerType(), getOrganizationName(),
                            getLocalServerURL(), getLocalServerUserId(), getMaxPageSize(), getEventBusConfig(),
                            getAccessServicesConfig(), getRepositoryServicesConfig(), getDiscoveryEngineConfig(),
                            getStewardshipServicesConfig(), getSecuritySyncConfig(), getAuditTrail(), getVirtualizationConfig());
    }
}

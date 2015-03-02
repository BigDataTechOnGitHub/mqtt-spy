//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.02 at 02:39:48 PM GMT 
//


package pl.baczkowicz.mqttspy.configuration.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Copyable;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.builder.CopyBuilder;
import org.jvnet.jaxb2_commons.lang.builder.JAXBCopyBuilder;
import org.jvnet.jaxb2_commons.lang.builder.JAXBEqualsBuilder;
import org.jvnet.jaxb2_commons.lang.builder.JAXBHashCodeBuilder;
import org.jvnet.jaxb2_commons.lang.builder.JAXBToStringBuilder;
import pl.baczkowicz.mqttspy.common.generated.ConnectionDetails;
import pl.baczkowicz.mqttspy.common.generated.PublicationDetails;


/**
 * <p>Java class for UserInterfaceMqttConnectionDetailsV010 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserInterfaceMqttConnectionDetailsV010">
 *   &lt;complexContent>
 *     &lt;extension base="{http://baczkowicz.pl/mqtt-spy/common}ConnectionDetails">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ServerURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserAuthentication" type="{http://baczkowicz.pl/mqtt-spy-configuration}UserAuthentication" minOccurs="0"/>
 *         &lt;element name="LastWillAndTestament" type="{http://baczkowicz.pl/mqtt-spy-configuration}BaseMqttMessage" minOccurs="0"/>
 *         &lt;element name="AutoOpen" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AutoConnect" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CleanSession" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ConnectionTimeout" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="KeepAliveInterval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Formatter" type="{http://www.w3.org/2001/XMLSchema}IDREF" minOccurs="0"/>
 *         &lt;element name="MinMessagesStoredPerTopic" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MaxMessagesStored" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PublicationScripts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Publication" type="{http://baczkowicz.pl/mqtt-spy/common}PublicationDetails" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Subscription" type="{http://baczkowicz.pl/mqtt-spy-configuration}TabbedSubscriptionDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserInterfaceMqttConnectionDetailsV010", propOrder = {
    "name",
    "serverURI",
    "clientID",
    "userAuthentication",
    "lastWillAndTestament",
    "autoOpen",
    "autoConnect",
    "cleanSession",
    "connectionTimeout",
    "keepAliveInterval",
    "formatter",
    "minMessagesStoredPerTopic",
    "maxMessagesStored",
    "publicationScripts",
    "publication",
    "subscription"
})
public class UserInterfaceMqttConnectionDetailsV010
    extends ConnectionDetails
    implements CopyTo, Copyable, Equals, HashCode, ToString
{

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ServerURI", required = true)
    protected String serverURI;
    @XmlElement(name = "ClientID", required = true)
    protected String clientID;
    @XmlElement(name = "UserAuthentication")
    protected UserAuthentication userAuthentication;
    @XmlElement(name = "LastWillAndTestament")
    protected BaseMqttMessage lastWillAndTestament;
    @XmlElement(name = "AutoOpen", defaultValue = "true")
    protected Boolean autoOpen;
    @XmlElement(name = "AutoConnect", defaultValue = "false")
    protected Boolean autoConnect;
    @XmlElement(name = "CleanSession")
    protected Boolean cleanSession;
    @XmlElement(name = "ConnectionTimeout")
    protected Integer connectionTimeout;
    @XmlElement(name = "KeepAliveInterval")
    protected Integer keepAliveInterval;
    @XmlElement(name = "Formatter")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object formatter;
    @XmlElement(name = "MinMessagesStoredPerTopic")
    protected Integer minMessagesStoredPerTopic;
    @XmlElement(name = "MaxMessagesStored")
    protected Integer maxMessagesStored;
    @XmlElement(name = "PublicationScripts")
    protected String publicationScripts;
    @XmlElement(name = "Publication")
    protected List<PublicationDetails> publication;
    @XmlElement(name = "Subscription")
    protected List<TabbedSubscriptionDetails> subscription;

    /**
     * Default no-arg constructor
     * 
     */
    public UserInterfaceMqttConnectionDetailsV010() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public UserInterfaceMqttConnectionDetailsV010(final String name, final String serverURI, final String clientID, final UserAuthentication userAuthentication, final BaseMqttMessage lastWillAndTestament, final Boolean autoOpen, final Boolean autoConnect, final Boolean cleanSession, final Integer connectionTimeout, final Integer keepAliveInterval, final Object formatter, final Integer minMessagesStoredPerTopic, final Integer maxMessagesStored, final String publicationScripts, final List<PublicationDetails> publication, final List<TabbedSubscriptionDetails> subscription) {
        this.name = name;
        this.serverURI = serverURI;
        this.clientID = clientID;
        this.userAuthentication = userAuthentication;
        this.lastWillAndTestament = lastWillAndTestament;
        this.autoOpen = autoOpen;
        this.autoConnect = autoConnect;
        this.cleanSession = cleanSession;
        this.connectionTimeout = connectionTimeout;
        this.keepAliveInterval = keepAliveInterval;
        this.formatter = formatter;
        this.minMessagesStoredPerTopic = minMessagesStoredPerTopic;
        this.maxMessagesStored = maxMessagesStored;
        this.publicationScripts = publicationScripts;
        this.publication = publication;
        this.subscription = subscription;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the serverURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerURI() {
        return serverURI;
    }

    /**
     * Sets the value of the serverURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerURI(String value) {
        this.serverURI = value;
    }

    /**
     * Gets the value of the clientID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * Sets the value of the clientID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientID(String value) {
        this.clientID = value;
    }

    /**
     * Gets the value of the userAuthentication property.
     * 
     * @return
     *     possible object is
     *     {@link UserAuthentication }
     *     
     */
    public UserAuthentication getUserAuthentication() {
        return userAuthentication;
    }

    /**
     * Sets the value of the userAuthentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAuthentication }
     *     
     */
    public void setUserAuthentication(UserAuthentication value) {
        this.userAuthentication = value;
    }

    /**
     * Gets the value of the lastWillAndTestament property.
     * 
     * @return
     *     possible object is
     *     {@link BaseMqttMessage }
     *     
     */
    public BaseMqttMessage getLastWillAndTestament() {
        return lastWillAndTestament;
    }

    /**
     * Sets the value of the lastWillAndTestament property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseMqttMessage }
     *     
     */
    public void setLastWillAndTestament(BaseMqttMessage value) {
        this.lastWillAndTestament = value;
    }

    /**
     * Gets the value of the autoOpen property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoOpen() {
        return autoOpen;
    }

    /**
     * Sets the value of the autoOpen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoOpen(Boolean value) {
        this.autoOpen = value;
    }

    /**
     * Gets the value of the autoConnect property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoConnect() {
        return autoConnect;
    }

    /**
     * Sets the value of the autoConnect property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoConnect(Boolean value) {
        this.autoConnect = value;
    }

    /**
     * Gets the value of the cleanSession property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCleanSession() {
        return cleanSession;
    }

    /**
     * Sets the value of the cleanSession property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCleanSession(Boolean value) {
        this.cleanSession = value;
    }

    /**
     * Gets the value of the connectionTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    /**
     * Sets the value of the connectionTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setConnectionTimeout(Integer value) {
        this.connectionTimeout = value;
    }

    /**
     * Gets the value of the keepAliveInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKeepAliveInterval() {
        return keepAliveInterval;
    }

    /**
     * Sets the value of the keepAliveInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKeepAliveInterval(Integer value) {
        this.keepAliveInterval = value;
    }

    /**
     * Gets the value of the formatter property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFormatter() {
        return formatter;
    }

    /**
     * Sets the value of the formatter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFormatter(Object value) {
        this.formatter = value;
    }

    /**
     * Gets the value of the minMessagesStoredPerTopic property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinMessagesStoredPerTopic() {
        return minMessagesStoredPerTopic;
    }

    /**
     * Sets the value of the minMessagesStoredPerTopic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinMessagesStoredPerTopic(Integer value) {
        this.minMessagesStoredPerTopic = value;
    }

    /**
     * Gets the value of the maxMessagesStored property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxMessagesStored() {
        return maxMessagesStored;
    }

    /**
     * Sets the value of the maxMessagesStored property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxMessagesStored(Integer value) {
        this.maxMessagesStored = value;
    }

    /**
     * Gets the value of the publicationScripts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationScripts() {
        return publicationScripts;
    }

    /**
     * Sets the value of the publicationScripts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationScripts(String value) {
        this.publicationScripts = value;
    }

    /**
     * Gets the value of the publication property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publication property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PublicationDetails }
     * 
     * 
     */
    public List<PublicationDetails> getPublication() {
        if (publication == null) {
            publication = new ArrayList<PublicationDetails>();
        }
        return this.publication;
    }

    /**
     * Gets the value of the subscription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TabbedSubscriptionDetails }
     * 
     * 
     */
    public List<TabbedSubscriptionDetails> getSubscription() {
        if (subscription == null) {
            subscription = new ArrayList<TabbedSubscriptionDetails>();
        }
        return this.subscription;
    }

    public void toString(ToStringBuilder toStringBuilder) {
        super.toString(toStringBuilder);
        {
            String theName;
            theName = this.getName();
            toStringBuilder.append("name", theName);
        }
        {
            String theServerURI;
            theServerURI = this.getServerURI();
            toStringBuilder.append("serverURI", theServerURI);
        }
        {
            String theClientID;
            theClientID = this.getClientID();
            toStringBuilder.append("clientID", theClientID);
        }
        {
            UserAuthentication theUserAuthentication;
            theUserAuthentication = this.getUserAuthentication();
            toStringBuilder.append("userAuthentication", theUserAuthentication);
        }
        {
            BaseMqttMessage theLastWillAndTestament;
            theLastWillAndTestament = this.getLastWillAndTestament();
            toStringBuilder.append("lastWillAndTestament", theLastWillAndTestament);
        }
        {
            Boolean theAutoOpen;
            theAutoOpen = this.isAutoOpen();
            toStringBuilder.append("autoOpen", theAutoOpen);
        }
        {
            Boolean theAutoConnect;
            theAutoConnect = this.isAutoConnect();
            toStringBuilder.append("autoConnect", theAutoConnect);
        }
        {
            Boolean theCleanSession;
            theCleanSession = this.isCleanSession();
            toStringBuilder.append("cleanSession", theCleanSession);
        }
        {
            Integer theConnectionTimeout;
            theConnectionTimeout = this.getConnectionTimeout();
            toStringBuilder.append("connectionTimeout", theConnectionTimeout);
        }
        {
            Integer theKeepAliveInterval;
            theKeepAliveInterval = this.getKeepAliveInterval();
            toStringBuilder.append("keepAliveInterval", theKeepAliveInterval);
        }
        {
            Object theFormatter;
            theFormatter = this.getFormatter();
            toStringBuilder.append("formatter", theFormatter);
        }
        {
            Integer theMinMessagesStoredPerTopic;
            theMinMessagesStoredPerTopic = this.getMinMessagesStoredPerTopic();
            toStringBuilder.append("minMessagesStoredPerTopic", theMinMessagesStoredPerTopic);
        }
        {
            Integer theMaxMessagesStored;
            theMaxMessagesStored = this.getMaxMessagesStored();
            toStringBuilder.append("maxMessagesStored", theMaxMessagesStored);
        }
        {
            String thePublicationScripts;
            thePublicationScripts = this.getPublicationScripts();
            toStringBuilder.append("publicationScripts", thePublicationScripts);
        }
        {
            List<PublicationDetails> thePublication;
            thePublication = this.getPublication();
            toStringBuilder.append("publication", thePublication);
        }
        {
            List<TabbedSubscriptionDetails> theSubscription;
            theSubscription = this.getSubscription();
            toStringBuilder.append("subscription", theSubscription);
        }
    }

    public String toString() {
        final ToStringBuilder toStringBuilder = new JAXBToStringBuilder(this);
        toString(toStringBuilder);
        return toStringBuilder.toString();
    }

    public void equals(Object object, EqualsBuilder equalsBuilder) {
        if (!(object instanceof UserInterfaceMqttConnectionDetailsV010)) {
            equalsBuilder.appendSuper(false);
            return ;
        }
        if (this == object) {
            return ;
        }
        super.equals(object, equalsBuilder);
        final UserInterfaceMqttConnectionDetailsV010 that = ((UserInterfaceMqttConnectionDetailsV010) object);
        equalsBuilder.append(this.getName(), that.getName());
        equalsBuilder.append(this.getServerURI(), that.getServerURI());
        equalsBuilder.append(this.getClientID(), that.getClientID());
        equalsBuilder.append(this.getUserAuthentication(), that.getUserAuthentication());
        equalsBuilder.append(this.getLastWillAndTestament(), that.getLastWillAndTestament());
        equalsBuilder.append(this.isAutoOpen(), that.isAutoOpen());
        equalsBuilder.append(this.isAutoConnect(), that.isAutoConnect());
        equalsBuilder.append(this.isCleanSession(), that.isCleanSession());
        equalsBuilder.append(this.getConnectionTimeout(), that.getConnectionTimeout());
        equalsBuilder.append(this.getKeepAliveInterval(), that.getKeepAliveInterval());
        equalsBuilder.append(this.getFormatter(), that.getFormatter());
        equalsBuilder.append(this.getMinMessagesStoredPerTopic(), that.getMinMessagesStoredPerTopic());
        equalsBuilder.append(this.getMaxMessagesStored(), that.getMaxMessagesStored());
        equalsBuilder.append(this.getPublicationScripts(), that.getPublicationScripts());
        equalsBuilder.append(this.getPublication(), that.getPublication());
        equalsBuilder.append(this.getSubscription(), that.getSubscription());
    }

    public boolean equals(Object object) {
        if (!(object instanceof UserInterfaceMqttConnectionDetailsV010)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final EqualsBuilder equalsBuilder = new JAXBEqualsBuilder();
        equals(object, equalsBuilder);
        return equalsBuilder.isEquals();
    }

    public void hashCode(HashCodeBuilder hashCodeBuilder) {
        super.hashCode(hashCodeBuilder);
        hashCodeBuilder.append(this.getName());
        hashCodeBuilder.append(this.getServerURI());
        hashCodeBuilder.append(this.getClientID());
        hashCodeBuilder.append(this.getUserAuthentication());
        hashCodeBuilder.append(this.getLastWillAndTestament());
        hashCodeBuilder.append(this.isAutoOpen());
        hashCodeBuilder.append(this.isAutoConnect());
        hashCodeBuilder.append(this.isCleanSession());
        hashCodeBuilder.append(this.getConnectionTimeout());
        hashCodeBuilder.append(this.getKeepAliveInterval());
        hashCodeBuilder.append(this.getFormatter());
        hashCodeBuilder.append(this.getMinMessagesStoredPerTopic());
        hashCodeBuilder.append(this.getMaxMessagesStored());
        hashCodeBuilder.append(this.getPublicationScripts());
        hashCodeBuilder.append(this.getPublication());
        hashCodeBuilder.append(this.getSubscription());
    }

    public int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new JAXBHashCodeBuilder();
        hashCode(hashCodeBuilder);
        return hashCodeBuilder.toHashCode();
    }

    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        final UserInterfaceMqttConnectionDetailsV010 copy = ((target == null)?((UserInterfaceMqttConnectionDetailsV010) createCopy()):((UserInterfaceMqttConnectionDetailsV010) target));
        super.copyTo(copy, copyBuilder);
        {
            String sourceName;
            sourceName = this.getName();
            String copyName = ((String) copyBuilder.copy(sourceName));
            copy.setName(copyName);
        }
        {
            String sourceServerURI;
            sourceServerURI = this.getServerURI();
            String copyServerURI = ((String) copyBuilder.copy(sourceServerURI));
            copy.setServerURI(copyServerURI);
        }
        {
            String sourceClientID;
            sourceClientID = this.getClientID();
            String copyClientID = ((String) copyBuilder.copy(sourceClientID));
            copy.setClientID(copyClientID);
        }
        {
            UserAuthentication sourceUserAuthentication;
            sourceUserAuthentication = this.getUserAuthentication();
            UserAuthentication copyUserAuthentication = ((UserAuthentication) copyBuilder.copy(sourceUserAuthentication));
            copy.setUserAuthentication(copyUserAuthentication);
        }
        {
            BaseMqttMessage sourceLastWillAndTestament;
            sourceLastWillAndTestament = this.getLastWillAndTestament();
            BaseMqttMessage copyLastWillAndTestament = ((BaseMqttMessage) copyBuilder.copy(sourceLastWillAndTestament));
            copy.setLastWillAndTestament(copyLastWillAndTestament);
        }
        {
            Boolean sourceAutoOpen;
            sourceAutoOpen = this.isAutoOpen();
            Boolean copyAutoOpen = ((Boolean) copyBuilder.copy(sourceAutoOpen));
            copy.setAutoOpen(copyAutoOpen);
        }
        {
            Boolean sourceAutoConnect;
            sourceAutoConnect = this.isAutoConnect();
            Boolean copyAutoConnect = ((Boolean) copyBuilder.copy(sourceAutoConnect));
            copy.setAutoConnect(copyAutoConnect);
        }
        {
            Boolean sourceCleanSession;
            sourceCleanSession = this.isCleanSession();
            Boolean copyCleanSession = ((Boolean) copyBuilder.copy(sourceCleanSession));
            copy.setCleanSession(copyCleanSession);
        }
        {
            Integer sourceConnectionTimeout;
            sourceConnectionTimeout = this.getConnectionTimeout();
            Integer copyConnectionTimeout = ((Integer) copyBuilder.copy(sourceConnectionTimeout));
            copy.setConnectionTimeout(copyConnectionTimeout);
        }
        {
            Integer sourceKeepAliveInterval;
            sourceKeepAliveInterval = this.getKeepAliveInterval();
            Integer copyKeepAliveInterval = ((Integer) copyBuilder.copy(sourceKeepAliveInterval));
            copy.setKeepAliveInterval(copyKeepAliveInterval);
        }
        {
            Object sourceFormatter;
            sourceFormatter = this.getFormatter();
            Object copyFormatter = ((Object) copyBuilder.copy(sourceFormatter));
            copy.setFormatter(copyFormatter);
        }
        {
            Integer sourceMinMessagesStoredPerTopic;
            sourceMinMessagesStoredPerTopic = this.getMinMessagesStoredPerTopic();
            Integer copyMinMessagesStoredPerTopic = ((Integer) copyBuilder.copy(sourceMinMessagesStoredPerTopic));
            copy.setMinMessagesStoredPerTopic(copyMinMessagesStoredPerTopic);
        }
        {
            Integer sourceMaxMessagesStored;
            sourceMaxMessagesStored = this.getMaxMessagesStored();
            Integer copyMaxMessagesStored = ((Integer) copyBuilder.copy(sourceMaxMessagesStored));
            copy.setMaxMessagesStored(copyMaxMessagesStored);
        }
        {
            String sourcePublicationScripts;
            sourcePublicationScripts = this.getPublicationScripts();
            String copyPublicationScripts = ((String) copyBuilder.copy(sourcePublicationScripts));
            copy.setPublicationScripts(copyPublicationScripts);
        }
        {
            List<PublicationDetails> sourcePublication;
            sourcePublication = this.getPublication();
            List<PublicationDetails> copyPublication = ((List<PublicationDetails> ) copyBuilder.copy(sourcePublication));
            copy.publication = null;
            List<PublicationDetails> uniquePublicationl = copy.getPublication();
            uniquePublicationl.addAll(copyPublication);
        }
        {
            List<TabbedSubscriptionDetails> sourceSubscription;
            sourceSubscription = this.getSubscription();
            List<TabbedSubscriptionDetails> copySubscription = ((List<TabbedSubscriptionDetails> ) copyBuilder.copy(sourceSubscription));
            copy.subscription = null;
            List<TabbedSubscriptionDetails> uniqueSubscriptionl = copy.getSubscription();
            uniqueSubscriptionl.addAll(copySubscription);
        }
        return copy;
    }

    public Object copyTo(Object target) {
        final CopyBuilder copyBuilder = new JAXBCopyBuilder();
        return copyTo(target, copyBuilder);
    }

    public Object createCopy() {
        return new UserInterfaceMqttConnectionDetailsV010();
    }

}

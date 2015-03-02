//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.02 at 02:39:48 PM GMT 
//


package pl.baczkowicz.mqttspy.versions.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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


/**
 * <p>Java class for LatestReleases complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LatestReleases">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LatestRelease" type="{http://baczkowicz.pl/mqtt-spy-versions}LatestRelease" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LatestReleases", propOrder = {
    "latestRelease"
})
public class LatestReleases
    implements CopyTo, Copyable, Equals, HashCode, ToString
{

    @XmlElement(name = "LatestRelease")
    protected List<LatestRelease> latestRelease;

    /**
     * Gets the value of the latestRelease property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the latestRelease property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLatestRelease().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LatestRelease }
     * 
     * 
     */
    public List<LatestRelease> getLatestRelease() {
        if (latestRelease == null) {
            latestRelease = new ArrayList<LatestRelease>();
        }
        return this.latestRelease;
    }

    public void toString(ToStringBuilder toStringBuilder) {
        {
            List<LatestRelease> theLatestRelease;
            theLatestRelease = this.getLatestRelease();
            toStringBuilder.append("latestRelease", theLatestRelease);
        }
    }

    public String toString() {
        final ToStringBuilder toStringBuilder = new JAXBToStringBuilder(this);
        toString(toStringBuilder);
        return toStringBuilder.toString();
    }

    public void equals(Object object, EqualsBuilder equalsBuilder) {
        if (!(object instanceof LatestReleases)) {
            equalsBuilder.appendSuper(false);
            return ;
        }
        if (this == object) {
            return ;
        }
        final LatestReleases that = ((LatestReleases) object);
        equalsBuilder.append(this.getLatestRelease(), that.getLatestRelease());
    }

    public boolean equals(Object object) {
        if (!(object instanceof LatestReleases)) {
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
        hashCodeBuilder.append(this.getLatestRelease());
    }

    public int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new JAXBHashCodeBuilder();
        hashCode(hashCodeBuilder);
        return hashCodeBuilder.toHashCode();
    }

    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        final LatestReleases copy = ((target == null)?((LatestReleases) createCopy()):((LatestReleases) target));
        {
            List<LatestRelease> sourceLatestRelease;
            sourceLatestRelease = this.getLatestRelease();
            List<LatestRelease> copyLatestRelease = ((List<LatestRelease> ) copyBuilder.copy(sourceLatestRelease));
            copy.latestRelease = null;
            List<LatestRelease> uniqueLatestReleasel = copy.getLatestRelease();
            uniqueLatestReleasel.addAll(copyLatestRelease);
        }
        return copy;
    }

    public Object copyTo(Object target) {
        final CopyBuilder copyBuilder = new JAXBCopyBuilder();
        return copyTo(target, copyBuilder);
    }

    public Object createCopy() {
        return new LatestReleases();
    }

}

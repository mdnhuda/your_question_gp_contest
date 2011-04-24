/**
 * SendSMSRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gp.ws.sms;

public class SendSMSRequest  implements java.io.Serializable {
    private java.lang.String registrationID;

    private java.lang.String password;

    private java.lang.String sourceMsisdn;

    private java.lang.String destinationMsisdn;

    private java.lang.String smsPort;

    private int msgType;

    private double charge;

    private java.lang.String chargedParty;

    private java.lang.String contentArea;

    private java.lang.String msgContent;

    public SendSMSRequest() {
    }

    public SendSMSRequest(
           java.lang.String registrationID,
           java.lang.String password,
           java.lang.String sourceMsisdn,
           java.lang.String destinationMsisdn,
           java.lang.String smsPort,
           int msgType,
           double charge,
           java.lang.String chargedParty,
           java.lang.String contentArea,
           java.lang.String msgContent) {
           this.registrationID = registrationID;
           this.password = password;
           this.sourceMsisdn = sourceMsisdn;
           this.destinationMsisdn = destinationMsisdn;
           this.smsPort = smsPort;
           this.msgType = msgType;
           this.charge = charge;
           this.chargedParty = chargedParty;
           this.contentArea = contentArea;
           this.msgContent = msgContent;
    }


    /**
     * Gets the registrationID value for this SendSMSRequest.
     * 
     * @return registrationID
     */
    public java.lang.String getRegistrationID() {
        return registrationID;
    }


    /**
     * Sets the registrationID value for this SendSMSRequest.
     * 
     * @param registrationID
     */
    public void setRegistrationID(java.lang.String registrationID) {
        this.registrationID = registrationID;
    }


    /**
     * Gets the password value for this SendSMSRequest.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this SendSMSRequest.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the sourceMsisdn value for this SendSMSRequest.
     * 
     * @return sourceMsisdn
     */
    public java.lang.String getSourceMsisdn() {
        return sourceMsisdn;
    }


    /**
     * Sets the sourceMsisdn value for this SendSMSRequest.
     * 
     * @param sourceMsisdn
     */
    public void setSourceMsisdn(java.lang.String sourceMsisdn) {
        this.sourceMsisdn = sourceMsisdn;
    }


    /**
     * Gets the destinationMsisdn value for this SendSMSRequest.
     * 
     * @return destinationMsisdn
     */
    public java.lang.String getDestinationMsisdn() {
        return destinationMsisdn;
    }


    /**
     * Sets the destinationMsisdn value for this SendSMSRequest.
     * 
     * @param destinationMsisdn
     */
    public void setDestinationMsisdn(java.lang.String destinationMsisdn) {
        this.destinationMsisdn = destinationMsisdn;
    }


    /**
     * Gets the smsPort value for this SendSMSRequest.
     * 
     * @return smsPort
     */
    public java.lang.String getSmsPort() {
        return smsPort;
    }


    /**
     * Sets the smsPort value for this SendSMSRequest.
     * 
     * @param smsPort
     */
    public void setSmsPort(java.lang.String smsPort) {
        this.smsPort = smsPort;
    }


    /**
     * Gets the msgType value for this SendSMSRequest.
     * 
     * @return msgType
     */
    public int getMsgType() {
        return msgType;
    }


    /**
     * Sets the msgType value for this SendSMSRequest.
     * 
     * @param msgType
     */
    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }


    /**
     * Gets the charge value for this SendSMSRequest.
     * 
     * @return charge
     */
    public double getCharge() {
        return charge;
    }


    /**
     * Sets the charge value for this SendSMSRequest.
     * 
     * @param charge
     */
    public void setCharge(double charge) {
        this.charge = charge;
    }


    /**
     * Gets the chargedParty value for this SendSMSRequest.
     * 
     * @return chargedParty
     */
    public java.lang.String getChargedParty() {
        return chargedParty;
    }


    /**
     * Sets the chargedParty value for this SendSMSRequest.
     * 
     * @param chargedParty
     */
    public void setChargedParty(java.lang.String chargedParty) {
        this.chargedParty = chargedParty;
    }


    /**
     * Gets the contentArea value for this SendSMSRequest.
     * 
     * @return contentArea
     */
    public java.lang.String getContentArea() {
        return contentArea;
    }


    /**
     * Sets the contentArea value for this SendSMSRequest.
     * 
     * @param contentArea
     */
    public void setContentArea(java.lang.String contentArea) {
        this.contentArea = contentArea;
    }


    /**
     * Gets the msgContent value for this SendSMSRequest.
     * 
     * @return msgContent
     */
    public java.lang.String getMsgContent() {
        return msgContent;
    }


    /**
     * Sets the msgContent value for this SendSMSRequest.
     * 
     * @param msgContent
     */
    public void setMsgContent(java.lang.String msgContent) {
        this.msgContent = msgContent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendSMSRequest)) return false;
        SendSMSRequest other = (SendSMSRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.registrationID==null && other.getRegistrationID()==null) || 
             (this.registrationID!=null &&
              this.registrationID.equals(other.getRegistrationID()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.sourceMsisdn==null && other.getSourceMsisdn()==null) || 
             (this.sourceMsisdn!=null &&
              this.sourceMsisdn.equals(other.getSourceMsisdn()))) &&
            ((this.destinationMsisdn==null && other.getDestinationMsisdn()==null) || 
             (this.destinationMsisdn!=null &&
              this.destinationMsisdn.equals(other.getDestinationMsisdn()))) &&
            ((this.smsPort==null && other.getSmsPort()==null) || 
             (this.smsPort!=null &&
              this.smsPort.equals(other.getSmsPort()))) &&
            this.msgType == other.getMsgType() &&
            this.charge == other.getCharge() &&
            ((this.chargedParty==null && other.getChargedParty()==null) || 
             (this.chargedParty!=null &&
              this.chargedParty.equals(other.getChargedParty()))) &&
            ((this.contentArea==null && other.getContentArea()==null) || 
             (this.contentArea!=null &&
              this.contentArea.equals(other.getContentArea()))) &&
            ((this.msgContent==null && other.getMsgContent()==null) || 
             (this.msgContent!=null &&
              this.msgContent.equals(other.getMsgContent())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRegistrationID() != null) {
            _hashCode += getRegistrationID().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getSourceMsisdn() != null) {
            _hashCode += getSourceMsisdn().hashCode();
        }
        if (getDestinationMsisdn() != null) {
            _hashCode += getDestinationMsisdn().hashCode();
        }
        if (getSmsPort() != null) {
            _hashCode += getSmsPort().hashCode();
        }
        _hashCode += getMsgType();
        _hashCode += new Double(getCharge()).hashCode();
        if (getChargedParty() != null) {
            _hashCode += getChargedParty().hashCode();
        }
        if (getContentArea() != null) {
            _hashCode += getContentArea().hashCode();
        }
        if (getMsgContent() != null) {
            _hashCode += getMsgContent().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendSMSRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.grameenphone.com/SendSMSRequest_XML", ">SendSMSRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrationID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registrationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceMsisdn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sourceMsisdn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationMsisdn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destinationMsisdn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smsPort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smsPort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("charge");
        elemField.setXmlName(new javax.xml.namespace.QName("", "charge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargedParty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chargedParty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgContent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

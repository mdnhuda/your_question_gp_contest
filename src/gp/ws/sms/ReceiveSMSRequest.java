/**
 * ReceiveSMSRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gp.ws.sms;

public class ReceiveSMSRequest  implements java.io.Serializable {
    private java.lang.String registrationID;

    private java.lang.String password;

    private java.lang.String smsPort;

    private java.lang.String msgID;

    public ReceiveSMSRequest() {
    }

    public ReceiveSMSRequest(
           java.lang.String registrationID,
           java.lang.String password,
           java.lang.String smsPort,
           java.lang.String msgID) {
           this.registrationID = registrationID;
           this.password = password;
           this.smsPort = smsPort;
           this.msgID = msgID;
    }


    /**
     * Gets the registrationID value for this ReceiveSMSRequest.
     * 
     * @return registrationID
     */
    public java.lang.String getRegistrationID() {
        return registrationID;
    }


    /**
     * Sets the registrationID value for this ReceiveSMSRequest.
     * 
     * @param registrationID
     */
    public void setRegistrationID(java.lang.String registrationID) {
        this.registrationID = registrationID;
    }


    /**
     * Gets the password value for this ReceiveSMSRequest.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this ReceiveSMSRequest.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the smsPort value for this ReceiveSMSRequest.
     * 
     * @return smsPort
     */
    public java.lang.String getSmsPort() {
        return smsPort;
    }


    /**
     * Sets the smsPort value for this ReceiveSMSRequest.
     * 
     * @param smsPort
     */
    public void setSmsPort(java.lang.String smsPort) {
        this.smsPort = smsPort;
    }


    /**
     * Gets the msgID value for this ReceiveSMSRequest.
     * 
     * @return msgID
     */
    public java.lang.String getMsgID() {
        return msgID;
    }


    /**
     * Sets the msgID value for this ReceiveSMSRequest.
     * 
     * @param msgID
     */
    public void setMsgID(java.lang.String msgID) {
        this.msgID = msgID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReceiveSMSRequest)) return false;
        ReceiveSMSRequest other = (ReceiveSMSRequest) obj;
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
            ((this.smsPort==null && other.getSmsPort()==null) || 
             (this.smsPort!=null &&
              this.smsPort.equals(other.getSmsPort()))) &&
            ((this.msgID==null && other.getMsgID()==null) || 
             (this.msgID!=null &&
              this.msgID.equals(other.getMsgID())));
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
        if (getSmsPort() != null) {
            _hashCode += getSmsPort().hashCode();
        }
        if (getMsgID() != null) {
            _hashCode += getMsgID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReceiveSMSRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://GP.ADP.BizTalk.Schemas.ReceiveSMSRequest_XML", ">ReceiveSMSRequest"));
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
        elemField.setFieldName("smsPort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smsPort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgID"));
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

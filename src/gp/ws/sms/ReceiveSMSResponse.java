/**
 * ReceiveSMSResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gp.ws.sms;

public class ReceiveSMSResponse  implements java.io.Serializable {
    private java.lang.String msgID;

    private java.lang.String senderMSISDN;

    private java.lang.String timeStamp;

    private java.lang.String msgContent;

    private java.lang.String sourcePort;

    public ReceiveSMSResponse() {
    }

    public ReceiveSMSResponse(
           java.lang.String msgID,
           java.lang.String senderMSISDN,
           java.lang.String timeStamp,
           java.lang.String msgContent,
           java.lang.String sourcePort) {
           this.msgID = msgID;
           this.senderMSISDN = senderMSISDN;
           this.timeStamp = timeStamp;
           this.msgContent = msgContent;
           this.sourcePort = sourcePort;
    }


    /**
     * Gets the msgID value for this ReceiveSMSResponse.
     * 
     * @return msgID
     */
    public java.lang.String getMsgID() {
        return msgID;
    }


    /**
     * Sets the msgID value for this ReceiveSMSResponse.
     * 
     * @param msgID
     */
    public void setMsgID(java.lang.String msgID) {
        this.msgID = msgID;
    }


    /**
     * Gets the senderMSISDN value for this ReceiveSMSResponse.
     * 
     * @return senderMSISDN
     */
    public java.lang.String getSenderMSISDN() {
        return senderMSISDN;
    }


    /**
     * Sets the senderMSISDN value for this ReceiveSMSResponse.
     * 
     * @param senderMSISDN
     */
    public void setSenderMSISDN(java.lang.String senderMSISDN) {
        this.senderMSISDN = senderMSISDN;
    }


    /**
     * Gets the timeStamp value for this ReceiveSMSResponse.
     * 
     * @return timeStamp
     */
    public java.lang.String getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this ReceiveSMSResponse.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(java.lang.String timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the msgContent value for this ReceiveSMSResponse.
     * 
     * @return msgContent
     */
    public java.lang.String getMsgContent() {
        return msgContent;
    }


    /**
     * Sets the msgContent value for this ReceiveSMSResponse.
     * 
     * @param msgContent
     */
    public void setMsgContent(java.lang.String msgContent) {
        this.msgContent = msgContent;
    }


    /**
     * Gets the sourcePort value for this ReceiveSMSResponse.
     * 
     * @return sourcePort
     */
    public java.lang.String getSourcePort() {
        return sourcePort;
    }


    /**
     * Sets the sourcePort value for this ReceiveSMSResponse.
     * 
     * @param sourcePort
     */
    public void setSourcePort(java.lang.String sourcePort) {
        this.sourcePort = sourcePort;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReceiveSMSResponse)) return false;
        ReceiveSMSResponse other = (ReceiveSMSResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.msgID==null && other.getMsgID()==null) || 
             (this.msgID!=null &&
              this.msgID.equals(other.getMsgID()))) &&
            ((this.senderMSISDN==null && other.getSenderMSISDN()==null) || 
             (this.senderMSISDN!=null &&
              this.senderMSISDN.equals(other.getSenderMSISDN()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              this.timeStamp.equals(other.getTimeStamp()))) &&
            ((this.msgContent==null && other.getMsgContent()==null) || 
             (this.msgContent!=null &&
              this.msgContent.equals(other.getMsgContent()))) &&
            ((this.sourcePort==null && other.getSourcePort()==null) || 
             (this.sourcePort!=null &&
              this.sourcePort.equals(other.getSourcePort())));
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
        if (getMsgID() != null) {
            _hashCode += getMsgID().hashCode();
        }
        if (getSenderMSISDN() != null) {
            _hashCode += getSenderMSISDN().hashCode();
        }
        if (getTimeStamp() != null) {
            _hashCode += getTimeStamp().hashCode();
        }
        if (getMsgContent() != null) {
            _hashCode += getMsgContent().hashCode();
        }
        if (getSourcePort() != null) {
            _hashCode += getSourcePort().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReceiveSMSResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://GP.ADP.BizTalk.Schemas.ReceiveSMSResponse_XML", ">ReceiveSMSResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderMSISDN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senderMSISDN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeStamp"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourcePort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sourcePort"));
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

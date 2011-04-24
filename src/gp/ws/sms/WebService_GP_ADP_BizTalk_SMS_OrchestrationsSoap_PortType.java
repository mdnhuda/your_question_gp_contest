/**
 * WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gp.ws.sms;

public interface WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_PortType extends java.rmi.Remote {
    public gp.ws.sms.SendSMSResponse sendSMS(gp.ws.sms.SendSMSRequest sendSMSRequest) throws java.rmi.RemoteException;
    public gp.ws.sms.ReceiveSMSResponse getReceivedSMS(gp.ws.sms.ReceiveSMSRequest receiveSMSRequest) throws java.rmi.RemoteException;
    public gp.ws.sms.SMSStatusResponse getSMSDeliveryStatus(gp.ws.sms.SMSStatusRequest SMSStatusRequest) throws java.rmi.RemoteException;
}

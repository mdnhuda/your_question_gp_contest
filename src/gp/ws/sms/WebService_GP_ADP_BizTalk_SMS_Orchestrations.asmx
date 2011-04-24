<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:s3="http://GP.ADP.BizTalk.Schemas.ReceiveSMSRequest_XML" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:s5="http://GP.ADP.BizTalk.Schemas.SMSStatusRequest_XML" xmlns:s6="http://GP.ADP.BizTalk.Schemas.SMSStatusResponse" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://www.grameenphone.com/playground" xmlns:s1="http://www.grameenphone.com/SendSMSRequest_XML" xmlns:s2="http://GP.ADP.BizTalk.Schemas.SendSMSResponse_XML" xmlns:s4="http://GP.ADP.BizTalk.Schemas.ReceiveSMSResponse_XML" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://www.grameenphone.com/playground" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">BizTalk assembly "GP.ADP.BizTalk.SMS.Orchestrations, Version=1.0.0.0, Culture=neutral, PublicKeyToken=eca26cc848227d06" published web service.</wsdl:documentation>
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://www.grameenphone.com/playground">
      <s:import namespace="http://www.grameenphone.com/SendSMSRequest_XML" />
      <s:import namespace="http://GP.ADP.BizTalk.Schemas.SendSMSResponse_XML" />
      <s:import namespace="http://GP.ADP.BizTalk.Schemas.ReceiveSMSRequest_XML" />
      <s:import namespace="http://GP.ADP.BizTalk.Schemas.ReceiveSMSResponse_XML" />
      <s:import namespace="http://GP.ADP.BizTalk.Schemas.SMSStatusRequest_XML" />
      <s:import namespace="http://GP.ADP.BizTalk.Schemas.SMSStatusResponse" />
      <s:element name="sendSMS">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s1:SendSMSRequest" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="sendSMSResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s2:SendSMSResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getReceivedSMS">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s3:ReceiveSMSRequest" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getReceivedSMSResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s4:ReceiveSMSResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getSMSDeliveryStatus">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s5:SMSStatusRequest" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getSMSDeliveryStatusResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s6:SMSStatusResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="http://www.grameenphone.com/SendSMSRequest_XML">
      <s:element name="SendSMSRequest">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="registrationID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="sourceMsisdn" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="destinationMsisdn" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="smsPort" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" form="unqualified" name="msgType" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" form="unqualified" name="charge" type="s:double" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="chargedParty" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="contentArea" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="msgContent" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="http://GP.ADP.BizTalk.Schemas.SendSMSResponse_XML">
      <s:element name="SendSMSResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="status" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="msgID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="http://GP.ADP.BizTalk.Schemas.ReceiveSMSRequest_XML">
      <s:element name="ReceiveSMSRequest">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="registrationID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="smsPort" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="msgID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="http://GP.ADP.BizTalk.Schemas.ReceiveSMSResponse_XML">
      <s:element name="ReceiveSMSResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="msgID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="senderMSISDN" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="timeStamp" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="msgContent" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="sourcePort" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="http://GP.ADP.BizTalk.Schemas.SMSStatusRequest_XML">
      <s:element name="SMSStatusRequest">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="registrationID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="msgID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="http://GP.ADP.BizTalk.Schemas.SMSStatusResponse">
      <s:element name="SMSStatusResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="deliveryStatus" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="sendSMSSoapIn">
    <wsdl:part name="parameters" element="tns:sendSMS" />
  </wsdl:message>
  <wsdl:message name="sendSMSSoapOut">
    <wsdl:part name="parameters" element="tns:sendSMSResponse" />
  </wsdl:message>
  <wsdl:message name="getReceivedSMSSoapIn">
    <wsdl:part name="parameters" element="tns:getReceivedSMS" />
  </wsdl:message>
  <wsdl:message name="getReceivedSMSSoapOut">
    <wsdl:part name="parameters" element="tns:getReceivedSMSResponse" />
  </wsdl:message>
  <wsdl:message name="getSMSDeliveryStatusSoapIn">
    <wsdl:part name="parameters" element="tns:getSMSDeliveryStatus" />
  </wsdl:message>
  <wsdl:message name="getSMSDeliveryStatusSoapOut">
    <wsdl:part name="parameters" element="tns:getSMSDeliveryStatusResponse" />
  </wsdl:message>
  <wsdl:portType name="WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap">
    <wsdl:operation name="sendSMS">
      <wsdl:input message="tns:sendSMSSoapIn" />
      <wsdl:output message="tns:sendSMSSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getReceivedSMS">
      <wsdl:input message="tns:getReceivedSMSSoapIn" />
      <wsdl:output message="tns:getReceivedSMSSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getSMSDeliveryStatus">
      <wsdl:input message="tns:getSMSDeliveryStatusSoapIn" />
      <wsdl:output message="tns:getSMSDeliveryStatusSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap" type="tns:WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="sendSMS">
      <soap:operation soapAction="http://www.grameenphone.com/playground/WebService_GP_ADP_BizTalk_SMS_Orchestrations/sendSMS" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getReceivedSMS">
      <soap:operation soapAction="http://www.grameenphone.com/playground/WebService_GP_ADP_BizTalk_SMS_Orchestrations/getReceivedSMS" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getSMSDeliveryStatus">
      <soap:operation soapAction="http://www.grameenphone.com/playground/WebService_GP_ADP_BizTalk_SMS_Orchestrations/getSMSDeliveryStatus" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12" type="tns:WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="sendSMS">
      <soap12:operation soapAction="http://www.grameenphone.com/playground/WebService_GP_ADP_BizTalk_SMS_Orchestrations/sendSMS" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getReceivedSMS">
      <soap12:operation soapAction="http://www.grameenphone.com/playground/WebService_GP_ADP_BizTalk_SMS_Orchestrations/getReceivedSMS" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getSMSDeliveryStatus">
      <soap12:operation soapAction="http://www.grameenphone.com/playground/WebService_GP_ADP_BizTalk_SMS_Orchestrations/getSMSDeliveryStatus" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="WebService_GP_ADP_BizTalk_SMS_Orchestrations">
    <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">BizTalk assembly "GP.ADP.BizTalk.SMS.Orchestrations, Version=1.0.0.0, Culture=neutral, PublicKeyToken=eca26cc848227d06" published web service.</wsdl:documentation>
    <wsdl:port name="WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap" binding="tns:WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap">
      <soap:address location="https://www.aloashbei.com.bd/API/GP.ADP.BizTalk.SMS.Orchestrations/WebService_GP_ADP_BizTalk_SMS_Orchestrations.asmx" />
    </wsdl:port>
    <wsdl:port name="WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12" binding="tns:WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12">
      <soap12:address location="https://www.aloashbei.com.bd/API/GP.ADP.BizTalk.SMS.Orchestrations/WebService_GP_ADP_BizTalk_SMS_Orchestrations.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>
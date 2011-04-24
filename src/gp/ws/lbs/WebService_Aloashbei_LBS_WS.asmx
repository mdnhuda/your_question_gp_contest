<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://www.grameenphone.com/playground" xmlns:s1="http://Aloashbei_LBS_WS.LBSRequest" xmlns:s2="http://Aloashbei_LBS_WS.LBSResponse" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://www.grameenphone.com/playground" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">BizTalk assembly "Aloashbei_LBS_WS, Version=1.0.0.0, Culture=neutral, PublicKeyToken=1ddc3808dbc803b6" published web service.</wsdl:documentation>
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://www.grameenphone.com/playground">
      <s:import namespace="http://Aloashbei_LBS_WS.LBSRequest" />
      <s:import namespace="http://Aloashbei_LBS_WS.LBSResponse" />
      <s:element name="requestLocation">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s1:LBSRequest" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="requestLocationResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s2:LBSResponse" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="http://Aloashbei_LBS_WS.LBSRequest">
      <s:element name="LBSRequest">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="registrationID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="msisdn" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="http://Aloashbei_LBS_WS.LBSResponse">
      <s:element name="LBSResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="Latitude" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="Longitude" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="Timestamp" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" form="unqualified" name="Status" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="requestLocationSoapIn">
    <wsdl:part name="parameters" element="tns:requestLocation" />
  </wsdl:message>
  <wsdl:message name="requestLocationSoapOut">
    <wsdl:part name="parameters" element="tns:requestLocationResponse" />
  </wsdl:message>
  <wsdl:portType name="WebService_Aloashbei_LBS_WSSoap">
    <wsdl:operation name="requestLocation">
      <wsdl:input message="tns:requestLocationSoapIn" />
      <wsdl:output message="tns:requestLocationSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="WebService_Aloashbei_LBS_WSSoap" type="tns:WebService_Aloashbei_LBS_WSSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="requestLocation">
      <soap:operation soapAction="http://www.grameenphone.com/playground/WebService_Aloashbei_LBS_WS/requestLocation" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="WebService_Aloashbei_LBS_WSSoap12" type="tns:WebService_Aloashbei_LBS_WSSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="requestLocation">
      <soap12:operation soapAction="http://www.grameenphone.com/playground/WebService_Aloashbei_LBS_WS/requestLocation" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="WebService_Aloashbei_LBS_WS">
    <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">BizTalk assembly "Aloashbei_LBS_WS, Version=1.0.0.0, Culture=neutral, PublicKeyToken=1ddc3808dbc803b6" published web service.</wsdl:documentation>
    <wsdl:port name="WebService_Aloashbei_LBS_WSSoap" binding="tns:WebService_Aloashbei_LBS_WSSoap">
      <soap:address location="https://www.aloashbei.com.bd/API/Aloashbei_LBS_WS/WebService_Aloashbei_LBS_WS.asmx" />
    </wsdl:port>
    <wsdl:port name="WebService_Aloashbei_LBS_WSSoap12" binding="tns:WebService_Aloashbei_LBS_WSSoap12">
      <soap12:address location="https://www.aloashbei.com.bd/API/Aloashbei_LBS_WS/WebService_Aloashbei_LBS_WS.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>
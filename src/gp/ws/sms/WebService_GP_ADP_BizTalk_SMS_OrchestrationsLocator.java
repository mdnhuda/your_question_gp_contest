/**
 * WebService_GP_ADP_BizTalk_SMS_OrchestrationsLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gp.ws.sms;

public class WebService_GP_ADP_BizTalk_SMS_OrchestrationsLocator extends org.apache.axis.client.Service implements gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_Orchestrations {

/**
 * BizTalk assembly "GP.ADP.BizTalk.SMS.Orchestrations, Version=1.0.0.0,
 * Culture=neutral, PublicKeyToken=eca26cc848227d06" published web service.
 */

    public WebService_GP_ADP_BizTalk_SMS_OrchestrationsLocator() {
    }


    public WebService_GP_ADP_BizTalk_SMS_OrchestrationsLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebService_GP_ADP_BizTalk_SMS_OrchestrationsLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12
    private java.lang.String WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12_address = "https://www.aloashbei.com.bd/API/GP.ADP.BizTalk.SMS.Orchestrations/WebService_GP_ADP_BizTalk_SMS_Orchestrations.asmx";

    public java.lang.String getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12Address() {
        return WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12WSDDServiceName = "WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12";

    public java.lang.String getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12WSDDServiceName() {
        return WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12WSDDServiceName;
    }

    public void setWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12WSDDServiceName(java.lang.String name) {
        WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12WSDDServiceName = name;
    }

    public gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_PortType getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12(endpoint);
    }

    public gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_PortType getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12Stub _stub = new gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12Stub(portAddress, this);
            _stub.setPortName(getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12EndpointAddress(java.lang.String address) {
        WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12_address = address;
    }


    // Use to get a proxy class for WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap
    private java.lang.String WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_address = "https://www.aloashbei.com.bd/API/GP.ADP.BizTalk.SMS.Orchestrations/WebService_GP_ADP_BizTalk_SMS_Orchestrations.asmx";

    public java.lang.String getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoapAddress() {
        return WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoapWSDDServiceName = "WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap";

    public java.lang.String getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoapWSDDServiceName() {
        return WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoapWSDDServiceName;
    }

    public void setWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoapWSDDServiceName(java.lang.String name) {
        WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoapWSDDServiceName = name;
    }

    public gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_PortType getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap(endpoint);
    }

    public gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_PortType getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_BindingStub _stub = new gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_BindingStub(portAddress, this);
            _stub.setPortName(getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoapEndpointAddress(java.lang.String address) {
        WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12Stub _stub = new gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12Stub(new java.net.URL(WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12_address), this);
                _stub.setPortName(getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12WSDDServiceName());
                return _stub;
            }
            if (gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_BindingStub _stub = new gp.ws.sms.WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_BindingStub(new java.net.URL(WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_address), this);
                _stub.setPortName(getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12".equals(inputPortName)) {
            return getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12();
        }
        else if ("WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap".equals(inputPortName)) {
            return getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.grameenphone.com/playground", "WebService_GP_ADP_BizTalk_SMS_Orchestrations");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.grameenphone.com/playground", "WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12"));
            ports.add(new javax.xml.namespace.QName("http://www.grameenphone.com/playground", "WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12".equals(portName)) {
            setWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap12EndpointAddress(address);
        }
        else 
if ("WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap".equals(portName)) {
            setWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

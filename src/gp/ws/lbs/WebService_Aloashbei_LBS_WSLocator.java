/**
 * WebService_Aloashbei_LBS_WSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gp.ws.lbs;

public class WebService_Aloashbei_LBS_WSLocator extends org.apache.axis.client.Service implements gp.ws.lbs.WebService_Aloashbei_LBS_WS {

/**
 * BizTalk assembly "Aloashbei_LBS_WS, Version=1.0.0.0, Culture=neutral,
 * PublicKeyToken=1ddc3808dbc803b6" published web service.
 */

    public WebService_Aloashbei_LBS_WSLocator() {
    }


    public WebService_Aloashbei_LBS_WSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebService_Aloashbei_LBS_WSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebService_Aloashbei_LBS_WSSoap
    private java.lang.String WebService_Aloashbei_LBS_WSSoap_address = "https://www.aloashbei.com.bd/API/Aloashbei_LBS_WS/WebService_Aloashbei_LBS_WS.asmx";

    public java.lang.String getWebService_Aloashbei_LBS_WSSoapAddress() {
        return WebService_Aloashbei_LBS_WSSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebService_Aloashbei_LBS_WSSoapWSDDServiceName = "WebService_Aloashbei_LBS_WSSoap";

    public java.lang.String getWebService_Aloashbei_LBS_WSSoapWSDDServiceName() {
        return WebService_Aloashbei_LBS_WSSoapWSDDServiceName;
    }

    public void setWebService_Aloashbei_LBS_WSSoapWSDDServiceName(java.lang.String name) {
        WebService_Aloashbei_LBS_WSSoapWSDDServiceName = name;
    }

    public gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap_PortType getWebService_Aloashbei_LBS_WSSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebService_Aloashbei_LBS_WSSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebService_Aloashbei_LBS_WSSoap(endpoint);
    }

    public gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap_PortType getWebService_Aloashbei_LBS_WSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap_BindingStub _stub = new gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap_BindingStub(portAddress, this);
            _stub.setPortName(getWebService_Aloashbei_LBS_WSSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebService_Aloashbei_LBS_WSSoapEndpointAddress(java.lang.String address) {
        WebService_Aloashbei_LBS_WSSoap_address = address;
    }


    // Use to get a proxy class for WebService_Aloashbei_LBS_WSSoap12
    private java.lang.String WebService_Aloashbei_LBS_WSSoap12_address = "https://www.aloashbei.com.bd/API/Aloashbei_LBS_WS/WebService_Aloashbei_LBS_WS.asmx";

    public java.lang.String getWebService_Aloashbei_LBS_WSSoap12Address() {
        return WebService_Aloashbei_LBS_WSSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebService_Aloashbei_LBS_WSSoap12WSDDServiceName = "WebService_Aloashbei_LBS_WSSoap12";

    public java.lang.String getWebService_Aloashbei_LBS_WSSoap12WSDDServiceName() {
        return WebService_Aloashbei_LBS_WSSoap12WSDDServiceName;
    }

    public void setWebService_Aloashbei_LBS_WSSoap12WSDDServiceName(java.lang.String name) {
        WebService_Aloashbei_LBS_WSSoap12WSDDServiceName = name;
    }

    public gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap_PortType getWebService_Aloashbei_LBS_WSSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebService_Aloashbei_LBS_WSSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebService_Aloashbei_LBS_WSSoap12(endpoint);
    }

    public gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap_PortType getWebService_Aloashbei_LBS_WSSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap12Stub _stub = new gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap12Stub(portAddress, this);
            _stub.setPortName(getWebService_Aloashbei_LBS_WSSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebService_Aloashbei_LBS_WSSoap12EndpointAddress(java.lang.String address) {
        WebService_Aloashbei_LBS_WSSoap12_address = address;
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
            if (gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap_BindingStub _stub = new gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap_BindingStub(new java.net.URL(WebService_Aloashbei_LBS_WSSoap_address), this);
                _stub.setPortName(getWebService_Aloashbei_LBS_WSSoapWSDDServiceName());
                return _stub;
            }
            if (gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap12Stub _stub = new gp.ws.lbs.WebService_Aloashbei_LBS_WSSoap12Stub(new java.net.URL(WebService_Aloashbei_LBS_WSSoap12_address), this);
                _stub.setPortName(getWebService_Aloashbei_LBS_WSSoap12WSDDServiceName());
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
        if ("WebService_Aloashbei_LBS_WSSoap".equals(inputPortName)) {
            return getWebService_Aloashbei_LBS_WSSoap();
        }
        else if ("WebService_Aloashbei_LBS_WSSoap12".equals(inputPortName)) {
            return getWebService_Aloashbei_LBS_WSSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.grameenphone.com/playground", "WebService_Aloashbei_LBS_WS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.grameenphone.com/playground", "WebService_Aloashbei_LBS_WSSoap"));
            ports.add(new javax.xml.namespace.QName("http://www.grameenphone.com/playground", "WebService_Aloashbei_LBS_WSSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebService_Aloashbei_LBS_WSSoap".equals(portName)) {
            setWebService_Aloashbei_LBS_WSSoapEndpointAddress(address);
        }
        else 
if ("WebService_Aloashbei_LBS_WSSoap12".equals(portName)) {
            setWebService_Aloashbei_LBS_WSSoap12EndpointAddress(address);
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

package org.questions.service;

import gp.ws.lbs.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Properties;

/**
 * User: naim
 * Date: Jun 24, 2010
 */
@Service
public class LbsService implements InitializingBean {
    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private Properties accountProps;

    public void setAccountProps(Properties accountProps) {
        this.accountProps = accountProps;
    }

    private WebService_Aloashbei_LBS_WSSoap_PortType service;

    public void afterPropertiesSet() throws Exception {
        WebService_Aloashbei_LBS_WS locator = new WebService_Aloashbei_LBS_WSLocator();
        service = locator.getWebService_Aloashbei_LBS_WSSoap();
    }

    private LBSRequest makeRequest(String targetMsisdn) {
        LBSRequest request = new LBSRequest();
        request.setRegistrationID(accountProps.getProperty("registration.id"));
        request.setPassword(accountProps.getProperty("account.password"));
        request.setMsisdn(targetMsisdn);
        return request;
    }

    public LBSResponse getLocation(String targetMsisdn) {
        LBSRequest request = makeRequest(targetMsisdn);
        if (service == null) {
            logger.error("LBS Service is null!");
        }
        try {
            return service.requestLocation(request);
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}

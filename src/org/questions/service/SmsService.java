package org.questions.service;

import gp.ws.sms.*;
import org.questions.dao.AnswerSmsDao;
import org.questions.domain.AnswerSms;
import org.questions.domain.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * User: naim
 * Date: Jun 28, 2010
 */
@Service
public class SmsService implements InitializingBean {
    Logger logger = LoggerFactory.getLogger(getClass());
    private static final int TEXT_TYPE_MSG = 4;
    private static final String INITIAL_MSG_ID = "0";

    @Autowired
    private Properties accountProps;

    @Autowired
    private AnswerSmsDao smsDao;

    private WebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap_PortType service;

    public void setAccountProps(Properties accountProps) {
        this.accountProps = accountProps;
    }

    public void afterPropertiesSet() throws Exception {
        WebService_GP_ADP_BizTalk_SMS_Orchestrations locator = new WebService_GP_ADP_BizTalk_SMS_OrchestrationsLocator();
        service = locator.getWebService_GP_ADP_BizTalk_SMS_OrchestrationsSoap();
    }

    private SendSMSRequest makeSendRequest(String sourceMsisdn, String destinationMsisdn, String content) {
        SendSMSRequest request =  new SendSMSRequest();
        request.setRegistrationID(accountProps.getProperty("registration.id"));
        request.setPassword(accountProps.getProperty("account.password"));
        request.setSourceMsisdn(sourceMsisdn);
        request.setSmsPort(accountProps.getProperty("send.sms.port"));
        request.setMsgType(TEXT_TYPE_MSG);
        request.setContentArea("test");
        request.setChargedParty(destinationMsisdn);
        request.setCharge(0);

        request.setDestinationMsisdn(destinationMsisdn);
        request.setMsgContent(content);

        return request;
    }
    private ReceiveSMSRequest makeReceiveRequest(String msgId) {
        ReceiveSMSRequest request = new ReceiveSMSRequest();
        request.setRegistrationID(accountProps.getProperty("registration.id"));
        request.setPassword(accountProps.getProperty("account.password"));
        request.setSmsPort(accountProps.getProperty("receive.sms.port"));
        request.setMsgID(msgId);
        return request;
    }

    @Async
    public void sendSms(AnswerSms answerSms) {
        String destination = answerSms.getDestination();
        String source = answerSms.getSource();
        String content = answerSms.getAnswer().length() > 160
                ? answerSms.getAnswer().substring(0, 159)
                : answerSms.getAnswer();

        SendSMSRequest request = makeSendRequest(source, destination, content);
        try {
            logger.debug("Sending Sms - destination={}, source={}, content={}",
                    new Object[] {destination, source, content});
            SendSMSResponse resp = service.sendSMS(request);
            answerSms.setSent(true);
            answerSms.setResponseMsgId(resp.getMsgID());
            answerSms.setResponseStatus(resp.getStatus());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        } finally {
            smsDao.save(answerSms);
        }
    }

    public List<ReceiveSMSResponse> receiveSms() {
        String msgId = INITIAL_MSG_ID;
        List<ReceiveSMSResponse> responses = new ArrayList<ReceiveSMSResponse>();
        try {
            while (true) {
                ReceiveSMSRequest request = makeReceiveRequest(msgId);
                ReceiveSMSResponse resp = service.getReceivedSMS(request);
                logger.debug("SMSResponse received, msgId={}, msgSender={}, msgContent={}",
                        new Object[] {resp.getMsgID(), resp.getSenderMSISDN(), resp.getMsgContent()});

                if (!resp.getMsgID().trim().equals(INITIAL_MSG_ID)) {
                    msgId = resp.getMsgID();
                    responses.add(resp);
                } else {
                    break;
                }
            }
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }
        return responses;
    }

    @Async
    public void sendAcknowldgement(List<AppUser> users) {
        for (AppUser user: users) {
            String content = "Question received. You can also Log on to " + accountProps.getProperty("application.url") 
                    + ", with user id=" + user.getUserId()
                    + " and password=" + user.getPassword();
            SendSMSRequest request =
                    makeSendRequest(accountProps.getProperty("registered.phone.number"), user.getPhoneNumber(), content);
            try {
                logger.debug("Sending Acknowledgement to={}", user.getPhoneNumber());
                SendSMSResponse resp = service.sendSMS(request);
                logger.debug("Received Acknowledgement Response, status={}, msgId={}", resp.getStatus(), resp.getMsgID());
            } catch (RemoteException e) {
                logger.error(e.getMessage());
            }
        }
    }
}

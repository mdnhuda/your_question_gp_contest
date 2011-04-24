package org.questions.service;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.questions.domain.Persistent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * mdnhuda@gmail.com
 * Date: Jul 2, 2010
 */
public class PersistentInterceptor extends EmptyInterceptor {
    Logger logger = LoggerFactory.getLogger(getClass());

    private static String PROP_DATE_CREATED = "dateCreated";
    private static String PROP_DATE_UPDATED = "lastUpdated";

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        logger.debug("in onSave");
        if (entity instanceof Persistent) {
            for (int i = 0; i < propertyNames.length; i++) {
                if (propertyNames[i].equals(PROP_DATE_CREATED) || propertyNames[i].equals(PROP_DATE_UPDATED)) {
                    state[i] = new Timestamp(new Date().getTime());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        logger.debug("in onFlushDirty");
        if (entity instanceof Persistent) {
            for (int i = 0; i < propertyNames.length; i++) {
                if (propertyNames[i].equals(PROP_DATE_UPDATED)) {
                    currentState[i] = new Timestamp(new Date().getTime());
                    return true;
                }
            }
        }
        return false;
    }
}

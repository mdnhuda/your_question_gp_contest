package org.questions.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * mdnhuda@gmail.com
 * Date: Jul 2, 2010
 */
@MappedSuperclass
public abstract class Persistent implements Serializable {
    long version;
    Date dateCreated;
    Date lastUpdated;

    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(updatable = false)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

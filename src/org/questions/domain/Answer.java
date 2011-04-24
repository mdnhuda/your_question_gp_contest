package org.questions.domain;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.search.annotations.*;

import javax.persistence.*;

/**
 * mdnhuda@gmail.com
 * Date: Jul 2, 2010
 */
@Entity
public class Answer extends Persistent {
    private Long id;
    private String text;
    private AppUser createdBy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Fields({
            @Field(name = "text", store = Store.YES),
            @Field(name = "text_stem", analyzer = @Analyzer(definition = "englishSnowball"), store = Store.YES)
    })
    @ContainedIn
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    @LazyToOne(org.hibernate.annotations.LazyToOneOption.FALSE)
    public AppUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(AppUser createdBy) {
        this.createdBy = createdBy;
    }
}

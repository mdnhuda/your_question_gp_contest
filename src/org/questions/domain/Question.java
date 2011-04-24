package org.questions.domain;

import org.apache.solr.analysis.LowerCaseFilterFactory;
import org.apache.solr.analysis.SnowballPorterFilterFactory;
import org.apache.solr.analysis.StandardFilterFactory;
import org.apache.solr.analysis.StandardTokenizerFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * mdnhuda@gmail.com
 * Date: Jul 2, 2010
 */
@Entity
@Indexed
@AnalyzerDef(
        name = "englishSnowball",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = StandardFilterFactory.class),
                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                @TokenFilterDef(factory = SnowballPorterFilterFactory.class,
                        params = @Parameter(name = "language", value = "English"))
        })
@SuppressWarnings("unused")
public class Question extends Persistent {
    private Long id;
    private Status status;
    private String category;
    private boolean receivedAsSms;
    private String text;
    List<Answer> answers;
    private AppUser createdBy;

    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(nullable = true)
    @Fields({
            @Field(name = "category", store = Store.YES),
            @Field(name = "category_stem", analyzer = @Analyzer(definition = "englishSnowball"), store = Store.YES)
    })
    @Boost(value = 2.0f)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "received_as_sms", updatable = false)
    public boolean isReceivedAsSms() {
        return receivedAsSms;
    }

    @Column(length = 1000, nullable = false)
    @Fields({
            @Field(name = "text", store = Store.YES),
            @Field(name = "text_stem", analyzer = @Analyzer(definition = "englishSnowball"), store = Store.YES)
    })
    public String getText() {
        return text;
    }

    public void setReceivedAsSms(boolean receivedAsSms) {
        this.receivedAsSms = receivedAsSms;
    }

    public void setText(String text) {
        this.text = text;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "question_id")
    @IndexColumn(name = "idx")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @IndexedEmbedded
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {
        if (answers == null) {
            answers = new ArrayList<Answer>();
        }
        answers.add(answer);
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

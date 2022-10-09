package com.java.wikipedia.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "project_id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "writing")
    private String writing;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "update_time")
    private Date updateTime;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_updater",joinColumns = @JoinColumn(name = "project_id"),
                    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Member> members;



}

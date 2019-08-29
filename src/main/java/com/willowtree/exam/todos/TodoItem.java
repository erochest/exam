package com.willowtree.exam.todos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private ZonedDateTime created;
    private ZonedDateTime completed;
    private String description;
    private String notes;

    public TodoItem() {
    }

    public TodoItem(ZonedDateTime created, ZonedDateTime completed, String description, String notes) {
        this.created = created;
        this.completed = completed;
        this.description = description;
        this.notes = notes;
    }

    // public TodoItem(@JsonProperty("description") String description) {
    // this.created = ZonedDateTime.now(ZoneId.of("UTC"));
    // this.completed = null;
    // this.description = description;
    // this.notes = null;
    // }

    public TodoItem(@JsonProperty("description") String description, @JsonProperty("notes") String notes) {
        this.created = ZonedDateTime.now(ZoneId.of("UTC"));
        this.completed = null;
        this.description = description;
        this.notes = notes;
    }

    public ZonedDateTime markComplete() {
        this.completed = ZonedDateTime.now(ZoneId.of("UTC"));
        return this.completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public ZonedDateTime getCompleted() {
        return completed;
    }

    public void setCompleted(ZonedDateTime completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

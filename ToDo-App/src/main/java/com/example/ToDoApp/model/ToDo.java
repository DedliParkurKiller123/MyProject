package com.example.ToDoApp.model;

import jakarta.annotation.Nonnull;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.processing.Generated;
import java.util.Date;
@Entity
@Table (name="todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nonnull
    private Long id;
    
    @Column(name="Title_of_action")
    @Nonnull
    private String title;
    
    @Column(name="Date")
    @Nonnull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    @Column(name="Status_of_action")
    @Nonnull
    private String status;

    public ToDo(){

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

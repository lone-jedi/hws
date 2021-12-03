package org.campus.hws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Getter
@Builder
@AllArgsConstructor
public class Task {
    private int id;
    private String name;
    private String description;
    private Date deadline;
    private boolean is_active;
    private LocalDateTime publish_date;

    public Task(String name) {
        this.name = name;
    }

    public Task(String name, String description) {
        this(name);
        this.description = description;
    }

    public Task(String name, Date deadline) {
        this(name);
        this.deadline = deadline;
    }

    public Task(String name, String description, Date deadline) {
        this(name, description);
        this.deadline = deadline;
    }
}

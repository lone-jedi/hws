package org.campus.hws.dao;

import org.campus.hws.entity.Task;

import java.util.List;

public interface TaskDao {
    List<Task> getAll();

    // Returns id of added task
    int add(Task task);

    void update(int id, Task newTask);

    void delete(int id);
}

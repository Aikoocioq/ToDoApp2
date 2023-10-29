package pl.edu.pb.todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {
    private static TaskStorage taskStorage = new TaskStorage();
    private List<Task> tasks;
    public static TaskStorage getInstance() {
        return taskStorage;
    }
    private TaskStorage() {
        tasks = new ArrayList<Task>();
        for (int i = 1; i <= 110; ++i) {
            Task task = new Task();
            task.setName("Pilne zadanie numer " + i);
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public Task getTask(UUID id) {
        for (Task task : tasks) {
            if (task.getId().equals(id))
                return task;
        }
        return null;
    }
}

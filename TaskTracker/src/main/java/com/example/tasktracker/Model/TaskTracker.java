package com.example.tasktracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskTracker {
    private int id;
    private String title;
    private String description;
    private String status;


}

package com.example.tasktracker.Controller;

import com.example.tasktracker.ApiResponse.ApiResponse;
import com.example.tasktracker.Model.TaskTracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/TaskTracker")
public class TaskTrackerController {

    ArrayList<TaskTracker> taskTrackers = new ArrayList<>();


    @PostMapping("/add")
    public ApiResponse addTaskTracker(@RequestBody TaskTracker taskTracker) {
        taskTrackers.add(taskTracker);
        return new ApiResponse("TaskTracker added successfully");
    }

    @GetMapping("/get")
    public ArrayList<TaskTracker> getTaskTrackers() {
        return taskTrackers;
    }

    @PutMapping("/update/{index}")
    public ApiResponse upDateTaskTracker(@PathVariable int index, @RequestBody TaskTracker taskTracker) {
        taskTrackers.set(index, taskTracker);
        return new ApiResponse("TaskTracker updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTaskTracker(@PathVariable int index) {
        taskTrackers.remove(index);
        return new ApiResponse("TaskTracker deleted successfully");
    }

    @PutMapping("/change-status/{index}")
    public ApiResponse changeStatus(@PathVariable int index) {
        if (taskTrackers.get(index).getStatus().equalsIgnoreCase("not done")) {
            taskTrackers.get(index).setStatus("done");}
        return new ApiResponse("TaskTracker status changed successfully");
    }

    @GetMapping("/search/{title}")
    public ArrayList<TaskTracker> searchTitle(@PathVariable String title) {
        ArrayList<TaskTracker>  searchesult = new ArrayList<>();
        boolean is_found = false;
        for (TaskTracker a : taskTrackers) {
            if (a.getTitle().equalsIgnoreCase(title)) {
                searchesult.add(a);
                is_found = true; break;}
        }
        if (is_found) return searchesult;
        else return null;
    }
}
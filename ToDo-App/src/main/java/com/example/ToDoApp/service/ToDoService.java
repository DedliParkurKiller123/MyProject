package com.example.ToDoApp.service;

import com.example.ToDoApp.model.ToDo;
import com.example.ToDoApp.repo.IToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    IToDoRepo repo;
    public List<ToDo> getAllToDoItems(){
        List<ToDo> todolist = new ArrayList<ToDo>();
        repo.findAll().forEach(toDo -> todolist.add(toDo));
        return todolist;
    }

    public ToDo getToDoItemById(Long id){
        return repo.findById(id).get();
    }

    public boolean updateStatus(Long id){
        ToDo todo = getToDoItemById(id);
        todo.setStatus("Completed");

        return saveOrUpdateToDoItem(todo);
    }

    public boolean saveOrUpdateToDoItem(ToDo todo){
        ToDo updateObj = repo.save(todo);

        return getToDoItemById(updateObj.getId()) != null;
//       return  (getToDoItemById(updateObj.getId()) != null)? true: false;
    }

    public boolean deleteToDoItem(Long id){
        repo.deleteById(id);
        return repo.findById(id).isEmpty();
    }
}

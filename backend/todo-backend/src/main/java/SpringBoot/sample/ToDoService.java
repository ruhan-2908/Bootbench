package SpringBoot.sample;


import SpringBoot.sample.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository todorepo;

    public Todo createTodo(Todo todo)
    {
        return todorepo.save(todo);
    }
    public List<Todo> getalltodos()
    {
        return todorepo.findAll();
    }

    public Page<Todo> getAllTodoPages(int page, int size)
    {
        Pageable pageable = PageRequest.of(page,size);
        return todorepo.findAll(pageable);
    }
    public Todo getTodoById(Long id)
    {
        return todorepo.findById(id).orElseThrow(()->new RuntimeException("Todo not found"));
    }
    public Todo updateTodo(Todo todo)
    {
        return todorepo.save(todo);
    }
    public void detetetodo(Long id)
    {
        todorepo.delete(getTodoById(id));
    }
}

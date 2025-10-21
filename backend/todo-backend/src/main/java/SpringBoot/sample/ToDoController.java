package SpringBoot.sample;

import SpringBoot.sample.models.Todo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ToDoController {
    @Autowired
    private ToDoService todoservice;
    @GetMapping("/{id}")
    ResponseEntity<Todo> getbyid(@PathVariable long id)
    {
        try{
            Todo createdTodo = todoservice.getTodoById(id);
            return new ResponseEntity<>(todoservice.getTodoById(id),HttpStatus.OK);
        }catch(RuntimeException exception)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    ResponseEntity<List<Todo>> getTodos()
    {
        return new ResponseEntity<List<Todo>>(todoservice.getalltodos(),HttpStatus.OK);
    }
    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getTodosPages(@RequestParam int page, @RequestParam int size)
    {
        return new ResponseEntity<>(todoservice.getAllTodoPages(page,size),HttpStatus.OK);
    }
    @PostMapping("/create")
    ResponseEntity<Todo> createuser(@RequestBody Todo todo)
    {
        return new ResponseEntity<>(todoservice.createTodo(todo),HttpStatus.OK);
    }
    @PutMapping
    ResponseEntity<Todo> putwithid(@RequestBody Todo todo)
    {
       return  new ResponseEntity<>(todoservice.updateTodo(todo),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    void deletewithid(@PathVariable long id)
    {
        todoservice.detetetodo(id);
    }
}

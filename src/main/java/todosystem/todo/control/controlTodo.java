package todosystem.todo.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import todosystem.todo.Service.todoService;
import todosystem.todo.model.ToDo;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/todos")
public class controlTodo {

    private final todoService todoService;

    public controlTodo(todosystem.todo.Service.todoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public ResponseEntity<List<ToDo>> DisplayTopic(){
        List<ToDo> todo =todoService.displayAllTopic();
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> DisplayOneTopic(@PathVariable("id") Long id){
        ToDo todo =todoService.getOneTopic(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ToDo> addNewTopic(@RequestBody ToDo toDo){
        ToDo todo =todoService.addTopic(toDo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> UpdateTopic(@PathVariable("id") Long id ,@RequestBody ToDo toDo){
        ToDo todo =todoService.updateTopic(id,toDo);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id )
    {
        todoService.deletebyid(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

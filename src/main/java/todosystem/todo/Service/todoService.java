package todosystem.todo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todosystem.todo.model.ToDo;
import todosystem.todo.repos.repTodo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class todoService {
    @Autowired
    private final repTodo repTodo;

    public todoService(todosystem.todo.repos.repTodo repTodo) {
        this.repTodo = repTodo;
    }

    public List<ToDo> displayAllTopic()
    {
        return  repTodo.findAll();
    }


    public ToDo getOneTopic(Long id)
    {
        ToDo existTodo=repTodo.findById(id).orElseThrow(() -> new NoSuchElementException("todo not found"+id));
        return existTodo;
    }

    public ToDo addTopic(ToDo todo)
    {
        return repTodo.save(todo);
    }

     public ToDo updateTopic(Long id,ToDo todo)
     {
         ToDo existTodo=repTodo.findById(id).orElseThrow(() -> new NoSuchElementException("todo not found"+id));
         existTodo.setName(todo.getName());
         existTodo.setDescription(todo.getDescription());
         return repTodo.save(existTodo);
     }

    public void deletebyid(Long id) {
//        repTodo.deleteToDoById(id);
        repTodo.deleteById(id);
    }



}

package todosystem.todo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import todosystem.todo.model.ToDo;

import java.util.Optional;

public interface repTodo extends JpaRepository<ToDo, Long> {


    void deleteToDoById(Long id);
}

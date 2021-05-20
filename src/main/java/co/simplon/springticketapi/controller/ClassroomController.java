package co.simplon.springticketapi.controller;

import co.simplon.springticketapi.dao.ClassroomDao;
import co.simplon.springticketapi.model.Classroom;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/classrooms")
@RestController
@CrossOrigin(origins = "*")
public class ClassroomController {

    private ClassroomDao classroomDao;

    public ClassroomController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomDao.getAll();
    }

    @GetMapping("/{id}")
    public Classroom getClassroom(@PathVariable Long id) {
        return classroomDao.get(id);
    }

    @PostMapping
    public Classroom saveClassroom(@RequestBody Classroom classroom) {
        return classroomDao.save(classroom);
    }

    @DeleteMapping("/{id}")
    public void deleteClassroom(@PathVariable Long id) {
        classroomDao.delete(id);
    }

}

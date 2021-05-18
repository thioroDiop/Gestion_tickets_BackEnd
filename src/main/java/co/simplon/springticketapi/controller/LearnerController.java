package co.simplon.springticketapi.controller;

import co.simplon.springticketapi.dao.LearnerDao;
import co.simplon.springticketapi.model.Learner;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learners")
public class LearnerController {

    private LearnerDao learnerDao;

    public LearnerController(LearnerDao learnerDao) {
        this.learnerDao = learnerDao;
    }

    // La liste des apprenants
    @GetMapping
    public List<Learner> getAllLearners() {
        return learnerDao.getAll();
    }

    // Un apprenant par son ID
    @GetMapping("/{id}")
    public Learner getLearnerById(@PathVariable Long id) {
        return learnerDao.get(id);
    }

    @GetMapping("/most-helped")
    public Learner getMostHelpedLearner() {
        return learnerDao.getMostHelped();
    }

    // Créer un apprenant
    @PostMapping
    public Learner createLearner(@RequestBody Learner learnerToCreate) {
        return learnerDao.save(learnerToCreate);
    }

    // Supprimer un apprenant
    @DeleteMapping("/{id}")
    public void deleteLearner(@PathVariable Long id) {
        learnerDao.delete(id);
    }

}

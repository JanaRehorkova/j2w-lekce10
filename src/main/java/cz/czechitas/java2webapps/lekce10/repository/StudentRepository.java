package cz.czechitas.java2webapps.lekce10.repository;

import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

/**
 */
@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer> {
    List<Student> findByOrderByPrijmeniAsc();

    List<Student> findByTridaOrderByPrijmeni(Trida trida);

    Student findByIdIs(Integer id);

}

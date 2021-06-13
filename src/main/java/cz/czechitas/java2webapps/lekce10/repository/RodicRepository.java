package cz.czechitas.java2webapps.lekce10.repository;

import cz.czechitas.java2webapps.lekce10.entity.Rodic;
import cz.czechitas.java2webapps.lekce10.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.OrderBy;
import java.util.List;

/**
 *
 */
@Repository
public interface RodicRepository extends JpaRepository<Rodic, Integer> {
    List<Rodic> findAllByDetiOrderByPrijmeniAscJmenoAsc(Student student);

}

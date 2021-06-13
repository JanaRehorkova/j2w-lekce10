package cz.czechitas.java2webapps.lekce10.service;


import cz.czechitas.java2webapps.lekce10.entity.Rodic;
import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.repository.RodicRepository;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkolaService {
    private final TridaRepository tridaRepository;
    private final StudentRepository studentRepository;
    private final RodicRepository rodicRepository;

    @Autowired
    public SkolaService(TridaRepository tridaRepository, StudentRepository studentRepository, RodicRepository rodicRepository) {
        this.tridaRepository = tridaRepository;
        this.studentRepository = studentRepository;
        this.rodicRepository = rodicRepository;
    }

    public List<Trida> listvsechtrid() {
        return tridaRepository.findByOrderByNazev();
    }

    public Trida konretniTrida(String nazevTridy) {
        return tridaRepository.findByNazev(nazevTridy);
    }

    public List<Student> studentiVeTride(Trida trida) {
        return studentRepository.findByTridaOrderByPrijmeniAscJmenoAsc(trida);
    }

    public Student konkretniStudent(Integer id) {
        return studentRepository.findByIdIs(id);
    }

    public List<Rodic> rodiceStudenta(Student student) {
        return rodicRepository.findAllByDetiOrderByPrijmeniAscJmenoAsc(student);
    }


}

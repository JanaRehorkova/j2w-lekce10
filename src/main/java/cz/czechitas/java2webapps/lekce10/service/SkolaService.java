package cz.czechitas.java2webapps.lekce10.service;


import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkolaService {
   private final TridaRepository tridaRepository;
   private final StudentRepository studentRepository;


   @Autowired
    public SkolaService(TridaRepository tridaRepository, StudentRepository studentRepository) {
        this.tridaRepository = tridaRepository;
        this.studentRepository=studentRepository;

    }


  public List<Trida> listvsechtrid() {
      return tridaRepository.findByOrderByNazev();
  }

  public Trida konretniTrida(String nazevTridy){
       return tridaRepository.findByNazev(nazevTridy);
  }

  public List<Student> studentiVeTride(Trida trida){
       return studentRepository.findByTridaOrderByPrijmeni(trida);
  }

  public Student konkretniStudent(Integer id){
       return studentRepository.findByIdIs(id);
  }



}

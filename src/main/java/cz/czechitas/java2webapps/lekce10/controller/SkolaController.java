package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.service.SkolaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SkolaController {
private final SkolaService service;

    public SkolaController(SkolaService service) {
        this.service = service;
    }

  @GetMapping("/")
 public ModelAndView seznamTrid(){
        return new ModelAndView("seznam")
                .addObject("vsechnytridy",service.listvsechtrid());
  }

  @GetMapping("/{nazevTridy}")
    public ModelAndView detailTridy(@PathVariable String nazevTridy) {
      Trida trida = service.konretniTrida(nazevTridy);
      return new ModelAndView("detailtridy")
              .addObject("detailTrida", service.konretniTrida(nazevTridy))
              .addObject("listStudentu", service.studentiVeTride(trida));
  }

   @GetMapping("/nazevTridy/{id}")
    public ModelAndView detailStudenta(@PathVariable Integer id){
       return new ModelAndView("detailstudenta")
               .addObject("konkretniStudent",service.konkretniStudent(id));
      }

  }




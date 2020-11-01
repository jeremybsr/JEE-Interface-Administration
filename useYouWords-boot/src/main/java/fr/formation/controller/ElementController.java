package fr.formation.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.formation.model.Element;
import fr.formation.service.ElementService;


@Controller
@RequestMapping("/element")
public class ElementController {
	
	@Autowired
    private ElementService elementService;
    
	/*
	 * Méthode permettant de récupérer la list d'élément
	 * et de l'afficher dans la vue element/list
	 */
    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("elements", this.elementService.findAll());
        return "element/list";
    }

    @GetMapping("/add")
    public String add() {
        return "element/form";
    }
    
    /*
     * Méthode permettant d'ajouter un nouvel élément
     */
    @PostMapping("/add")
	public String add(Element element, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
    	System.out.println(file);
    	if(file.isEmpty()) {
    		this.elementService.odd(element);
		
    	}else {
    		this.elementService.add(element, file);
    	}
		return "redirect:./list";
	}

    public ElementService getElementService() {
		return elementService;
	}

	public void setElementService(ElementService elementService) {
		this.elementService = elementService;
	}
	
	/*
	 * Méthode permettant de modifier un élément
	 */
	@GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("element", this.elementService.findById(id));

        return "element/form";
    }
	/*
	 * Méthode permettant de modifier un élément à partir de son id 
	 */
    @PostMapping("/edit")
	public String update(@RequestParam int id, Element element) {
		this.elementService.edit(id, element);
		
		return "redirect:./list";
	}

    /*
     * Méthode permettant de supprimer un élément à partir de son id
     */
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        this.elementService.deleteById(id);

        return "redirect:../list";
    }  
}

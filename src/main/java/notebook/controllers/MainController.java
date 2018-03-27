package notebook.controllers;

import notebook.models.AddNoteForm;
import notebook.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("notes", noteService.findAll());
        return "index";
    }

    @PostMapping("/addNote")
    public String addNote(Model model, @RequestBody AddNoteForm addNoteForm) {
        noteService.saveNoteForm(addNoteForm);
        model.addAttribute("notes", noteService.findAll());
        System.out.println("Note added!");
        return "index";
    }
}
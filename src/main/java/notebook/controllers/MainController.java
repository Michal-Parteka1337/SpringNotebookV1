package notebook.controllers;

import notebook.models.AddNoteForm;
import notebook.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    NoteService noteService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("notes", noteService.findAll());
        return "index";
    }

    @PostMapping("/addNote")
    public String addNote(Model model, @RequestBody AddNoteForm addNoteForm) {
        //exampleService.fakeAuthenticate(addNoteForm) -- Test/Authentication
        noteService.saveNoteForm(addNoteForm);
        model.addAttribute("notes", noteService.findAll());
        System.out.println("Note added!");
        return "index";
    }
}
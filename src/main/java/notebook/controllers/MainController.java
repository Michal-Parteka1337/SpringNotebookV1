package notebook.controllers;

import notebook.models.AddNoteForm;
import notebook.models.Note;
import notebook.repositiories.NoteRepository;
import notebook.services.AddNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@Controller
public class MainController {
    @Autowired
    AddNoteService addNoteService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("notes", addNoteService.getNotes());
        return "index";
    }

    @PostMapping("/addNote")
    public String postController(Model model, @RequestBody AddNoteForm addNoteForm) {
        //exampleService.fakeAuthenticate(addNoteForm) -- Test/Authentication
        addNoteService.addNote(addNoteForm);
        model.addAttribute("notes", addNoteService.getNotes());
        System.out.println("Note added!");
        return "index";
    }
}
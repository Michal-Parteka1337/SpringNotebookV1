package notebook.controllers;

import notebook.models.AddNoteForm;
import notebook.models.Note;
import notebook.repositiories.NoteRepository;
import notebook.services.AddNoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@Controller
public class MainController {
    AddNoteService addNoteService = new AddNoteService();

    @RequestMapping("/")
    public String index(Locale locale, Model model) {
        Note initialNote = new Note("Initial Note", "Initial note", "high");
        //ArrayList<Note> noteList = new ArrayList<Note>();

        addNoteService.noteRepository.addNote(initialNote);
        model.addAttribute("notes", addNoteService.noteRepository.getNotes());
        return "index";
    }

    @PostMapping("/addNote")
    public ResponseEntity postController(@RequestBody AddNoteForm addNoteForm) {
        //exampleService.fakeAuthenticate(addNoteForm) -- Test/Authentication
        addNoteService.addNote(addNoteForm);
        System.out.println("Note added!");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/getNotes")
    public String getNotes() {

        return "/getNotes";
    }
}
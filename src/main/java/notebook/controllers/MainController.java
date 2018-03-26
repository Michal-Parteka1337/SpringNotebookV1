package notebook.controllers;

import com.sun.org.apache.xpath.internal.SourceTree;
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

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/addNote")
    public ResponseEntity postController(@RequestBody AddNoteForm addNoteForm, Model model) {
        //exampleService.fakeAuthenticate(addNoteForm) -- Test/Authentication
        AddNoteService addNoteService = new AddNoteService();
        addNoteService.addNote(addNoteForm);
        model.addAttribute("notes", addNoteService.noteRepository.getNotes());
        System.out.println("Note added!");
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
package notebook.controllers;

import notebook.models.AddNoteForm;
import notebook.models.Note;
import notebook.services.AddNoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/addNote")
    public ResponseEntity postController(@RequestBody AddNoteForm addNoteForm) {
        //exampleService.fakeAuthenticate(addNoteForm) -- Test/Authentication
        AddNoteService addNoteService = new AddNoteService();
        addNoteService.addNote(addNoteForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
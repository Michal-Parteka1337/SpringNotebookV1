package notebook.controllers;

import notebook.models.AddNoteForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/addNote")
    public ResponseEntity postController(@RequestBody AddNoteForm addNoteForm) {
        //exampleService.fakeAuthenticate(addNoteForm) -- Test/Authentication
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
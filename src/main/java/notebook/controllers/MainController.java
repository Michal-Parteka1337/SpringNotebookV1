package notebook.controllers;

import notebook.models.AddNoteForm;
import notebook.models.User;
import notebook.services.NoteService;
import notebook.services.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model) {
        User janusz = userService.findByName("Janusz");
        model.addAttribute("notes", noteService.findAll());
        model.addAttribute("user", janusz);
        return "index";
    }

    @PostMapping("/addNote")
    public String addNote(Model model, @RequestBody AddNoteForm addNoteForm) {
        noteService.saveNoteForm(addNoteForm);
        User user = userService.findByName(addNoteForm.getUserName());
        model.addAttribute("user", user);
        model.addAttribute("notes", noteService.findAll());
        return "index";
    }
}
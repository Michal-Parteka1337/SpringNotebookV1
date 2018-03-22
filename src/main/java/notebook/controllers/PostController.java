package notebook.controllers;

import notebook.models.AddNoteForm;
import notebook.models.ResponseTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/post")
public class PostController {

    @PostMapping("/response")
    @ResponseBody
    public ResponseTransfer postResponseController(@RequestBody AddNoteForm addNoteForm) {
        return new ResponseTransfer("Note added!");
    }
}

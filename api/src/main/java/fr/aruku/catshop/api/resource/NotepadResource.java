package fr.aruku.catshop.api.resource;

import fr.aruku.catshop.api.domain.Notepad;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notepad")
public class NotepadResource {

    private Notepad current = new Notepad("dummy content");

    @RequestMapping(
            value = {"", "/"},
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"}
    )
    public Notepad getCurrentNotepad() {
        return current;
    }

    @RequestMapping(
            value = {"", "/"},
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = {}
    )
    public void modifyCurrentNotepad(
            @RequestParam(value = "content", required = true) String content
    ){
        current.setContent(content);
    }
}

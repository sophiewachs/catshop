package fr.aruku.catshop.api.resource;

import fr.aruku.catshop.api.dao.NotepadRepository;
import fr.aruku.catshop.api.dao.UserRepository;
import fr.aruku.catshop.api.domain.Notepad;
import fr.aruku.catshop.api.domain.User;
import fr.aruku.catshop.api.notifications.RequestNotificationHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notepad")
public class NotepadResource {

    private NotepadRepository notepadRepository;
    private UserRepository userRepository;

    @Autowired
    public NotepadResource(NotepadRepository notepadRepository, UserRepository userRepository) {
        this.notepadRepository = notepadRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(
            value = {"", "/"},
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"}
    )
    public Iterable<Notepad> search(
            @RequestParam(value = "q", required = false, defaultValue = "") String query
    ) {
        if (StringUtils.isEmpty(query)) {
            return notepadRepository.findAll();
        } else {
            return notepadRepository.findByContent(query);
        }
    }

    @RequestMapping(
            value = {"/{uuid}", "/{uuid}/"},
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"}
    )
    public Notepad getByUuid(@PathVariable String uuid) {
        return notepadRepository.findByUserUuid(uuid);
    }

    @RequestMapping(
            value = {"/{uuid}", "/{uuid}/"},
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = {}
    )
    public void modifyNotepads(
            @PathVariable String uuid,
            @RequestParam(value = "content", required = true) String content
    ){
        Notepad notepad = notepadRepository.findByUserUuid(uuid);
        if (notepad == null) {
            notepad = new Notepad();
            User user = userRepository.save(new User(uuid));
            notepad.setUser(user);
        }
        notepad.setContent(content);
        notepadRepository.save(notepad);
    }
}

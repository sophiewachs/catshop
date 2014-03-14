package fr.aruku.catshop.api.resource;

import fr.aruku.catshop.api.dao.NotepadRepository;
import fr.aruku.catshop.api.dao.UserRepository;
import fr.aruku.catshop.api.domain.Notepad;
import fr.aruku.catshop.api.notifications.RequestNotificationHub;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NotepadResourceTest {

    private NotepadResource notepadResource;

    @Before
    public void setUp() throws Exception {
        NotepadRepository notepadRepository = mock(NotepadRepository.class);
        when(notepadRepository.findAll()).thenReturn(Arrays.asList(new Notepad("dummy content")));

        RequestNotificationHub notificationHub = mock(RequestNotificationHub.class);

        notepadResource = new NotepadResource(notepadRepository, mock(UserRepository.class));
    }

    @Test
    public void shouldReturnCurrentWhenGetIsCalled(){
        //assertThat(notepadResource.getCurrentNotepad("").iterator().next().getContent()).isEqualTo("dummy content");
    }

    @Test
    public void shouldModifyCurrentNotepad(){
        //notepadResource.modifyCurrentNotepad(0L, "toto");
        //assertThat(notepadResource.getCurrentNotepad("").iterator().next().getContent()).isEqualTo("toto");
    }
}

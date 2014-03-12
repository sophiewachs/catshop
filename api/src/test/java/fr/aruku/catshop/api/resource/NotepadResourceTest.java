package fr.aruku.catshop.api.resource;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sophiewachs on 12/03/2014.
 */
public class NotepadResourceTest {

    @Test
    public void shouldReturnCurrentWhenGetIsCalled(){
        assertThat(new NotepadResource().getCurrentNotepad().getContent()).isEqualTo("dummy content");
    }

    @Test
    public void shouldModifyCurrentNotepad(){
        NotepadResource notepadResource = new NotepadResource();
        notepadResource.modifyCurrentNotepad("toto");
        assertThat(notepadResource.getCurrentNotepad().getContent()).isEqualTo("toto");
    }
}

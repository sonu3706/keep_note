package com.keepnote.service;

import com.keepnote.model.Note;
import com.keepnote.model.UserNote;

public interface NoteService {
    Boolean createNote(Note note);
    UserNote getAllNotesByUserId(String userId);
    Boolean deleteNoteByUserId(String userId);
    Boolean updateNoteByUserId(String userId, Note note);
}

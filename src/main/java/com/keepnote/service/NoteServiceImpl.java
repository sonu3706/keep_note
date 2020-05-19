package com.keepnote.service;

import com.keepnote.model.Note;
import com.keepnote.model.UserNote;

import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Dependent
public class NoteServiceImpl implements NoteService {

    public NoteServiceImpl() {
    }

    @Override
    @Transactional
    public Boolean createNote(Note note) {
        boolean createdStatus = false;
        UserNote userNote = null;
        List<Note> notes = null;
        if (note != null) {
            userNote = this.getUserNoteObject(note.getCreatedBy());
            if (userNote != null && userNote.notes != null) {
                note.setNoteId(UUID.randomUUID().toString());
                note.setCreatedOn(LocalDateTime.now());
                userNote.notes.add(note);
            } else {
                userNote = new UserNote();
                notes = new ArrayList<>();
                note.setNoteId(UUID.randomUUID().toString());
                note.setCreatedOn(LocalDateTime.now());
                notes.add(note);
                userNote.userId = note.getCreatedBy();
                userNote.notes = notes;

            }
            userNote.persist();
            createdStatus = true;
        }
        return createdStatus;
    }

    @Override
    @Transactional
    public UserNote getAllNotesByUserId(String userId) {
        UserNote userNote = null;
        Note note = new Note();
        note.setCreatedBy(userId);
        System.out.println(this.getUserNoteObject(note.getCreatedBy()));
        userNote = this.getUserNoteObject(note.getCreatedBy());

        return userNote;
    }

    @Override
    public Boolean deleteNoteByUserId(String userId) {
        return null;
    }

    @Override
    public Boolean updateNoteByUserId(String userId, Note note) {
        return null;
    }

    private UserNote getUserNoteObject(String userId) {
        return UserNote.findByUserId(userId);
    }
}

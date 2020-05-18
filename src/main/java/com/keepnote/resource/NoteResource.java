package com.keepnote.resource;

import com.keepnote.model.Note;
import com.keepnote.service.NoteService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*JAX-RS imports*/

@Path("/api/notes")
@Produces(MediaType.APPLICATION_JSON)
public class NoteResource {

    private NoteService noteService;

    @Inject
    public NoteResource( NoteService noteService) {
        this.noteService = noteService;
    }

    @POST
    public Response createNote( Note note) {
        return Response.ok(this.noteService.createNote(note)).build();
    }

    @GET
    @Path(value = "/{userId}")
    public Response getAllNotesByUserId(@PathParam("userId") String userId) {
        return Response.ok(this.noteService.getAllNotesByUserId(userId)).build();
    }

    @DELETE
    @Path(value = "/{userId}")
    public Response deleteNoteByUserId( @PathParam("userId") String userId ) {
        return Response.ok().build();
    }

    @PUT
    @Path(value = "/{userId}")
    public Response updateNoteByUserId( @PathParam("userId") String userId, @Valid Note note ) {
        return Response.ok().build();
    }
}

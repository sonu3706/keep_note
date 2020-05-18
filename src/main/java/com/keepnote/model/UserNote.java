package com.keepnote.model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

@MongoEntity(collection = "userNote")
public class UserNote extends PanacheMongoEntity {
    public String userId;
    public List<Note> notes;

    public static UserNote findByUserId(String userId) {
        return find("userId like ?1t", "%" + userId + "%").firstResult();
    }

    @Override
    public String toString() {
        return "UserNote{" +
                "userId='" + userId + '\'' +
                ", notes=" + notes +
                '}';
    }
}

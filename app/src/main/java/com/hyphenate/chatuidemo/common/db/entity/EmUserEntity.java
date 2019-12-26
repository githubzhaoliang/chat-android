package com.hyphenate.chatuidemo.common.db.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;

import com.hyphenate.easeui.domain.EaseUser;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "em_users", primaryKeys = {"username"},
        indices = {@Index(value = {"username"}, unique = true)})
public class EmUserEntity extends EaseUser {

    @Ignore
    public static List<EmUserEntity> parseList(List<EaseUser> users) {
        List<EmUserEntity> entities = new ArrayList<>();
        if(users == null || users.isEmpty()) {
            return entities;
        }
        EmUserEntity entity;
        for (EaseUser user : users) {
            entity = parseParent(user);
            entities.add(entity);
        }
        return entities;
    }

    @Ignore
    public static EmUserEntity parseParent(EaseUser user) {
        EmUserEntity entity = new EmUserEntity();
        entity.setUsername(user.getUsername());
        entity.setNickname(user.getNickname());
        entity.setAvatar(user.getAvatar());
        entity.setInitialLetter(user.getInitialLetter());
        return entity;
    }
}

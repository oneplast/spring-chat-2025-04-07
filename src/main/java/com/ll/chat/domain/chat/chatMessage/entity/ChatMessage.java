package com.ll.chat.domain.chat.chatMessage.entity;

import com.ll.chat.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat.global.jpa.BaseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {

    @ManyToOne
    private ChatRoom chatRoom;

    private String writerName;

    private String content;
}

package com.ll.chat20231104.domain.chat.chatMessage.service;

import com.ll.chat20231104.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chat20231104.domain.chat.chatMessage.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    public List<ChatMessage> findByChatRoomIdAndIdAfter(long roomId, long afterId) {
        return chatMessageRepository.findByChatRoomIdAndIdAfter(roomId, afterId);
    }
}

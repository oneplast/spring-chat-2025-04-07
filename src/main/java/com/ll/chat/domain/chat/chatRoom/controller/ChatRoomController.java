package com.ll.chat.domain.chat.chatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatRoomController {
    @GetMapping("/chat/room/{roomId}")
    @ResponseBody
    public String showRoom(@PathVariable long roomId) {
        return "%d번 채팅방 입니다.".formatted(roomId);
    }
}

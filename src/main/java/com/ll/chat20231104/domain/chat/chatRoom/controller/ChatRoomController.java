package com.ll.chat20231104.domain.chat.chatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatRoomController {
    @GetMapping("/chat/room/1")
    @ResponseBody
    public String showRoom() {
        return "1번 채팅방 입니다.";
    }
}

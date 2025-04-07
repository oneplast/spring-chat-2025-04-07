package com.ll.chat.domain.chat.chatRoom.controller;

import com.ll.chat.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chat.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chat.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.chat.global.rsData.RsData;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat/room")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    @GetMapping("{roomId}")
    public String showRoom(@PathVariable long roomId,
                           Model model) {
        ChatRoom room = chatRoomService.findById(roomId).get();
        model.addAttribute("room", room);

        return "domain/chat/chatRoom/room";
    }

    @GetMapping("/make")
    public String showMake() {
        return "domain/chat/chatRoom/make";
    }

    @PostMapping("/make")
    public String make(final String name) {
        chatRoomService.make(name);

        return "redirect:/chat/room/list";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<ChatRoom> chatRooms = chatRoomService.findAll();
        model.addAttribute("chatRooms", chatRooms);

        return "domain/chat/chatRoom/list";
    }

    @Setter
    @Getter
    public static class WriteRequestBody {
        private String writerName;
        private String content;
    }

    @Getter
    @AllArgsConstructor
    public static class WriteResponseBody {
        private Long chatMessageId;
    }

    @PostMapping("/{roomId}/write")
    @ResponseBody
    public RsData<WriteResponseBody> write(@PathVariable final long roomId,
                                           @RequestBody final WriteRequestBody requestBody) {
        ChatMessage chatMessage = chatRoomService.write(roomId, requestBody.writerName, requestBody.content);

        return RsData.of("S-1", "%d번 메시지를 작성하였습니다.".formatted(chatMessage.getId()),
                new WriteResponseBody(chatMessage.getId()));
    }

    @Getter
    @AllArgsConstructor
    public static class GetMessagesAfterResponseBody {
        private List<ChatMessage> messages;
    }

    @GetMapping("/{roomId}/messagesAfter/{afterId}")
    @ResponseBody
    public RsData<GetMessagesAfterResponseBody> write(
            @PathVariable final long roomId,
            @PathVariable final long afterId
    ) {
        List<ChatMessage> messages = chatMessageService.findByChatRoomIdAndIdAfter(roomId, afterId);

        return RsData.of("S-1", "%d개의 메시지를 가져왔습니다.".formatted(messages.size()),
                new GetMessagesAfterResponseBody(messages));
    }
}

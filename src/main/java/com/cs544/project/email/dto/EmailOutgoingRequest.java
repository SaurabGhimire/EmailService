package com.cs544.project.email.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailOutgoingRequest {
    private UserDto from;
    private List<UserDto> to;
    private List<UserDto> cc;
    private List<UserDto> bcc;
    private String subject;
    private String text;
    private String category;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserDto {
        private String email;
        private String name;
    }
}

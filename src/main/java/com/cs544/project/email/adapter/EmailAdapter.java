package com.cs544.project.email.adapter;

import com.cs544.project.email.domain.Email;
import com.cs544.project.email.dto.EmailOutgoingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmailAdapter {
    EmailAdapter INSTANCE = Mappers.getMapper(EmailAdapter.class);

    @Mapping(target = "from.email", source = "emailFrom.email")
    @Mapping(target = "from.name", source = "emailFrom.name")
    @Mapping(target = "to", source = "emailTo")
//    @Mapping(target = "to.name", source = "emailTo.name")
    EmailOutgoingRequest toEmailOutgoingRequest(Email email);
}

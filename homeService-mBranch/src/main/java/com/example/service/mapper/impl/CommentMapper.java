package com.example.service.mapper.impl;

import com.example.data.dto.AdminDto;
import com.example.data.dto.CommentDto;
import com.example.data.entity.Admin;
import com.example.data.entity.Comment;
import com.example.service.mapper.GenericMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author fh.kazemi
 **/

@Data
@Service
public class CommentMapper implements GenericMapper<Comment, CommentDto> {

    @Override
    public CommentDto convertToDto (Comment comment){
        return CommentDto.builder()
                .commentDate(comment.getCommentDate())
                .description(comment.getDescription())
                .order(comment.getOrder())
                .customer(comment.getCustomer())
                .build();
    }

    @Override
    public Comment convertToEntity(CommentDto commentDto){
        return Comment.builder()
                .commentDate(commentDto.getCommentDate())
                .description(commentDto.getDescription())
                .order(commentDto.getOrder())
                .customer(commentDto.getCustomer())
                .build();
    }
}

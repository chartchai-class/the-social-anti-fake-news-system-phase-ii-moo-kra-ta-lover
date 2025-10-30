package se331.mookratabackend.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.mookratabackend.entity.Comment;
import se331.mookratabackend.entity.CommentDTO;
import se331.mookratabackend.entity.News;
import se331.mookratabackend.entity.NewsDTO;
import se331.mookratabackend.security.user.UserDTO;
import se331.mookratabackend.security.user.User;


import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    NewsDTO getNewsDto(News news);
    List<NewsDTO> getNewsDto(List<News> events);
    CommentDTO getCommentDto(Comment comment);
    List<CommentDTO> getCommentDto(List<Comment> comments);
    UserDTO getUserDto(User user);
    List<UserDTO> getUserDto(List<User> users);


//    @Mapping(target = "roles", source = "user.roles")
//    OrganizerAuthDTO getOrganizerAuthDto(Organizer organizer);
//    ParticipantDTO getParticipantDto(Participant participant);
//    List<ParticipantDTO> getParticipantDto(List<Participant> participants);
}

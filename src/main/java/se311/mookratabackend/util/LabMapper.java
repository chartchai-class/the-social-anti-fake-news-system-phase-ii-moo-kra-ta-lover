package se311.mookratabackend.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se311.mookratabackend.entity.Comment;
import se311.mookratabackend.entity.CommentDTO;
import se311.mookratabackend.entity.News;
import se311.mookratabackend.entity.NewsDTO;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    NewsDTO getNewsDto(News news);
    List<NewsDTO> getNewsDto(List<News> events);
    CommentDTO getCommentDto(Comment comment);
    List<CommentDTO> getCommentDto(List<Comment> comments);
//    @Mapping(target = "roles", source = "user.roles")
//    OrganizerAuthDTO getOrganizerAuthDto(Organizer organizer);
//    ParticipantDTO getParticipantDto(Participant participant);
//    List<ParticipantDTO> getParticipantDto(List<Participant> participants);
}

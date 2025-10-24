package se311.mookratabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se311.mookratabackend.entity.News;
import se311.mookratabackend.service.NewsService;
import se311.mookratabackend.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class NewsController {
    final NewsService newsService;
    @GetMapping("news")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                           @RequestParam(value = "_page", required = false) Integer page,
                                           @RequestParam(value = "detail", required = false) String detail){
        perPage = perPage == null ? 20 : perPage;
        page = page == null ? 1 : page;
        Page<News> pageOutput;
        if(detail == null){
            pageOutput = newsService.getNews(perPage, page);
        } else{
            pageOutput = newsService.getNews(detail, PageRequest.of(page-1, perPage));
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-Count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getNewsDto(pageOutput.getContent()), responseHeaders, HttpStatus.OK);
    }

    @GetMapping("news/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id){
        News output = newsService.getNew(id);
        if( output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getNewsDto(output));
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/news")
    public ResponseEntity<?> addEvent(@RequestBody News news){
        News output = newsService.save(news);
        return ResponseEntity.ok(LabMapper.INSTANCE.getNewsDto(output));
    }
}

package com.bangez.user.controller;

import com.bangez.user.domain.dto.BuyArticleDto;
import com.bangez.user.domain.model.BuyArticle;
import com.bangez.user.domain.vo.MessengerVO;
import com.bangez.user.service.BuyArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/buy-article")
@RequiredArgsConstructor
@Slf4j
public class BuyArticleController {

    private final BuyArticleService service;

    @PostMapping("/save")
    public ResponseEntity<MessengerVO> save(@RequestBody BuyArticleDto dto) {
        log.info("입력받은 정보 : {}", dto);
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<MessengerVO> deleteById(@RequestParam Long id)  {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<BuyArticleDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<BuyArticle> modify(@PathVariable Long id, @RequestBody BuyArticle newBuyArticle){
        log.info("입력받은 정보 : {}", newBuyArticle);
        return ResponseEntity.ok(service.modify(id, newBuyArticle));
    }

    @GetMapping(path = "/detail")
    public ResponseEntity<Optional<BuyArticleDto>> findById(@RequestParam Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id));
    }

}
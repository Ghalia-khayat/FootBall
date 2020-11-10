package com.sport.football.controller;

import com.sport.football.model.FootBallInfo;
import com.sport.football.service.FootBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/FootballApi")
public class FootBallController {
    @Autowired
    private FootBallService footBallService;


    @GetMapping("/news")
    List<FootBallInfo> getAll(){
       return footBallService.findAll();
    }
    @GetMapping("/ById/{id}")
   FootBallInfo getById(@PathVariable Long id){
        return footBallService.findById(id);
    }
   @PostMapping("/create")
   List<FootBallInfo> create (@RequestBody FootBallInfo footBallInfo){
        try {
            List<FootBallInfo> FootBallInfo = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                FootBallInfo footBallInfo1 = new FootBallInfo();
                footBallInfo1.setMatch_name(footBallInfo.getMatch_name());
                footBallInfo1.setMatch_location(footBallInfo.getMatch_location());
                footBallInfo1.setMatch_score(footBallInfo.getMatch_score());
                footBallInfo1.setMatch_time(footBallInfo.getMatch_time());
                FootBallInfo.add(footBallService.create(footBallInfo1));
            }
            return FootBallInfo;
        }
        catch (Exception e){
            e.printStackTrace();
        }
       return null;
   }

    @GetMapping("/sorting")
    public ResponseEntity<Object> viewInfo(@RequestParam(name = "p", defaultValue = "1")int pageNumber) {
        try {
            return new ResponseEntity<>(footBallService.getByPage(pageNumber), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }


}

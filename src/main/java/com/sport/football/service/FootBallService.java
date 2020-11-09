package com.sport.football.service;

import com.sport.football.model.FootBallInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FootBallService {
    List<FootBallInfo> findAll();
    FootBallInfo findById(Long matchId);
    FootBallInfo create (FootBallInfo footBallInfo);
    void deleteById(Long id);
    Page<FootBallInfo> getByPage (int pageNumber);
}

package com.sport.football.service;

import com.sport.football.Repository.FootBallRepository;
import com.sport.football.model.FootBallInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FootBallServiceImpl implements FootBallService {
    @Autowired
    private FootBallRepository footBallRepository;



    @Override
    public List<FootBallInfo> findAll() {
        return (List<FootBallInfo>) footBallRepository.findAll();
    }

    @Override
    public FootBallInfo findById(Long matchId) {
        return footBallRepository.findById(matchId).get();
    }

    @Override
    public FootBallInfo create(FootBallInfo footBallInfo) {
        try {

            return footBallRepository.save(footBallInfo);

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public Page<FootBallInfo> getByPage(int pageNumber) {
        try{
            PageRequest request = PageRequest.of(pageNumber-1 , 10 , Sort.Direction.ASC,"id");
            return footBallRepository.findAll(request);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

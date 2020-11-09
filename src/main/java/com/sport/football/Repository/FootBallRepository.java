package com.sport.football.Repository;

import com.sport.football.model.FootBallInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FootBallRepository extends PagingAndSortingRepository<FootBallInfo,Long> {
}

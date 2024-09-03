package com.example.nba.repository;

import com.example.nba.entity.Teams;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamsRepository extends MongoRepository<Teams, String> {

    Teams getTeamsByName(String name);

}

package com.example.nba.services;

import com.example.nba.entity.Teams;
import com.example.nba.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class TeamsService {

    @Autowired
    TeamsRepository teamsRepository;

    public List<Teams> getAllTeams(){
        return  teamsRepository.findAll();
    }
    public Teams addTeam(Teams team){
        teamsRepository.insert(team);
        return team;
    }

    public Teams getByName(String name){
        Teams selectedTeam = teamsRepository.getTeamsByName(name);
        return selectedTeam;
    }
}

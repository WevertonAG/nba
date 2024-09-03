package com.example.nba.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.nba.entity.Teams;
import com.example.nba.services.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/teams")
public class TeamsController {

    @Autowired
    TeamsService teamsService;
    @GetMapping
    public List<Teams> getAllTeams(){
        return teamsService.getAllTeams();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Teams> getTeamByName(@PathVariable String name ){
        Teams teamSelected = teamsService.getByName(name);

        if(teamSelected == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(teamSelected);
    }

    @PostMapping
    public ResponseEntity<Teams> addTeam(@RequestBody Teams team){
        teamsService.addTeam(team);
        return ResponseEntity.created(null).body(team);
    }
}

package com.cl.champions_league.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/champ/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation) {

        if (team != null) {
            return playerService.getPlayersFromTeam(team);
        } else if (position != null) {
            return playerService.getPlayersByPos(position);
        } else if (nation != null) {
            return playerService.getPlayersByNation(nation);
        } else {
            return playerService.getPlayers();
        }
    }

    @GetMapping("/game/random")
    public ResponseEntity<Map<String, Object>> getRandomPlayerForGame() {
        Map<String, Object> playerData = playerService.getRandomPlayerWithoutName();
        if (playerData == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerData, HttpStatus.OK);
    }
}

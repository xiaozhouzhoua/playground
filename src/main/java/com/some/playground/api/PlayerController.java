package com.some.playground.api;

import com.some.playground.dao.PlayerRepository;
import com.some.playground.entity.Player;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/players")
    public List<Player> get() {
        return playerRepository.findAll();
    }

    @GetMapping("/player/{id}")
    public Player get(@PathVariable String id) {
        Player player = playerRepository.getPlayerById(id);
        if (player == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return player;
    }

    @DeleteMapping("/player/delete/{id}")
    public void delete(@PathVariable String id) {
        Player player = playerRepository.getPlayerById(id);
        if (player == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        playerRepository.deleteById(id);
    }

    @PostMapping("/player/create")
    public Player create(@RequestBody Player player) {
        player.setId(UUID.randomUUID().toString());
        return playerRepository.save(player);
    }


    /**
     * <a href="https://segmentfault.com/a/1190000039949298">Spring mvc常用注解</a>
     */
    @PostMapping("/player/upload")
    public Player upload(@RequestPart("data") MultipartFile file) throws IOException {
        Player player = new Player();
        player.setId(UUID.randomUUID().toString());
        String name = file.getOriginalFilename();
        player.setName(name.substring(0, name.indexOf(".")));
        player.setIcon(file.getBytes());
        player.setIconContentType(file.getContentType());
        return playerRepository.save(player);
    }

    @GetMapping("/player/icon/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        Player player = playerRepository.getPlayerById(id);
        byte[] icon = player.getIcon();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(player.getIconContentType()));
        // attachment表明使用下载弹窗， inline则直接显示
        headers.setContentDisposition(ContentDisposition.builder("inline")
                .filename(player.getName())
                .build());

        return ResponseEntity.ok()
                .headers(headers)
                .body(icon);
    }
}

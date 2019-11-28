package com.fh.service;

import com.fh.model.Game;

import java.util.List;
import java.util.Map;

public interface GameService {
    List<Game> ganelist(Map<String,Object> map);

    String deletegame(Integer id);

    String addgame(Game game);

    String updategame(Game game);

    int queryBookCount(Map<String,Object> map);
}

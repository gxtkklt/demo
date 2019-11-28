package com.fh.service;

import com.alibaba.fastjson.JSONObject;
import com.fh.mapper.GameMapper;
import com.fh.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapper gameMapper;

    public List<Game> ganelist(Map<String, Object> map) {
        return gameMapper.ganelist(map);
    }

    public String deletegame(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            gameMapper.deletegame(id);
            map.put("12",1);
        }catch (Exception e){
            map.put("12",2);
        }
        String s = JSONObject.toJSONString(map);
        return s;
    }

    public String addgame(Game game) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            gameMapper.addgame(game);
            map.put("12",1);
        }catch (Exception e){
            map.put("12",2);
        }
        String s = JSONObject.toJSONString(map);
        return s;
    }

    public String updategame(Game game) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            gameMapper.updategame(game);
            map.put("12",1);
        }catch (Exception e){
            map.put("12",2);
        }
        String s = JSONObject.toJSONString(map);
        return s;
    }

    public int queryBookCount(Map<String, Object> map) {

        int count = gameMapper.queryCount(map);

        return count;
    }
}

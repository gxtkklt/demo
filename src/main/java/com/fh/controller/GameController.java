package com.fh.controller;

import com.fh.model.Game;
import com.fh.service.GameService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("GameController")
@CrossOrigin
public class GameController {

    @Resource(name="gameService")
    private GameService gameService;

    @RequestMapping("queryList")
     public Map queryList(Integer draw,
                             Integer start,
                             Integer length,
                          String userName,
                          String min,
                          String max){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("start",start);
        map.put("length", length);
        map.put("userName", userName);
        map.put("minDate",min);
        map.put("maxDate",max);
        List<Game> list = gameService.ganelist(map);
        int queryBookCount=gameService.queryBookCount(map);
        map.put("draw", draw);
        map.put("recordsTotal",queryBookCount);
        map.put("recordsFiltered", queryBookCount);
        map.put("data", list);
         return map;
     }

    @DeleteMapping("deletegame")
    public String deletegame(Integer id){
        String a =gameService.deletegame(id);
        return a;
    }

    @PostMapping("addgame")
    public String addgame(Game game){
        String a=null;
        if (null==game.getId()){
            game.setShowDate(new Date());
             a =gameService.addgame(game);
        }else {
             a =gameService.updategame(game);
        }
        return a;
    }
}

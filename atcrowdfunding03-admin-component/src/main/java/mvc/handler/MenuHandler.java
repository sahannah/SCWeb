package mvc.handler;

import entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.api.MenuService;
import util.ResultEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MenuHandler {

    @Autowired
    private MenuService menuService;



    @RequestMapping("menu/remove.json")
    public ResultEntity<String> removeMenu(@RequestParam("id") Integer id){
        menuService.removeMenuById(id);
        return ResultEntity.successWithoutData();
    }


    @RequestMapping("/menu/update.json")
    public ResultEntity<String> updateMenu(Menu menu){
        menuService.updateMenu(menu);
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("/menu/save.json")
    public ResultEntity<String> saveMenu(Menu menu){
        menuService.saveMenu(menu);
        return ResultEntity.successWithoutData();

    }

    @RequestMapping("/menu/get/whole/tree.json")
    public ResultEntity<Menu> getWholeTreeNew(){
        List<Menu> menuList = menuService.getAll();
        Menu root = null;
        Map<Integer,Menu> menuMap = new HashMap<>();
        for(Menu menu : menuList){
            Integer id = menu.getId();
            menuMap.put(id,menu);
        }
        for(Menu menu : menuList){
            Integer pid = menu.getPid();
            if(pid == null){
                root = menu;
                continue;
            }
            Menu father = menuMap.get(menu.getPid());
            father.getChildren().add(menu);
        }
        return ResultEntity.successWithData(root);

    }

}

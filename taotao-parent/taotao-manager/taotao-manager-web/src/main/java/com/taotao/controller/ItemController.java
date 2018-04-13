package com.taotao.controller;

import com.taotao.pojo.EasyUIResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;

/**
 * @Author binblink
 * @Create Time　2018/4/11 21:57
 * @Description:
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) throws  Exception{

        return itemService.getItemByid(itemId);
    }

    @RequestMapping("list")
    @ResponseBody
    public EasyUIResult getItemList(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "30")Integer rows) throws Exception{

        return itemService.getItemList(page,rows);
    }

}

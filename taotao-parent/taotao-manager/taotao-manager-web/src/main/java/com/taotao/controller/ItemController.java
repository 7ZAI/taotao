package com.taotao.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.taotao.pojo.EasyUIResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import com.taotao.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.util.Map;

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

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIResult getItemList(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "30")Integer rows) throws Exception{

        return itemService.getItemList(page,rows);
    }

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult saveItem(TbItem item, String desc,String itemParams) throws Exception {
        //添加商品信息
        itemService.saveItem(item,desc,itemParams);
        return TaotaoResult.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteItem(@RequestParam(value = "ids",required = true) String ids) throws Exception{

        String[] idArr = ids.split(",");
        System.out.println(ids);
        for(String id : idArr){

            if(id == null ||"".equals(id)){
                continue;
            }
            Long idLong = Long.parseLong(id);
            itemService.deleteItem(idLong);
        }
        return TaotaoResult.ok();
    }

    /**
     *下架
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/instock")
    @ResponseBody
    public TaotaoResult instockItem(@RequestParam(value = "ids",required = true) String ids) throws Exception{

        String[] idArr = ids.split(",");

        for(String id : idArr){

            if(id == null ||"".equals(id)){
                continue;
            }
            Long idLong = Long.parseLong(id);
            itemService.updateItemStatus(idLong,(byte)2);
        }

        return TaotaoResult.ok();
    }


    @RequestMapping("/reshelf")
    @ResponseBody
    public TaotaoResult reshelfItem(@RequestParam(value = "ids",required = true) String ids) throws Exception{

        String[] idArr = ids.split(",");
        for(String id : idArr){

            if(id == null ||id.equals("")){
                continue;
            }
            Long idLong = Long.parseLong(id);
            itemService.updateItemStatus(idLong,(byte)1);
        }

        return TaotaoResult.ok();
    }

}

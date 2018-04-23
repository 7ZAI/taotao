package com.taotao.controller;

import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import com.taotao.utils.EasyUIResult;
import com.taotao.utils.TaotaoResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author:binblink
 * @Description
 * @Date: Create on  2018/4/22 17:20
 * @Modified By:
 * @Version:1.0.0
 **/
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid//{cid}")
    @ResponseBody
    public TaotaoResult queryItemCataByCid(@PathVariable long cid) throws Exception{

        System.out.println("queryItemCataByCid   cid="+cid);
        return itemParamService.findCatalogByCid(cid);
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult saveItemParam(@PathVariable long cid, @Param("paramData") String paramData) throws Exception{

        System.out.println("cid:+"+cid+"-------- paramData:"+paramData);

        TbItemParam tp = new TbItemParam();

        Date date = new Date();

        tp.setCreated(date);
        tp.setUpdated(date);
        tp.setParamData(paramData);
        tp.setItemCatId(cid);

        return   itemParamService.saveItemParam(tp);
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIResult itemParamList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer rows) throws Exception{

        return itemParamService.findItemParam(page,rows);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public TaotaoResult deleteItemParam( String ids)throws Exception{

        System.out.println(ids);
        String[] idArr = ids.split(",");

        for(String id : idArr){
            if(id == null || id.equals("")){
                continue;
            }
            itemParamService.deleteItemParam(Long.parseLong(id));
        }
        return TaotaoResult.ok();
    }

}

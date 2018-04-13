package com.taotao.controller;

import com.taotao.pojo.common.TreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author binblink
 * @Create Time　2018/4/12 18:48
 * @Description:
 */
@RequestMapping("/item/cat")
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<TreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId) throws  Exception{

        return itemCatService.getItemCatList(parentId);

    }
}

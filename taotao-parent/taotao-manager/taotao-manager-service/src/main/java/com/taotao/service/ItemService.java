package com.taotao.service;

import com.taotao.pojo.EasyUIResult;
import com.taotao.pojo.TbItem;

import java.util.List;

/**
 * @Author binblink
 * @Create Time　2018/4/11 21:36
 * @Description:
 */
public interface ItemService {

    TbItem getItemByid(Long id) throws Exception;

    EasyUIResult getItemList(Integer page, Integer rows) throws Exception;
}

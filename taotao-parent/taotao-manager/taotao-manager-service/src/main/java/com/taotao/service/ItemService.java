package com.taotao.service;

import com.taotao.pojo.TbItem;

/**
 * @Author binblink
 * @Create Time　2018/4/11 21:36
 * @Description:
 */
public interface ItemService {

    TbItem getItemByid(Long id) throws Exception;
}

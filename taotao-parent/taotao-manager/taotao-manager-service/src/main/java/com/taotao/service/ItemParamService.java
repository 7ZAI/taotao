package com.taotao.service;

import com.taotao.pojo.TbItemParam;
import com.taotao.utils.EasyUIResult;
import com.taotao.utils.TaotaoResult;

/**
 * @author:binblink
 * @Description
 * @Date: Create on  2018/4/22 17:07
 * @Modified By:
 * @Version:1.0.0
 **/
public interface ItemParamService {

    TaotaoResult findCatalogByCid(Long cid) throws Exception;

    TaotaoResult saveItemParam(TbItemParam tbItemParam) throws Exception;

    TaotaoResult deleteItemParam(Long id) throws Exception;


    EasyUIResult findItemParam(Integer page,Integer rows) throws Exception;

}

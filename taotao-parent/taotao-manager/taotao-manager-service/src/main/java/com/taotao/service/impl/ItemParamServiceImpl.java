package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import com.taotao.utils.EasyUIResult;
import com.taotao.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:binblink
 * @Description
 * @Date: Create on  2018/4/22 17:10
 * @Modified By:
 * @Version:1.0.0
 **/
@Service
public class ItemParamServiceImpl  implements ItemParamService{

    @Autowired
    private TbItemParamMapper itemParamMapper ;

    @Override
    public TaotaoResult findCatalogByCid(Long cid) throws Exception {

        TbItemParamExample example = new TbItemParamExample();

        example.createCriteria().andItemCatIdEqualTo(cid);

        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);

        if(list !=null && !list.isEmpty()){

            return TaotaoResult.ok(list.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult saveItemParam(TbItemParam tbItemParam) throws Exception {


        int resutl =  itemParamMapper.insert(tbItemParam);


        return TaotaoResult.ok();

    }

    @Override
    public TaotaoResult deleteItemParam(Long id) throws Exception {

        itemParamMapper.deleteByPrimaryKey(id);
        return TaotaoResult.ok();
    }

    @Override
    public EasyUIResult findItemParam(Integer page, Integer rows) throws Exception {

        PageHelper.startPage(page,rows);

        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(new TbItemParamExample());

        PageInfo<TbItemParam> pageInfo = new PageInfo<TbItemParam>(list);

        EasyUIResult easyUIResult = new EasyUIResult(pageInfo.getTotal(),list);

        return easyUIResult;
    }
}

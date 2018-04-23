package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.*;
import com.taotao.service.ItemService;
import com.taotao.utils.IDUtils;
import com.taotao.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author binblink
 * @Create Time　2018/4/11 21:42
 * @Description:
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Override
    public TbItem getItemByid(Long id) throws Exception {



        TbItemExample example = new TbItemExample();

        TbItemExample.Criteria criteria = example.createCriteria();

        criteria.andIdEqualTo(id);

        List<TbItem> items = tbItemMapper.selectByExample(example);

        if(items != null && items.size()>0){

            return items.get(0);
        }

        return null;
    }

    @Override
    public EasyUIResult getItemList(Integer page, Integer rows) throws Exception {

        TbItemExample example = new TbItemExample();

        PageHelper.startPage(page,rows);

        List<TbItem> list = tbItemMapper.selectByExample(example);

        PageInfo pageInfo  = new PageInfo(list);

        EasyUIResult easyUIResult = new EasyUIResult(pageInfo.getTotal(),list);

        return easyUIResult;
    }

    @Override
    public TaotaoResult saveItem(TbItem tbItem, String desc,String paramsData) throws Exception {

        Date date = new Date();

        long id = IDUtils.genItemId();

        tbItem.setId(id);
        tbItem.setStatus((byte)1);
        tbItem.setCreated(date);
        tbItem.setUpdated(date);

        tbItemMapper.insert(tbItem);


        TbItemDesc tbItemDesc = new TbItemDesc();

        tbItemDesc.setItemId(id);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        tbItemDesc.setItemDesc(desc);

        tbItemDescMapper.insert(tbItemDesc);

        TbItemParamItem tbipi = new TbItemParamItem();

        tbipi.setItemId(id);
        tbipi.setCreated(date);
        tbipi.setUpdated(date);
        tbipi.setParamData(paramsData);

        itemParamItemMapper.insert(tbipi);

        return TaotaoResult.ok();
    }

    @Override
    public void deleteItem(Long id) throws Exception {


        TbItemExample tbie = new TbItemExample();
        TbItemExample.Criteria criteria = tbie.createCriteria();
        criteria.andIdEqualTo(id);
        int k =tbItemMapper.deleteByExample(tbie);
        System.out.println(k);
    }

    @Override
    public void updateItemStatus(Long id,byte status) throws Exception {

        TbItem tb = new TbItem();
        tb.setId(id);
        tb.setStatus(status);

        tbItemMapper.updateByPrimaryKeySelective(tb);
    }


}

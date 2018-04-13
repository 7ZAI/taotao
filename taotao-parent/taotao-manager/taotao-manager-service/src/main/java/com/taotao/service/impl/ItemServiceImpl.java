package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.EasyUIResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public TbItem getItemByid(Long id) throws Exception {

        //TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);

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
}

package com.taotao.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.common.TreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author binblink
 * @Create Time　2018/4/12 15:21
 * @Description:
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TreeNode> getItemCatList(long parentId) throws Exception {

        TbItemCatExample example = new TbItemCatExample();

        TbItemCatExample.Criteria  criteria = example.createCriteria();

        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);

        List<TreeNode> treeNodes = new ArrayList<TreeNode>();

        for(TbItemCat itemCat : list){

            TreeNode  treeNode = new TreeNode(itemCat.getId(),itemCat.getName(),itemCat.getIsParent()?"closed":"open");
            treeNodes.add(treeNode);
        }

        return treeNodes;
    }
}

package com.taotao.service;

import com.taotao.pojo.common.TreeNode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author binblink
 * @Create Time　2018/4/12 15:16
 * @Description:
 */

public interface ItemCatService {

    List<TreeNode> getItemCatList(long parentId) throws Exception;
}

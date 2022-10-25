package com.yijixin.fromzerotoexpert.common;

import com.yijixin.fromzerotoexpert.model.dao.DisallowWordMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Classname ACTrie
 * @Description 基于HashMap实现的AC自动机实现敏感词过滤
 * @Version 1.0.0
 * @Date 2022/10/24 20:55
 * @Created by 忆霁昕
 */
@Component
public class AcTrie {
    class AcNode {
        public char data;
        //key-子节点的data value-子节点
        public HashMap<Character, AcNode> children = new HashMap();
        public boolean end = false;
        public AcNode fail;

        public AcNode() {

        }
        public AcNode(char data) {
            this.data = data;
        }
    }

    private AcNode root = new AcNode();
    //根据字符串数组构建ac自动机
    public void build(List<String> list) {
        for (String s : list) {
            insert(s);
        }
        buildFail();
    }
    //插入一个字符串
    public void insert(String text) {
        AcNode p = root;
        for (int i = 0; i < text.length(); i++) {
            char key = text.charAt(i);
            if (!p.children.containsKey(key)) {
                AcNode node = new AcNode(key);
                p.children.put(key, node);
            }
            p = p.children.get(key);
        }
        p.end = true;
    }


    public void buildFail() {
        //层序遍历
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (AcNode pc : p.children.values()) {
                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children.get(pc.data);
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }
    //查找该字符的子串是否存在
    public boolean find(String text) {
        AcNode p = root;
        int i = 0;
        int j = 0;
        while (j < text.length()) {
            char key = text.charAt(j);
            if (p.children.containsKey(key)) {
                j++;
                p = p.children.get(key);
                if (p.end) {
                    return true;
                }
            } else {
                //没有匹配上 回退
                i++;
                j = i;
                p = root;
            }

        }
        return false;
    }
    public boolean match (String text) {
        AcNode p = root;
        for (int i = 0; i < text.length(); i++) {
            char key = text.charAt(i);
            while (!p.children.containsKey(key) && p != root) {
                p = p.fail;
            }
            p = p.children.get(key);
            if (p == null) {
                p = root;
            }
            AcNode tmp = p;
            while (tmp != null) {
                if (tmp.end) {
                    return true;
                }
                tmp = tmp.fail;
            }
        }
        return false;
    }

}

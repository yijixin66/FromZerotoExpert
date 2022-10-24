package com.yijixin.fromzerotoexpert.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname ACTrie
 * @Description 基于HashMap实现的AC自动机实现敏感词过滤
 * @Version 1.0.0
 * @Date 2022/10/24 20:55
 * @Created by 忆霁昕
 */

public class AcTrie {
    class AcNode {
        public char data;
        //key-子节点的data value-子节点
        public HashMap<Character, AcNode> children = new HashMap();
        public boolean end = false;
        public AcNode fail;

        public AcNode(char data) {
            this.data = data;
        }
    }

    private AcNode root = new AcNode('/');

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

    //根据字符串数组构建ac自动机
    public void build(String[] texts) {
        for (String text : texts) {
            insert(text);
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
                i++;
                j = i;
                p = root;

            }

        }
        return false;
    }


    public static void main(String[] args) {
        AcTrie acTrie = new AcTrie();
//        acTrie.insert("abcde");
//        acTrie.insert("abfe");
//        System.out.println(acTrie.find("abcde"));
//        System.out.println(acTrie.find("abfe"));
//        System.out.println(acTrie.find("abf"));
        acTrie.build(FzteConstant.SENSITIVE_KEYS);
        //尼玛，站长，国家领导人，操
        System.out.println(acTrie.find("asda尼bi玛de"));
        System.out.println(acTrie.find("sd国家领导人rew"));

        System.out.println(acTrie.find("dads尼玛"));
    }
}

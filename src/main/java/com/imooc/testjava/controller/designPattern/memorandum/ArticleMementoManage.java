package com.imooc.testjava.controller.designPattern.memorandum;

import java.util.Stack;

/**
 * @author : shidun
 * @date : 2019/12/19
 */
public class ArticleMementoManage {
    private final Stack<ArticleMemento> stack = new Stack<>();

    public void addStack(ArticleMemento articleMemento){
        stack.push(articleMemento);
//        stack.add()
    }

    public ArticleMemento getArticleMemento() {
        return stack.pop();
    }
}

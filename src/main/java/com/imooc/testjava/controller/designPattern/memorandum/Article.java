package com.imooc.testjava.controller.designPattern.memorandum;

import lombok.Data;

/**
 * @author : shidun
 * @date : 2019/12/19
 */
@Data
public class Article {
    private String title;
    private String content;
    private String img;

    public Article(String title, String content, String img) {
        this.title = title;
        this.content = content;
        this.img = img;
    }

    public ArticleMemento saveToMemento() {
        ArticleMemento articleMemento = new ArticleMemento(this.title, this.content, this.img);
        return articleMemento;
    }

    public void undoFromMemento(ArticleMemento articleMemento){
        this.content = articleMemento.getContent();
        this.title = articleMemento.getTitle();
        this.img = articleMemento.getImg();
    }
}

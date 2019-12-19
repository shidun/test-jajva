package com.imooc.testjava.controller.designPattern.memorandum;

/**
 * 备忘录模式
 * @author : shidun
 * @date : 2019/12/19
 */
public class Test {
    public static void main(String[] args) {
        Article article = new Article("title-A", "content-A", "img-A");
        ArticleMemento articleMemento = article.saveToMemento();
        ArticleMementoManage manage = new ArticleMementoManage();
        manage.addStack(articleMemento);

        article.setContent("title-B");
        ArticleMemento articleMemento1 = article.saveToMemento();
        manage.addStack(articleMemento1);
        article.setContent("title-c");
        ArticleMemento articleMemento2 = article.saveToMemento();
        manage.addStack(articleMemento2);
        System.out.println(article);

        ArticleMemento articleMemento3 = manage.getArticleMemento();
        article.undoFromMemento(articleMemento3);
        System.out.println(article);
        ArticleMemento articleMemento4 = manage.getArticleMemento();
        article.undoFromMemento(articleMemento4);
        System.out.println(article);

    }
}

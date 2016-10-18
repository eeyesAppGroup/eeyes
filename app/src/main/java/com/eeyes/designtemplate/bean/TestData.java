package com.eeyes.designtemplate.bean;

import java.util.List;

/**
 * 用谷歌的Gsonformat格式化出来的bean文件，此处仅用于测试
 * Created by guolei on 2016/7/31.
 */
public class TestData {


    /**
     * date : 20160731
     * stories : [{"images":["http://pic4.zhimg.com/2478bdb57acfb8bf8a2b1229cf811623.jpg"],"type":0,"id":8629105,"ga_prefix":"073116","title":"空调是什么？「我们欧洲人并不知道」"},{"title":"看起来「像小孩子画的」，印象派的地位为什么那么高","ga_prefix":"073115","images":["http://pic2.zhimg.com/80137b7c87c0c7813d8107fa08284b51.jpg"],"multipic":true,"type":0,"id":8624199},{"images":["http://pic4.zhimg.com/9466d48af829e291999ef7620016d583.jpg"],"type":0,"id":8630485,"ga_prefix":"073114","title":"不一定非得打官司，调解也能解决问题"},{"images":["http://pic3.zhimg.com/c90c16ea944dccf2eef4b39c05f74312.jpg"],"type":0,"id":8623993,"ga_prefix":"073113","title":"矫正牙齿而已，为什么还需要拔牙？"},{"images":["http://pic3.zhimg.com/191b7cf3c1e78101adb4cd8570201922.jpg"],"type":0,"id":8619444,"ga_prefix":"073112","title":"大误 · 我，成了天下最好的搓澡师"},{"images":["http://pic2.zhimg.com/76e6288ba7d5a4acc38bc5ece38c239d.jpg"],"type":0,"id":8624638,"ga_prefix":"073111","title":"「天堂应该是图书馆的模样」，比如这样"},{"images":["http://pic4.zhimg.com/e2c12a052ce52b712b93e14600835d4b.jpg"],"type":0,"id":8624173,"ga_prefix":"073110","title":"开一家保险公司给自己提供保险，不少大公司都是这么做的"},{"images":["http://pic1.zhimg.com/0e6c289707fe5c74abcdaeaf9f16b088.jpg"],"type":0,"id":8627410,"ga_prefix":"073109","title":"玩耍不如工作，休息不如工作，瘫坐睡觉都不如工作"},{"images":["http://pic2.zhimg.com/e7cef5a33c5acd811be02e44b9a78d89.jpg"],"type":0,"id":8624140,"ga_prefix":"073108","title":"心塞，怨念，为什么这个地铁站就没有扶梯"},{"images":["http://pic2.zhimg.com/7d5303c6f7dd8844168c39695482fdf9.jpg"],"type":0,"id":8624670,"ga_prefix":"073107","title":"没错，汤汁与米饭的结合才是这道葱烤大排的精华所在"},{"images":["http://pic2.zhimg.com/2de2ca5551d19e1eda78caa5a91411f5.jpg"],"type":0,"id":8623755,"ga_prefix":"073107","title":"一些高质量的英文财经网站，帮助丰富你的阅读源"},{"images":["http://pic2.zhimg.com/618d4fe6e5da6dbf1c79e8138dd81179.jpg"],"type":0,"id":8623674,"ga_prefix":"073107","title":"小产权房、大产权房、公产房、集资房、经济适用房，廉租房\u2026\u2026我都快晕了"},{"images":["http://pic1.zhimg.com/aa95bad66de6707f2e2f6fd60029f948.jpg"],"type":0,"id":8630184,"ga_prefix":"073107","title":"读读日报 24 小时热门 TOP 5 · 七座游戏和科幻中最伟大的城市"},{"images":["http://pic1.zhimg.com/d797a95a996a49242b4b397b3fb6c2a4.jpg"],"type":0,"id":8627855,"ga_prefix":"073106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/8afd370fbdaccaa1d31d0c331384a2f5.jpg","type":0,"id":8624638,"ga_prefix":"073111","title":"「天堂应该是图书馆的模样」，比如这样"},{"image":"http://pic1.zhimg.com/e1586a11724f22aa787757fb049b2270.jpg","type":0,"id":8627410,"ga_prefix":"073109","title":"玩耍不如工作，休息不如工作，瘫坐睡觉都不如工作"},{"image":"http://pic3.zhimg.com/0a8424f779fe26e7d1a6388688c0e18a.jpg","type":0,"id":8623674,"ga_prefix":"073107","title":"小产权房、大产权房、公产房、集资房、经济适用房，廉租房\u2026\u2026我都快晕了"},{"image":"http://pic2.zhimg.com/17ed7842c3859f9bd1474e51fdb8d3d9.jpg","type":0,"id":8630184,"ga_prefix":"073107","title":"读读日报 24 小时热门 TOP 5 · 七座游戏和科幻中最伟大的城市"},{"image":"http://pic3.zhimg.com/3825faa815406406e521902624261442.jpg","type":0,"id":8620559,"ga_prefix":"073017","title":"知乎好问题 · 中国有什么好玩又冷门的城市？"}]
     */

    private String date;
    /**
     * images : ["http://pic4.zhimg.com/2478bdb57acfb8bf8a2b1229cf811623.jpg"]
     * type : 0
     * id : 8629105
     * ga_prefix : 073116
     * title : 空调是什么？「我们欧洲人并不知道」
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic2.zhimg.com/8afd370fbdaccaa1d31d0c331384a2f5.jpg
     * type : 0
     * id : 8624638
     * ga_prefix : 073111
     * title : 「天堂应该是图书馆的模样」，比如这样
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

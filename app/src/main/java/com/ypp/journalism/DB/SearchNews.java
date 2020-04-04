package com.ypp.journalism.DB;

import java.util.List;

public class SearchNews {

    /**
     * status : 0
     * msg : ok
     * result : {"keyword":"姚明","num":"9","list":[{"title":"姚明:篮球改革比足球基础好 像电视剧一样播比赛","time":"2016-03-16 09:59:06","src":"网易","category":"","pic":"http://api.jisuapi.com/news/upload/20160316/104634_55612.jpg","url":"http://m.news.so.com/transcode?ofmt=html&src=srp&q=姚明&pn=1&pos=1&m=20bf33d00f8db460ecacb72229acbd11f3d238e1&u=http://sports.163.com/16/0316/09/BI96O41V00052UUC.html","weburl":"http://sports.163.com/16/0316/09/BI96O41V00052UUC.html","content":"ssss"}]}
     */

    private int status;
    private String msg;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * keyword : 姚明
         * num : 9
         * list : [{"title":"姚明:篮球改革比足球基础好 像电视剧一样播比赛","time":"2016-03-16 09:59:06","src":"网易","category":"","pic":"http://api.jisuapi.com/news/upload/20160316/104634_55612.jpg","url":"http://m.news.so.com/transcode?ofmt=html&src=srp&q=姚明&pn=1&pos=1&m=20bf33d00f8db460ecacb72229acbd11f3d238e1&u=http://sports.163.com/16/0316/09/BI96O41V00052UUC.html","weburl":"http://sports.163.com/16/0316/09/BI96O41V00052UUC.html","content":"ssss"}]
         */

        private String keyword;
        private String num;
        private List<ListBean> list;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * title : 姚明:篮球改革比足球基础好 像电视剧一样播比赛
             * time : 2016-03-16 09:59:06
             * src : 网易
             * category :
             * pic : http://api.jisuapi.com/news/upload/20160316/104634_55612.jpg
             * url : http://m.news.so.com/transcode?ofmt=html&src=srp&q=姚明&pn=1&pos=1&m=20bf33d00f8db460ecacb72229acbd11f3d238e1&u=http://sports.163.com/16/0316/09/BI96O41V00052UUC.html
             * weburl : http://sports.163.com/16/0316/09/BI96O41V00052UUC.html
             * content : ssss
             */

            private String title;
            private String time;
            private String src;
            private String category;
            private String pic;
            private String url;
            private String weburl;
            private String content;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getWeburl() {
                return weburl;
            }

            public void setWeburl(String weburl) {
                this.weburl = weburl;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}

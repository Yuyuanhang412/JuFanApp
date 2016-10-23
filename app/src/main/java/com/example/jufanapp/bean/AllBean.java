package com.example.jufanapp.bean;

import java.util.List;

/**
 * Created by w8888 on 2016/10/20.
 */
public class AllBean {

    /**
     * state : 0
     * message : SUCCESS
     * content : {"data":[{"uid":93436155,"level":55,"nickname":"继续辉煌","out_amount":546500,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160611/4250780328cb2fb3e23e.jpg"},{"uid":89418643,"level":54,"nickname":"西瓜","out_amount":531538,"attention":true,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160810/1f7b1b3b77458285722d.jpg"},{"uid":88587232,"level":50,"nickname":"隔壁老王","out_amount":412831,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160930/d0b3088571195d1310ba.jpg"},{"uid":91780475,"level":48,"nickname":"哲哲","out_amount":339693,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160810/20a44d49a1b359a89092.jpg"},{"uid":500011615,"level":46,"nickname":"红鲤鱼与绿鲤鱼与驴","out_amount":288251,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161015/2ddc4b18f8268ce832b1.png"},{"uid":91257696,"level":45,"nickname":"等风来","out_amount":272109,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160809/630434bc9d584238db43.jpg"},{"uid":94118334,"level":43,"nickname":"教父","out_amount":264750,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160906/9735fb7200b7441a9a9d.jpg"},{"uid":91596924,"level":44,"nickname":"🔞大V","out_amount":257826,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160802/fea25d27dc5f4d98d840.jpg"},{"uid":90717473,"level":44,"nickname":"李新","out_amount":252034,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160804/da8855b620da72fc8b7a.png"},{"uid":89603283,"level":44,"nickname":"山顶的山","out_amount":247862,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160815/767a32cc347e61e94566.jpg"},{"uid":86146947,"level":43,"nickname":"C^_^c 好美丽🙃","out_amount":231246,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160815/e6712ed2664058adf628.jpg"},{"uid":87016066,"level":42,"nickname":"哥就是传说","out_amount":211002,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160602/8694853e4a951d8bab50.jpg"},{"uid":500065629,"level":41,"nickname":"无","out_amount":205000,"attention":false,"headImgSmall":"http://wx.qlogo.cn/mmopen/aiaSScnGicE4slMKVgxdEhwc0QIJ7eI5ia7pOcOTrMv0ibejCGuPOVKAZDAictQW3eX6G7qFlibS31IkuB7QLg0gMD2XZw6TNT1LiaC/64"},{"uid":94623507,"level":41,"nickname":"海華","out_amount":201128,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160924/bf4f0f3067106cbf87cd.png"},{"uid":89214640,"level":40,"nickname":"哈利路亚","out_amount":188946,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160830/189f28c6583b23c7ff3c.jpg"}],"page_count":14}
     */
    private int state;
    private String message;
    private ContentEntity content;

    public void setState(int state) {
        this.state = state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setContent(ContentEntity content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public ContentEntity getContent() {
        return content;
    }

    public static class ContentEntity {
        /**
         * data : [{"uid":93436155,"level":55,"nickname":"继续辉煌","out_amount":546500,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160611/4250780328cb2fb3e23e.jpg"},{"uid":89418643,"level":54,"nickname":"西瓜","out_amount":531538,"attention":true,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160810/1f7b1b3b77458285722d.jpg"},{"uid":88587232,"level":50,"nickname":"隔壁老王","out_amount":412831,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160930/d0b3088571195d1310ba.jpg"},{"uid":91780475,"level":48,"nickname":"哲哲","out_amount":339693,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160810/20a44d49a1b359a89092.jpg"},{"uid":500011615,"level":46,"nickname":"红鲤鱼与绿鲤鱼与驴","out_amount":288251,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161015/2ddc4b18f8268ce832b1.png"},{"uid":91257696,"level":45,"nickname":"等风来","out_amount":272109,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160809/630434bc9d584238db43.jpg"},{"uid":94118334,"level":43,"nickname":"教父","out_amount":264750,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160906/9735fb7200b7441a9a9d.jpg"},{"uid":91596924,"level":44,"nickname":"🔞大V","out_amount":257826,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160802/fea25d27dc5f4d98d840.jpg"},{"uid":90717473,"level":44,"nickname":"李新","out_amount":252034,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160804/da8855b620da72fc8b7a.png"},{"uid":89603283,"level":44,"nickname":"山顶的山","out_amount":247862,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160815/767a32cc347e61e94566.jpg"},{"uid":86146947,"level":43,"nickname":"C^_^c 好美丽🙃","out_amount":231246,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160815/e6712ed2664058adf628.jpg"},{"uid":87016066,"level":42,"nickname":"哥就是传说","out_amount":211002,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160602/8694853e4a951d8bab50.jpg"},{"uid":500065629,"level":41,"nickname":"无","out_amount":205000,"attention":false,"headImgSmall":"http://wx.qlogo.cn/mmopen/aiaSScnGicE4slMKVgxdEhwc0QIJ7eI5ia7pOcOTrMv0ibejCGuPOVKAZDAictQW3eX6G7qFlibS31IkuB7QLg0gMD2XZw6TNT1LiaC/64"},{"uid":94623507,"level":41,"nickname":"海華","out_amount":201128,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160924/bf4f0f3067106cbf87cd.png"},{"uid":89214640,"level":40,"nickname":"哈利路亚","out_amount":188946,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160830/189f28c6583b23c7ff3c.jpg"}]
         * page_count : 14
         */
        private List<DataEntity> data;
        private int page_count;

        public void setData(List<DataEntity> data) {
            this.data = data;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public List<DataEntity> getData() {
            return data;
        }

        public int getPage_count() {
            return page_count;
        }

        public static class DataEntity {
            /**
             * uid : 93436155
             * level : 55
             * nickname : 继续辉煌
             * out_amount : 546500
             * attention : false
             * headImgSmall : http://resource.jufan.tv/jufan/userhead/20160611/4250780328cb2fb3e23e.jpg
             */
            private int uid;
            private int level;
            private String nickname;
            private int out_amount;
            private boolean attention;
            private String headImgSmall;

            public void setUid(int uid) {
                this.uid = uid;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public void setOut_amount(int out_amount) {
                this.out_amount = out_amount;
            }

            public void setAttention(boolean attention) {
                this.attention = attention;
            }

            public void setHeadImgSmall(String headImgSmall) {
                this.headImgSmall = headImgSmall;
            }

            public int getUid() {
                return uid;
            }

            public int getLevel() {
                return level;
            }

            public String getNickname() {
                return nickname;
            }

            public int getOut_amount() {
                return out_amount;
            }

            public boolean isAttention() {
                return attention;
            }

            public String getHeadImgSmall() {
                return headImgSmall;
            }
        }
    }
}

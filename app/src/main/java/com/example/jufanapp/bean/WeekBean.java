package com.example.jufanapp.bean;

import java.util.List;

/**
 * Created by w8888 on 2016/10/20.
 */
public class WeekBean {


    /**
     * state : 0
     * message : SUCCESS
     * content : {"data":[{"uid":89966526,"level":35,"nickname":"【狼族】～⚡头狼⚡💟","out_amount":46000,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161019/9177e0f6cc34c5449082.png"},{"uid":500150931,"level":35,"nickname":"喜欢你","out_amount":35902,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161018/fa638a781a1709d86d05.png"},{"uid":500262421,"level":21,"nickname":"一起嗨起來","out_amount":28225,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161018/1a8f8511b7b7a9a0e9af.png"},{"uid":500150290,"level":40,"nickname":"【大闹天空】齊天大聖","out_amount":28022,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160926/d59f0bc3d2d234d48243.png"},{"uid":500221691,"level":25,"nickname":"蓝瘦 香菇","out_amount":25500,"attention":false,"headImgSmall":"http://wx.qlogo.cn/mmopen/s1dJzIlHYqiaYCBnDC1BbxrUMdf8NWhntZzx3atWHg7RMEVngWEISNCeiaKiaKpwYsgFI4CMdjsJ0h1IfQnA4avhswESQKDYwNC/64"},{"uid":500150972,"level":33,"nickname":"小龙虾","out_amount":24761,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161017/0ed2c749625be5db6927.jpg"},{"uid":86781220,"level":31,"nickname":"莉宝宝保护神","out_amount":20250,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160918/5d03b2665e63bfe8fff6.jpg"},{"uid":85578673,"level":24,"nickname":"0724","out_amount":20248,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160807/26f8129c8ec8111f9538.png"},{"uid":89386272,"level":35,"nickname":"Steven","out_amount":20000,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160810/1445303d48078b690319.jpg"},{"uid":93778548,"level":26,"nickname":"团哥守护可爱","out_amount":15361,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160809/910414dd96062082737b.png"},{"uid":88262301,"level":23,"nickname":"胖子","out_amount":15179,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160623/70e09269e8e7ef045842.jpg"},{"uid":500266792,"level":16,"nickname":"宝哥哥","out_amount":14745,"attention":false,"headImgSmall":"http://q.qlogo.cn/qqapp/1105125329/1D862756E5852D24662F087B348CFA91/40"},{"uid":500043821,"level":15,"nickname":"空城","out_amount":13000,"attention":false,"headImgSmall":"http://wx.qlogo.cn/mmopen/PiajxSqBRaEI4KbMELqJk9Qujl8C8ICM4RFZnhDricHHr0HezDP1tyHWsI6oyxh0CAEoWY1OTOSiahwjf4VicvrTBQ/64"},{"uid":88687783,"level":35,"nickname":"😂😂😂","out_amount":12701,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160513/cc7313ba435273094ba5.jpg"},{"uid":500011615,"level":46,"nickname":"红鲤鱼与绿鲤鱼与驴","out_amount":12320,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161015/2ddc4b18f8268ce832b1.png"}],"page_count":14}
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
         * data : [{"uid":89966526,"level":35,"nickname":"【狼族】～⚡头狼⚡💟","out_amount":46000,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161019/9177e0f6cc34c5449082.png"},{"uid":500150931,"level":35,"nickname":"喜欢你","out_amount":35902,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161018/fa638a781a1709d86d05.png"},{"uid":500262421,"level":21,"nickname":"一起嗨起來","out_amount":28225,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161018/1a8f8511b7b7a9a0e9af.png"},{"uid":500150290,"level":40,"nickname":"【大闹天空】齊天大聖","out_amount":28022,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160926/d59f0bc3d2d234d48243.png"},{"uid":500221691,"level":25,"nickname":"蓝瘦 香菇","out_amount":25500,"attention":false,"headImgSmall":"http://wx.qlogo.cn/mmopen/s1dJzIlHYqiaYCBnDC1BbxrUMdf8NWhntZzx3atWHg7RMEVngWEISNCeiaKiaKpwYsgFI4CMdjsJ0h1IfQnA4avhswESQKDYwNC/64"},{"uid":500150972,"level":33,"nickname":"小龙虾","out_amount":24761,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161017/0ed2c749625be5db6927.jpg"},{"uid":86781220,"level":31,"nickname":"莉宝宝保护神","out_amount":20250,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20160918/5d03b2665e63bfe8fff6.jpg"},{"uid":85578673,"level":24,"nickname":"0724","out_amount":20248,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160807/26f8129c8ec8111f9538.png"},{"uid":89386272,"level":35,"nickname":"Steven","out_amount":20000,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160810/1445303d48078b690319.jpg"},{"uid":93778548,"level":26,"nickname":"团哥守护可爱","out_amount":15361,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160809/910414dd96062082737b.png"},{"uid":88262301,"level":23,"nickname":"胖子","out_amount":15179,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160623/70e09269e8e7ef045842.jpg"},{"uid":500266792,"level":16,"nickname":"宝哥哥","out_amount":14745,"attention":false,"headImgSmall":"http://q.qlogo.cn/qqapp/1105125329/1D862756E5852D24662F087B348CFA91/40"},{"uid":500043821,"level":15,"nickname":"空城","out_amount":13000,"attention":false,"headImgSmall":"http://wx.qlogo.cn/mmopen/PiajxSqBRaEI4KbMELqJk9Qujl8C8ICM4RFZnhDricHHr0HezDP1tyHWsI6oyxh0CAEoWY1OTOSiahwjf4VicvrTBQ/64"},{"uid":88687783,"level":35,"nickname":"😂😂😂","out_amount":12701,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160513/cc7313ba435273094ba5.jpg"},{"uid":500011615,"level":46,"nickname":"红鲤鱼与绿鲤鱼与驴","out_amount":12320,"attention":false,"headImgSmall":"http://resource.jufan.tv/jufan/userhead20161015/2ddc4b18f8268ce832b1.png"}]
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
             * uid : 89966526
             * level : 35
             * nickname : 【狼族】～⚡头狼⚡💟
             * out_amount : 46000
             * attention : false
             * headImgSmall : http://resource.jufan.tv/jufan/userhead20161019/9177e0f6cc34c5449082.png
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

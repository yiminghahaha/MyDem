package com.example.kaoshi13.beans;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {

    /**
     * code : 200
     * message : 成功!
     * result : [{"sid":"29387662","text":"这只小二哈是不是瞧不起我？","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0413/d7cafdce5d9311e9a45f842b2b4c75ab_wpd.jpg","video":"http://wvideo.spriteapp.cn/video/2019/0413/d7cafdce5d9311e9a45f842b2b4c75ab_wpd.mp4","images":null,"up":"227","down":"14","forward":"0","comment":"26","uid":"22904237","name":"萌宠真会玩","header":"http://wimg.spriteapp.cn/profile/20180809181850856784.jpeg","top_comments_content":"是家装设计师的眼神","top_comments_voiceuri":"","top_comments_uid":"13264271","top_comments_name":"萍山_练峨眉","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2018/08/21/5b7b1c54804ad_mini.jpg","passtime":"2019-04-14 20:45:02"},{"sid":"29109053","text":"厨师长教你：\u201c碎炒羊肉\u201d家常做法，简单又美味","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0111/5c3854e469a95_wpd.jpg","video":"http://wvideo.spriteapp.cn/video/2019/0111/5c3854e469a95_wpd.mp4","images":null,"up":"333","down":"13","forward":"31","comment":"55","uid":"22971522","name":"美食作家王刚","header":"http://wimg.spriteapp.cn/profile/large/2018/11/01/5bda9ae19d291_mini.jpg","top_comments_content":"买不起羊肉的同学可以不放羊肉","top_comments_voiceuri":"","top_comments_uid":"21198565","top_comments_name":"碧海潮生tEQ9","top_comments_header":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM4kDWjQUgfy8siapPV61icibc3xwooX4XW1uQV6cQte1ZQSAuibK1QzUnKxNmxN8iaor3kxkYhe1icZ0MWw/0","passtime":"2019-01-12 19:57:02"},{"sid":"29274370","text":"2019婚姻新规：离婚后这4样东西必须归男方！女方无权干涉！","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0306/707ee83a-4022-11e9-b8ee-1866daeb0df1_wpd.jpg","video":"http://wvideo.spriteapp.cn/video/2019/0306/707ee83a-4022-11e9-b8ee-1866daeb0df1_wpd.mp4","images":null,"up":"164","down":"15","forward":"3","comment":"28","uid":"17545511","name":"我是陈苗 [百思ta妹]","header":"http://wimg.spriteapp.cn/profile/large/2017/08/28/59a3fe4c5e358_mini.jpg","top_comments_content":"离婚后归还彩礼就行，别整那么么多没用的","top_comments_voiceuri":"","top_comments_uid":"18559611","top_comments_name":"你个山猪","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2018/12/16/5c162d148f691_mini.jpg","passtime":"2019-03-07 20:10:01"},{"sid":"29349554","text":"我把老婆这个摔碎了....问下大概多少钱？","type":"image","thumbnail":null,"video":null,"images":"http://wimg.spriteapp.cn/ugc/2019/04/02/5ca2e0adf341b_1.jpg","up":"275","down":"20","forward":"1","comment":"72","uid":"18682920","name":"黑皮 [黑皮住口]","header":"http://wimg.spriteapp.cn/profile/large/2019/03/21/5c932b6da65f3_mini.jpg","top_comments_content":"你上火吗？我有个大胆的想法","top_comments_voiceuri":"","top_comments_uid":"7424425","top_comments_name":"红桃K","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2018/12/14/5c136e9259403_mini.jpg","passtime":"2019-04-02 16:00:01"},{"sid":"28969662","text":"我在等你 你知道吗？","type":"image","thumbnail":null,"video":null,"images":"http://wimg.spriteapp.cn/ugc/2018/12/04/5c05de2d3d637_1.jpg","up":"810","down":"32","forward":"41","comment":"77","uid":"22921520","name":"齐小钰","header":"http://wimg.spriteapp.cn/profile/large/2018/09/13/5b998cf63c41e_mini.jpg","top_comments_content":"如果真有阴间，死了以后的人能再相聚，想想其实也不错","top_comments_voiceuri":"","top_comments_uid":"17421365","top_comments_name":"一米百公分","top_comments_header":"http://wimg.spriteapp.cn/profile","passtime":"2018-12-04 18:34:02"},{"sid":"29217502","text":"这个可能是我见过最悲催最有味道的鉴宝嘉宾了","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0216/0db1f8a231b611e982f5842b2b4c75ab_wpd.jpg","video":"http://wvideo.spriteapp.cn/video/2019/0216/0db1f8a231b611e982f5842b2b4c75ab_wpd.mp4","images":null,"up":"326","down":"14","forward":"19","comment":"21","uid":"22870418","name":"搞笑小视频","header":"http://wimg.spriteapp.cn/profile/20180902094347507458.jpg","top_comments_content":"6万。。。亿！","top_comments_voiceuri":"","top_comments_uid":"23000372","top_comments_name":"光芒","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2018/12/14/5c13bc44b9ea0_mini.jpg","passtime":"2019-02-16 20:36:02"},{"sid":"29477865","text":"模特很漂亮，摄影师技术很业余！","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0515/5cdb64459b302__b.jpg","video":"http://uvideo.spriteapp.cn/video/2019/0515/5cdb6445bb6e6_wpd.mp4","images":null,"up":"332","down":"13","forward":"5","comment":"82","uid":"5600770","name":"有姓无名","header":"http://wimg.spriteapp.cn/profile/large/2019/04/28/5cc50234622bf_mini.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2019-05-16 15:39:02"},{"sid":"29532989","text":"是本人","type":"image","thumbnail":null,"video":null,"images":"http://wimg.spriteapp.cn/ugc/2019/06/01/258e1c86844e11e99ec7842b2b4c75ab_1.jpg","up":"238","down":"13","forward":"3","comment":"42","uid":"20620957","name":"一身傲气","header":"http://wimg.spriteapp.cn/profile/20190318105309643975.jpg","top_comments_content":"我感觉是d。他头型不一样","top_comments_voiceuri":"","top_comments_uid":"20336191","top_comments_name":"辰辰辰","top_comments_header":"http://wimg.spriteapp.cn/profile","passtime":"2019-06-02 16:02:01"},{"sid":"29425334","text":"【骚操作】惠阳永湖篮球希望，十岁就能玩出这骚操作！","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0425/f1358a54-6702-11e9-9ada-d4ae5296039d_wpd.jpg","video":"http://uvideo.spriteapp.cn/video/2019/0425/f1358a54-6702-11e9-9ada-d4ae5296039d_wpd.mp4","images":null,"up":"257","down":"7","forward":"4","comment":"39","uid":"22904484","name":"香0长哒","header":"http://wimg.spriteapp.cn/profile/20180809222210245933.jpg","top_comments_content":"长大又不知道要祸害多少小姑凉","top_comments_voiceuri":"","top_comments_uid":"22789843","top_comments_name":"你是我舅子","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2019/03/25/5c97b2bc23d2b_mini.jpg","passtime":"2019-04-25 22:14:01"},{"sid":"29176904","text":"铲屎的你看，那小子学你走路","type":"gif","thumbnail":"http://wimg.spriteapp.cn/ugc/2019/02/01/5c53bb9fbac7e_a_1.jpg","video":null,"images":"http://wimg.spriteapp.cn/ugc/2019/02/01/5c53bb9fbac7e.gif","up":"163","down":"6","forward":"3","comment":"10","uid":"22790264","name":"搞笑gif [搞笑gif]","header":"http://wimg.spriteapp.cn/profile/large/2018/09/24/5ba8d427980e5_mini.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2019-02-02 22:20:01"},{"sid":"29348226","text":"外国小姐姐要来拯救中国男同胞了","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0401/823f14da548811e9983c842b2b4c75ab_wpd.jpg","video":"http://uvideo.spriteapp.cn/video/2019/0401/823f14da548811e9983c842b2b4c75ab_wpd.mp4","images":null,"up":"328","down":"14","forward":"0","comment":"52","uid":"20746609","name":"女神大搜索","header":"http://wimg.spriteapp.cn/profile/20180717151732018990.png","top_comments_content":"关键词:二弟，西餐","top_comments_voiceuri":"","top_comments_uid":"21760058","top_comments_name":"百思王大炮","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2018/08/28/5b84c9b9b9de5_mini.jpg","passtime":"2019-04-02 20:57:01"},{"sid":"29168595","text":"中国老规矩，这就是家教","type":"image","thumbnail":null,"video":null,"images":"http://wimg.spriteapp.cn/ugc/2019/01/29/5c4f3f98d5b59_1.jpg","up":"167","down":"11","forward":"12","comment":"44","uid":"22018647","name":"夸塔停夸零停夸","header":"http://wimg.spriteapp.cn/profile/large/2019/01/27/5c4d004ca31ea_mini.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2019-01-30 00:36:01"},{"sid":"29214747","text":"【完整版】桂纶镁&彭于晏益达广告，这可能是我追过的最早的连续剧式广告","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0215/ea0e7802-30fd-11e9-8936-1866daeb0df1_wpd.jpg","video":"http://wvideo.spriteapp.cn/video/2019/0215/ea0e7802-30fd-11e9-8936-1866daeb0df1_wpd.mp4","images":null,"up":"286","down":"9","forward":"29","comment":"33","uid":"23017420","name":"沙雕专员","header":"http://wimg.spriteapp.cn/profile/large/2019/01/21/5c455ba9cf43f_mini.jpg","top_comments_content":"拔丝煎面呢？等半天了，没有吗？","top_comments_voiceuri":"","top_comments_uid":"22668023","top_comments_name":"後x来","top_comments_header":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLe6deL6cyryuJzaE7mP7rpBOEOXibE5blfxlZ5ZxicURpC5FZH9WFm3o7CKWFmv3COYRHMDc9Yvapw/132","passtime":"2019-02-16 22:06:01"},{"sid":"29486302","text":"左手韩新做","type":"image","thumbnail":null,"video":null,"images":"http://wimg.spriteapp.cn/ugc/2019/05/20/5ce1cf0ba4af6_1.jpg","up":"266","down":"35","forward":"1","comment":"37","uid":"20407969","name":"百思也有爱","header":"http://wimg.spriteapp.cn/profile/large/2018/12/18/5c18912328e9b_mini.jpg","top_comments_content":"发图发一半，菊花被捅烂。","top_comments_voiceuri":"","top_comments_uid":"23028920","top_comments_name":"尐魏222","top_comments_header":"http://qzapp.qlogo.cn/qzapp/100336987/DB955C9AF002D4C2E5B41942F16E983F/100","passtime":"2019-05-21 18:02:01"},{"sid":"28725511","text":"一个水杯里的道理，人就得知足","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2018/1016/25be7a56d13011e89e78842b2b4c75ab_wpd.jpg","video":"http://wvideo.spriteapp.cn/video/2018/1016/25be7a56d13011e89e78842b2b4c75ab_wpd.mp4","images":null,"up":"480","down":"38","forward":"36","comment":"110","uid":"22905199","name":"故事会","header":"http://wimg.spriteapp.cn/profile/20180810145410379681.png","top_comments_content":"龙头公道杯","top_comments_voiceuri":"","top_comments_uid":"21156463","top_comments_name":"百娱百思","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2018/04/22/5adbc7f7d210c_mini.jpg","passtime":"2018-10-16 22:41:02"},{"sid":"29312763","text":"27个由网友讲述的民间诡异传闻，看完感觉背后凉凉的...","type":"image","thumbnail":null,"video":null,"images":"http://wimg.spriteapp.cn/ugc/2019/03/20/5c923ea521f33_1.jpg","up":"335","down":"22","forward":"55","comment":"67","uid":"8841843","name":"朴朴乐 [苍井玛利亚]","header":"http://wimg.spriteapp.cn/profile/large/2019/03/16/5c8cbd8600d55_mini.jpg","top_comments_content":"无意点开，有事找蔡徐坤就行","top_comments_voiceuri":"","top_comments_uid":"21751015","top_comments_name":"夜夜笙箫222","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2019/02/23/5c70a24fdb854_mini.jpg","passtime":"2019-03-21 16:06:01"},{"sid":"29446289","text":"这波狗粮，我吃的很爽，你呢","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0504/5ccd484b9eb41_wpd.jpg","video":"http://wvideo.spriteapp.cn/video/2019/0504/5ccd484b9eb41_wpd.mp4","images":null,"up":"214","down":"24","forward":"4","comment":"8","uid":"21701540","name":"老撕酷","header":"http://wimg.spriteapp.cn/profile/large/2019/04/19/5cb9c8bcb0b2f_mini.png","top_comments_content":"我竟然看完了","top_comments_voiceuri":"","top_comments_uid":"21712755","top_comments_name":"流云mah","top_comments_header":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJJAbbmbKTjCsEVXyyvGKYxFahAJHxz3rfC1bDUKUYFDr8uGTKMdH0fdGicmMGabcLRdnq6kIiciaIfw/132","passtime":"2019-05-05 23:53:01"},{"sid":"28828657","text":"游戏打得太菜，不是装备不行，而是你不行。  \u2014\u2014你的游戏人物 ","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2018/1109/28828657_620.jpg","video":"http://wvideo.spriteapp.cn/video/2018/1109/8273aeece3e111e8a329842b2b4c75ab_wpd.mp4","images":null,"up":"1083","down":"37","forward":"134","comment":"94","uid":"22870390","name":"深井冰啊","header":"http://wimg.spriteapp.cn/profile/20180902094314856721.jpg","top_comments_content":"你这广告相当成功，我决定了，我买小米手机","top_comments_voiceuri":"","top_comments_uid":"18809757","top_comments_name":"好钢用在刀背上","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2018/08/17/5b76e60f06b13_mini.jpg","passtime":"2018-11-09 17:37:02"},{"sid":"29220091","text":"为了打折是拼了","type":"image","thumbnail":null,"video":null,"images":"http://wimg.spriteapp.cn/ugc/2019/02/17/5c68cd48c0f48_1.jpg","up":"223","down":"8","forward":"7","comment":"19","uid":"21631983","name":"小菊花课堂","header":"http://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEJVarUicIf2V8q40gXqSKgGVtl4icASW0tibpOia0gdicialDz3eH0ic7xjxBmuhiceBicRoltBUF8B6SyqOCQ/0","top_comments_content":"我觉得 他俩不是为了打折而来的","top_comments_voiceuri":"","top_comments_uid":"22945463","top_comments_name":"正在加载中","top_comments_header":"http://wimg.spriteapp.cn/p/jie.jpg","passtime":"2019-02-18 22:04:02"},{"sid":"29398649","text":"农村小伙二牛今天烤了一整只鸡，吃上了名副其实的手撕鸡，撒上辣椒面和孜然粉的那一刻，简直太爽了。","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0416/5cb59bb4d8fd5_wpd.jpg","video":"http://wvideo.spriteapp.cn/video/2019/0416/5cb59bb4d8fd5_wpd.mp4","images":null,"up":"174","down":"25","forward":"1","comment":"37","uid":"23055541","name":"山药村二牛","header":"http://wimg.spriteapp.cn/profile/20190308093719160709.jpg","top_comments_content":"天龙八部洛阳城的背景音乐，简直不要太怀念","top_comments_voiceuri":"","top_comments_uid":"21051243","top_comments_name":"许冭冭","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2018/05/25/5b0773e8d6bab_mini.jpg","passtime":"2019-04-18 21:30:01"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * sid : 29387662
         * text : 这只小二哈是不是瞧不起我？
         * type : video
         * thumbnail : http://wimg.spriteapp.cn/picture/2019/0413/d7cafdce5d9311e9a45f842b2b4c75ab_wpd.jpg
         * video : http://wvideo.spriteapp.cn/video/2019/0413/d7cafdce5d9311e9a45f842b2b4c75ab_wpd.mp4
         * images : null
         * up : 227
         * down : 14
         * forward : 0
         * comment : 26
         * uid : 22904237
         * name : 萌宠真会玩
         * header : http://wimg.spriteapp.cn/profile/20180809181850856784.jpeg
         * top_comments_content : 是家装设计师的眼神
         * top_comments_voiceuri :
         * top_comments_uid : 13264271
         * top_comments_name : 萍山_练峨眉
         * top_comments_header : http://wimg.spriteapp.cn/profile/large/2018/08/21/5b7b1c54804ad_mini.jpg
         * passtime : 2019-04-14 20:45:02
         */

        private String sid;
        private String text;
        private String type;
        private String thumbnail;
        private String video;
        private Object images;
        private String up;
        private String down;
        private String forward;
        private String comment;
        private String uid;
        private String name;
        private String header;
        private String top_comments_content;
        private String top_comments_voiceuri;
        private String top_comments_uid;
        private String top_comments_name;
        private String top_comments_header;
        private String passtime;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public Object getImages() {
            return images;
        }

        public void setImages(Object images) {
            this.images = images;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getDown() {
            return down;
        }

        public void setDown(String down) {
            this.down = down;
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getTop_comments_content() {
            return top_comments_content;
        }

        public void setTop_comments_content(String top_comments_content) {
            this.top_comments_content = top_comments_content;
        }

        public String getTop_comments_voiceuri() {
            return top_comments_voiceuri;
        }

        public void setTop_comments_voiceuri(String top_comments_voiceuri) {
            this.top_comments_voiceuri = top_comments_voiceuri;
        }

        public String getTop_comments_uid() {
            return top_comments_uid;
        }

        public void setTop_comments_uid(String top_comments_uid) {
            this.top_comments_uid = top_comments_uid;
        }

        public String getTop_comments_name() {
            return top_comments_name;
        }

        public void setTop_comments_name(String top_comments_name) {
            this.top_comments_name = top_comments_name;
        }

        public String getTop_comments_header() {
            return top_comments_header;
        }

        public void setTop_comments_header(String top_comments_header) {
            this.top_comments_header = top_comments_header;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }
    }
}

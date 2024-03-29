package com.yucong;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.yucong.dao.BookRepository;
import com.yucong.entity.Book;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ESApp.class)
public class BookTest {

    @Autowired
    private ElasticsearchTemplate esTemplete;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void createIndex() {
        boolean createIndex = esTemplete.createIndex(Book.class);
        System.out.println(createIndex);
    }

    @Test
    public void deleteIndex() {
        boolean deleteIndex = esTemplete.deleteIndex(Book.class);
        System.out.println(deleteIndex);
    }

    @Test
    public void save() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("1", "笑傲江湖", aa, new Date(), 24.34, 100));
        list.add(new Book("2", "天龙八部", bb, new Date(), 78.00, 110));
        list.add(new Book("3", "越女剑", cc, new Date(), 12.33, 89));
        list.add(new Book("4", "连城诀", dd, new Date(), 34.32, 300));
        list.add(new Book("5", "侠客行", ee, new Date(), 40.98, 281));
        list.add(new Book("6", "射雕英雄传", ff, new Date(), 12.98, 187));
        list.add(new Book("7", "神雕侠侣", gg, new Date(), 67.00, 72));
        list.add(new Book("8", "倚天屠龙记", hh, new Date(), 33.09, 400));

        bookRepository.saveAll(list);
    }



    private String aa =
            "《笑傲江湖》是中国现代作家金庸创作的一部长篇武侠小说，于1967年开始创作并连载于《明报》，1969年完成。小说通过叙述华山派大弟子令狐冲的经历，反映了武林各派争霸夺权的历程。作者没有设置时代背景，“类似的情景可以发生在任何朝代”，其所折射中国人独特的政治斗争，同时也表露出对斗争的哀叹，具有一定的政治寓意。小说情节跌宕起伏，波谲云诡，人物形象个性鲜明，生动可感。东方不败。风清扬。华山剑宗高手，独孤九剑破尽天下武功，霸气侧漏。方证大师。令狐冲（练独孤九剑、吸星大法后）。后期令狐冲学会易筋经，内力大盛，武功应该不次于方证。任我行。岳不群（练辟邪剑法后）。左冷禅。和任我行过招时，凭自创的寒冰真气成功暗算任我行，也算是一代武学奇才。冲虚道长。向问天。林平之（练辟邪剑法后）。";

    private String bb =
            "《天龙八部》是中国现代作家金庸创作的长篇武侠小说。这部小说从1963年开始创作，历时4年完成。前后共有三版，并在2005年第三版中经历6稿修订，结局改动较大。小说以宋哲宗时代为背景，通过宋、辽、大理、西夏、吐蕃等王国之间的武林恩怨和民族矛盾，从哲学的高度对人生和社会进行审视和描写，展示了一幅波澜壮阔的生活画卷，其故事之离奇曲折、涉及人物之众多、历史背景之广泛、武侠战役之庞大、想象力之丰富当属“金书”之最。书名出于佛经，有“世间众生”的意思，寓意象征着大千世界的芸芸众生，背后笼罩着佛法的无边与超脱。全书主旨“无人不冤，有情皆孽”，作品风格宏伟悲壮，是一部写尽人性、悲剧色彩浓厚的史诗巨著。扫地僧。代表武功：无形气墙。虚竹。代表武功：小无相功，天山六阳掌、天山折梅手等。段誉。代表武功：六脉神剑、北冥神功。萧峰。代表武功：降龙十八掌、打狗棒法、太祖长拳等。鸠摩智。代表武功：火焰刀。逍遥三老：无涯子、李秋水、天山童姥。慕容博。代表武功：斗转星移。萧远山。代表武功：不详。";
    private String cc =
            "《越女剑》是作家金庸创作的短篇武侠小说，发表于1970年1月《明报晚报》上。小说写越女阿青剑术精妙，被范蠡引荐到宫中教授士兵，最终帮助了越王勾践雪耻复仇。阿青暗暗爱上了范蠡，而范蠡早与西施有白头之约。阿青见到西施的美貌后，不忍伤害，飘然离去。小说借助历史上的传说和事实，不但抒发了历史情怀，还表现出人性的悲歌，把家国之仇与个人的爱结合在一起，使小说增加了厚重感和无限的余味。";
    private String dd =
            "《连城诀》是当代作家金庸创作的长篇武侠小说，最初在1963年刊载于《明报》和新加坡《南洋商报》合办送的《东南亚周刊》，书名本做《素心剑》。《连城诀》讲述农家子弟狄云因为生性质朴，屡被冤枉欺骗，在历经磨难之后，终于看穿人世险恶，回归自然的故事。该书情节跌宕起伏、环环相扣，人物性格鲜明。狄云。血刀老祖。梅念笙。丁典。刘乘风。陆天抒。水岱。花铁干。万震山。言达平。《血刀经》。《神照经》。";
    private String ee =
            "《侠客行》是当代作家金庸创作的长篇武侠小说，1965年首次连载于《东南亚周刊》。《侠客行》主要叙述一个懵懂少年石破天的江湖经历。该书有许多耐人寻思之处，潜隐着许多“玄机”，体现着金庸对于人生、人性、生命和宇宙的新的体验。石破天、龙岛主、木岛主、张三、李四、愚茶、白自在、谢烟客、天虚、大悲老人、贝海石、丁不三、丁不四、梅芳姑、石清、白万剑、闵柔、冲虚、廖自励、米横野、陈冲之、梅文馨";
    private String ff =
            "《射雕英雄传》是金庸创作的长篇武侠小说，最初连载于1957～1959年的《香港商报》，后收录在《金庸作品集》中， 是金庸“射雕三部曲”的第一部。《射雕英雄传》以宁宗庆元五年（1199年）至成吉思汗逝世（1227年）这段历史为背景，反映了南宋抵抗金国与蒙古两大强敌的斗争，充满爱国的民族主义情愫。该小说历史背景突出，场景纷繁，气势宏伟，具有鲜明的“英雄史诗”风格；在人物创造与情节安排上，它打破了传统武侠小说一味传奇，将人物作为情节附庸的模式，坚持以创造个性化的人物形象为中心，坚持人物统帅故事，按照人物性格的发展需要及其内在可能性、必然性来设置情节，从而使这部小说达到了事虽奇人却真的妙境。梅超风：九阴白骨爪、摧心掌。陈玄风：九阴白骨爪、摧心掌。裘千仞：铁掌功。郭靖：九阴真经、降龙十八掌、双手互搏、空明拳。段智兴：先天功、一阳指。洪七公：降龙十八掌、打狗棒法、小部分九阴真经。黄药师：弹指神通、碧海潮生曲、落英神剑掌、劈空掌等桃花岛武功。欧阳锋：逆练九阴真经、蛤蟆功、灵蛇拳。王重阳：先天功、一阳指、金雁功、全真剑法、同归剑法等全真教武功。周伯通武功：九阴真经、双手互搏、空明拳。";
    private String gg =
            "《神雕侠侣》是作家金庸创作的长篇武侠小说，1959—1961年连载于香港《明报》，共四十回，是金庸“射雕三部曲”系列的第二部。小说的主脉写的是“叛国贼”杨康之遗孤杨过与其师小龙女之间的爱情故事。杨过从小师从小龙女于古墓之中苦练武功，师徒二人情深义重，却无奈于江湖阴鸷险恶、蒙古铁骑来犯使得有情之人难成眷属。历经一番坎坷与磨难的考验，杨过冲破封建礼教之禁锢，最终与小龙女由师徒变为“侠侣”。同时，在这段磨难经历中，杨过也消除了对郭靖、黄蓉夫妇的误会，在家仇与国难间作出抉择，成为真正的“侠之大者”。金庸在该作品中将武功与性格结合起来写。在武功中写个性，成功地塑造了多种鲜活的人物形象。小说中的主要人物性格鲜明，有血有肉，栩栩如生。金轮法王龙象般若功欧阳锋洪七公黄药师一灯大师杨过郭靖周伯通";
    private String hh =
            "《倚天屠龙记》是作家金庸创作的长篇武侠小说，连载于1961—1962年的香港《明报》，是“射雕三部曲”系列第三部。《倚天屠龙记》以安徽农民朱元璋揭竿而起建立明朝天下为背景，以张无忌的成长为线索，叙写江湖上的各帮各派、各种人物的恩怨情仇，它把中国历史上元朝的兴衰和江湖道义、恩仇平行交叉起来。 [2]  该书表达了作者既反对异族侵略，也反对本民族暴政的思想。《倚天屠龙记》把《明报》自《神雕侠侣》以来所产生的影响进一步扩大，把读者的眼光和注意力吸引和固定在了《明报》上。张三丰>张无忌九阳神功全本、太极拳、太极剑、乾坤大挪移、圣火令武功阳顶天>空见>渡厄＞渡难≥渡劫＝成昆>鹿杖客=鹤笔翁俞莲舟>杨逍≥空闻≥范遥=空智=宋远桥≥鹰王≥狮王＞蝠王≥龙王=灭绝黄衫女和周芷若";
}

package com.yucong;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import com.yucong.dao.ItemRepository;
import com.yucong.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ESApp.class)
public class ESAppTest {

    @Autowired
    private ElasticsearchTemplate esTemplete;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void createIndex() {
        boolean createIndex = esTemplete.createIndex(User.class);
        System.out.println(createIndex);
    }

    @Test
    public void deleteIndex() {
        boolean deleteIndex = esTemplete.deleteIndex(User.class);
        System.out.println(deleteIndex);
    }

    /**
     * https://www.elastic.co/guide/cn/index.html
     */
    @Test
    public void save() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<User> list = new ArrayList<>();
        list.add(new User(1l, "赵敏", "女", 25, "排球，足球，游泳", "江苏省", "淮安市", sdf.parse("2017-01-01"), ""));
        list.add(new User(2l, "钱钟书", "男", 58, "足球，书法", "江苏省", "淮安市", sdf.parse("2018-02-31"), ""));
        list.add(new User(3l, "孙满堂", "男", 78, "跑步，篮球，羽毛球", "江苏省", "南京市", sdf.parse("2019-01-01"), ""));
        list.add(new User(4l, "李白", "男", 34, "书法，篮球", "江苏省", "南京市", sdf.parse("2019-01-01"), ""));
        list.add(new User(5l, "周武王", "男", 58, "跑步", "山东省", "济南市", sdf.parse("2019-02-01"), ""));
        list.add(new User(6l, "吴文周", "男", 50, "排球，游泳，足球", "山东省", "济南市", sdf.parse("2019-02-01"), ""));
        list.add(new User(7l, "郑爽", "女", 28, "乒乓球，高尔夫，台球", "山东省", "青岛市", sdf.parse("2019-11-21"), ""));
        list.add(new User(8l, "王老汉", "男", 28, "台球，足球", "山东省", "青岛市", sdf.parse("2019-11-25"), ""));
        itemRepository.saveAll(list);
    }

    @Test
    public void testMatchQuery() {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米"));

        // 搜索，获取结果
        Page<User> items = this.itemRepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        System.out.println("total = " + total);
        for (User item : items) {
            System.out.println(item);
        }
    }

    @Test
    public void findAll() {
        Iterable<User> all = itemRepository.findAll();
        for (User item : all) {
            System.out.println(item);
        }
    }

}

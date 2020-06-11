package com.zucc.edu.javen.tw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zucc.edu.javen.tw.entity.ItemEntity;
import com.zucc.edu.javen.tw.service.NewsService;
import com.zucc.edu.javen.tw.util.JsonUtil;
import com.zucc.edu.javen.tw.util.NgramsTokenizer;
import com.zucc.edu.javen.tw.util.Tokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class CombinedNewsController {
    NewsController dataController = new NewsController();
    Tokenizer tokenizer = new NgramsTokenizer();

    @Autowired
    private NewsService service;

    @PostMapping("/combine/now")
    @SuppressWarnings("unchecked")
    public JSONObject getAllNewsList() {
        //done: baidu zhihu

        Map<String, Integer> Participle = new HashMap<String, Integer>();
        Set<String> tokens = new HashSet<String>();
        List<ItemEntity> itemList = new ArrayList<ItemEntity>();

        JSONObject wangyi = dataController.getNewstext("wangyi", new Date());
        List<JSONObject> data = (List<JSONObject>) wangyi.get("data");
        processItem(Participle, tokens, itemList, data, "wangyi");

        JSONObject kr36 = dataController.getNewstext("kr36", new Date());
        data = (List<JSONObject>) kr36.get("data");
        processItem(Participle, tokens, itemList, data, "kr36");

        JSONObject baidu = dataController.getNewstext("baidu", new Date());
        data = (List<JSONObject>) ((JSONObject) (baidu.get("hot"))).get("data");
        processItem(Participle, tokens, itemList, data, "baidu_hot");
        data = (List<JSONObject>) ((JSONObject) (baidu.get("tieba"))).get("data");
        processItem(Participle, tokens, itemList, data, "baidu_tieba");

        JSONObject guokr = dataController.getNewstext("guokr", new Date());
        data = (List<JSONObject>) guokr.get("data");
        processItem(Participle, tokens, itemList, data, "guokr");

        JSONObject pearvideo = dataController.getNewstext("pearvideo", new Date());
        data = (List<JSONObject>) pearvideo.get("data");
        processItem(Participle, tokens, itemList, data, "pearvideo");

        JSONObject pengpai = dataController.getNewstext("pengpai", new Date());
        data = (List<JSONObject>) pengpai.get("data");
        processItem(Participle, tokens, itemList, data, "pengpai");

        JSONObject toutiao = dataController.getNewstext("toutiao", new Date());
        data = (List<JSONObject>) wangyi.get("data");
        processItem(Participle, tokens, itemList, data, "toutiao");

        JSONObject weibo = dataController.getNewstext("weibo", new Date());
        data = (List<JSONObject>) weibo.get("data");
        processItem(Participle, tokens, itemList, data, "weibo");

//        JSONObject yc=dataController.getNewstext("yc",new Date());
//        data= (List<JSONObject>) yc.get("data");
//        processItem(Participle,tokens, itemList, data,"yc");

        JSONObject zhihu = dataController.getNewstext("zhihu", new Date());
        data = (List<JSONObject>) ((JSONObject) (zhihu.get("hot"))).get("data");
        processItem(Participle, tokens, itemList, data, "zhihu_hot");
        data = (List<JSONObject>) ((JSONObject) (zhihu.get("word"))).get("data");
        processItem(Participle, tokens, itemList, data, "zhihu_word");

        JSONObject kepuchina = dataController.getNewstext("kepuchina", new Date());
        data = (List<JSONObject>) kepuchina.get("data");
        processItem(Participle, tokens, itemList, data, "kepuchina");

        List<Map.Entry<String, Integer>> tokenValue = new ArrayList(Participle.entrySet());
        Collections.sort(tokenValue, (o1, o2) -> (o2.getValue() - o1.getValue()));
        return createJsonResponse(itemList, tokenValue);
    }

    @PostMapping("/combine/all")
    @SuppressWarnings("unchecked")
    public JSONObject getAllNewsList(HttpServletRequest request) {
        String date = JsonUtil.getBody(request);
        JSONObject jsonObject = null;
        String getDate = JsonUtil.getDate(date);

        Map<String, Integer> Participle = new HashMap<String, Integer>();
        Set<String> tokens = new HashSet<String>();
        List<ItemEntity> itemList = new ArrayList<ItemEntity>();

        if (getDate != null) {
            JSONObject wangyi = service.getAllHisNewsList("wangyi", getDate);
            List<JSONObject> data = (List<JSONObject>) wangyi.get("data");
            processItem(Participle, tokens, itemList, data, "wangyi");

            JSONObject kr36 = service.getAllHisNewsList("kr36", getDate);
            data = (List<JSONObject>) kr36.get("data");
            processItem(Participle, tokens, itemList, data, "kr36");

            JSONObject baidu = service.getAllHisNewsList("baidu", getDate);
            data = (List<JSONObject>) ((JSONObject) (baidu.get("hot"))).get("data");
            processItem(Participle, tokens, itemList, data, "baidu_hot");
            data = (List<JSONObject>) ((JSONObject) (baidu.get("tieba"))).get("data");
            processItem(Participle, tokens, itemList, data, "baidu_tieba");

            JSONObject guokr = service.getAllHisNewsList("guokr", getDate);
            data = (List<JSONObject>) guokr.get("data");
            processItem(Participle, tokens, itemList, data, "guokr");

            JSONObject pearvideo = service.getAllHisNewsList("pearvideo", getDate);
            data = (List<JSONObject>) pearvideo.get("data");
            processItem(Participle, tokens, itemList, data, "pearvideo");

            JSONObject pengpai = service.getAllHisNewsList("pengpai", getDate);
            data = (List<JSONObject>) pengpai.get("data");
            processItem(Participle, tokens, itemList, data, "pengpai");

            JSONObject toutiao = service.getAllHisNewsList("toutiao", getDate);
            data = (List<JSONObject>) wangyi.get("data");
            processItem(Participle, tokens, itemList, data, "toutiao");

            JSONObject weibo = service.getAllHisNewsList("weibo", getDate);
            data = (List<JSONObject>) weibo.get("data");
            processItem(Participle, tokens, itemList, data, "weibo");

//        JSONObject yc=service.getAllHisNewsList("yc",getDate);
//        data= (List<JSONObject>) yc.get("data");
//        processItem(Participle,tokens, itemList, data,"yc");

            JSONObject zhihu = service.getAllHisNewsList("zhihu", getDate);
            data = (List<JSONObject>) ((JSONObject) (zhihu.get("hot"))).get("data");
            processItem(Participle, tokens, itemList, data, "zhihu_hot");
            data = (List<JSONObject>) ((JSONObject) (zhihu.get("word"))).get("data");
            processItem(Participle, tokens, itemList, data, "zhihu_word");

            JSONObject kepuchina = service.getAllHisNewsList("kepuchina", getDate);
            data = (List<JSONObject>) kepuchina.get("data");
            processItem(Participle, tokens, itemList, data, "kepuchina");
        } else {
            JSONObject wangyi = service.getAllNewsList("wangyi");
            List<JSONObject> data = (List<JSONObject>) wangyi.get("data");
            processItem(Participle, tokens, itemList, data, "wangyi");

            JSONObject kr36 = service.getAllNewsList("kr36");
            data = (List<JSONObject>) kr36.get("data");
            processItem(Participle, tokens, itemList, data, "kr36");

            JSONObject baidu = service.getAllNewsList("baidu");
            data = (List<JSONObject>) ((JSONObject) (baidu.get("hot"))).get("data");
            processItem(Participle, tokens, itemList, data, "baidu_hot");
            data = (List<JSONObject>) ((JSONObject) (baidu.get("tieba"))).get("data");
            processItem(Participle, tokens, itemList, data, "baidu_tieba");

            JSONObject guokr = service.getAllNewsList("guokr");
            data = (List<JSONObject>) guokr.get("data");
            processItem(Participle, tokens, itemList, data, "guokr");

            JSONObject pearvideo = service.getAllNewsList("pearvideo");
            data = (List<JSONObject>) pearvideo.get("data");
            processItem(Participle, tokens, itemList, data, "pearvideo");

            JSONObject pengpai = service.getAllNewsList("pengpai");
            data = (List<JSONObject>) pengpai.get("data");
            processItem(Participle, tokens, itemList, data, "pengpai");

            JSONObject toutiao = service.getAllNewsList("toutiao");
            data = (List<JSONObject>) wangyi.get("data");
            processItem(Participle, tokens, itemList, data, "toutiao");

            JSONObject weibo = service.getAllNewsList("weibo");
            data = (List<JSONObject>) weibo.get("data");
            processItem(Participle, tokens, itemList, data, "weibo");

//        JSONObject yc=service.getAllNewsList("yc" );
//        data= (List<JSONObject>) yc.get("data");
//        processItem(Participle,tokens, itemList, data,"yc");

            JSONObject zhihu = service.getAllNewsList("zhihu");
            data = (List<JSONObject>) ((JSONObject) (zhihu.get("hot"))).get("data");
            processItem(Participle, tokens, itemList, data, "zhihu_hot");
            data = (List<JSONObject>) ((JSONObject) (zhihu.get("word"))).get("data");
            processItem(Participle, tokens, itemList, data, "zhihu_word");

            JSONObject kepuchina = service.getAllNewsList("kepuchina");
            data = (List<JSONObject>) kepuchina.get("data");
            processItem(Participle, tokens, itemList, data, "kepuchina");
        }


        List<Map.Entry<String, Integer>> tokenValue = new ArrayList(Participle.entrySet());
        Collections.sort(tokenValue, (o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return (o2.getKey().length() - o1.getKey().length());

            } else {
                return (o2.getValue() - o1.getValue());
            }
        });

        return createJsonResponse(itemList, tokenValue);
    }

    private JSONObject createJsonResponse(List<ItemEntity> itemList, List<Map.Entry<String, Integer>> tokenValue) {
        String MaxKey = null;
        int MaxValue = 0;
        try {
            MaxKey = tokenValue.get(0).getKey();
            MaxValue = tokenValue.get(0).getValue();
        } catch (Exception e) {
            MaxKey = null;
        }


        JSONObject json = new JSONObject(true);

        json.put("mostHot", MaxKey);
        json.put("mentioned", MaxValue);
        List<JSONObject> itemJson = new ArrayList<JSONObject>();
        int id = 0;
        for (ItemEntity itemEntity : itemList) {
            if (itemEntity.getParticiple().get(MaxKey) != null) {
                id++;
                JSONObject item = new JSONObject(true);
                item.put("id", id);
                item.put("title", itemEntity.getTitle());
                item.put("url", itemEntity.getUrl());
                item.put("from", itemEntity.getFrom());
                itemJson.add(item);
            }
        }
        json.put("data", itemJson);
        return json;
    }

    private void processItem(Map<String, Integer> Participle, Set<String> tokens, List<ItemEntity> itemList, List<JSONObject> data, String from) {
        for (JSONObject datum : data) {
            ItemEntity newItem = new ItemEntity();
            String title = datum.getString("title");
            List<String> tokenList = tokenizer.tokenize(title);
            newItem.setFrom(from);
            newItem.setTitle(datum.getString("title"));
            newItem.setUrl(datum.getString("url"));
            Map<String, Integer> participle = newItem.getParticiple();
            for (String s : tokenList) {
                tokens.add(s);
                if (participle.containsKey(s)) {
                    participle.put(s, participle.get(s) + 1);
                } else {
                    participle.put(s, 1);
                }
                if (Participle.containsKey(s)) {
                    Participle.put(s, Participle.get(s) + 1);
                } else {
                    Participle.put(s, 1);
                }
            }
            newItem.setParticiple(participle);
            itemList.add(newItem);
        }
    }

}

package org.reploop.parser.json;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reploop.parser.json.base.JsonBaseParser;
import org.reploop.parser.json.tree.Json;

import java.io.StringReader;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2017-01-23 14
 */
public class JsonParserTest {

  private JsonParser parser;

  @BeforeEach
  public void setUp() throws Exception {
    parser = new JsonParser();
  }

  @Test
  public void testParse() throws Exception {
    StringReader reader = new StringReader("{ \"data\":[{\"tv_id\":6706484709,\"tv_name\":\"国宝在民间 第十六期\",\"play_url\":\"http://www.ireploop.com/w_19rug8t7d5.html\",\"count_yesterday\":73945,\"count_last_week\":210443,\"count_history\":263458,\"rank_trend\":-1,\"comment_rate\":0,\"vv_week\":237591},{\"tv_id\":7133533109,\"tv_name\":\"扒开秧苗竟然发现了鱼窝，好吃惊\",\"play_url\":\"http://www.ireploop.com/w_19ru5jq8k9.html\",\"count_yesterday\":4157,\"count_last_week\":6197,\"count_history\":6197,\"rank_trend\":1,\"comment_rate\":0,\"vv_week\":10361},{\"tv_id\":2210869209,\"tv_name\":\"筷子兄弟 - 小苹果《标准版MV》\",\"play_url\":\"http://www.ireploop.com/w_19rsiaqmyd.html\",\"count_yesterday\":2195,\"count_last_week\":19159,\"count_history\":2196254,\"rank_trend\":-1,\"comment_rate\":0,\"vv_week\":55877},{\"tv_id\":4443275309,\"tv_name\":\"《一人我饮酒醉》网络神曲，全网最全版本，听完洗脑\",\"play_url\":\"http://www.ireploop.com/w_19rtfas0g1.html\",\"count_yesterday\":1494,\"count_last_week\":13004,\"count_history\":143545,\"rank_trend\":-1,\"comment_rate\":0,\"vv_week\":38019},{\"tv_id\":4332746609,\"tv_name\":\"老梁故事汇 狂人周立波\",\"play_url\":\"http://www.ireploop.com/w_19rthy34m5.html\",\"count_yesterday\":659,\"count_last_week\":1473,\"count_history\":23645,\"rank_trend\":1,\"comment_rate\":0,\"vv_week\":2752},{\"tv_id\":4470910709,\"tv_name\":\"最近在油管上超级火的舞蹈Tez cadey - Seve __ Mongol\",\"play_url\":\"http://www.ireploop.com/w_19rtfostqx.html\",\"count_yesterday\":576,\"count_last_week\":7010,\"count_history\":54271,\"rank_trend\":1,\"comment_rate\":0,\"vv_week\":33958},{\"tv_id\":5780657809,\"tv_name\":\"66班那些事儿\",\"play_url\":\"http://www.ireploop.com/w_19rt22opod.html\",\"count_yesterday\":348,\"count_last_week\":932,\"count_history\":932,\"rank_trend\":1,\"comment_rate\":0,\"vv_week\":5970},{\"tv_id\":4998578809,\"tv_name\":\"陕西相声专场《翻拍》苗阜、王声\",\"play_url\":\"http://www.ireploop.com/w_19rt63p2qd.html\",\"count_yesterday\":288,\"count_last_week\":1154,\"count_history\":34031,\"rank_trend\":1,\"comment_rate\":0,\"vv_week\":1999},{\"tv_id\":6124344909,\"tv_name\":\"熊出没之过年搞笑花絮 保护森林记\",\"play_url\":\"http://www.ireploop.com/w_19rspg5fdt.html\",\"count_yesterday\":260,\"count_last_week\":966,\"count_history\":1057,\"rank_trend\":1,\"comment_rate\":0,\"vv_week\":9606},{\"tv_id\":4467916609,\"tv_name\":\"《欢乐喜剧人》大全 宋小宝小品《甄嬛后传》\",\"play_url\":\"http://www.ireploop.com/w_19rtfqqsdp.html\",\"count_yesterday\":230,\"count_last_week\":2221,\"count_history\":33770,\"rank_trend\":-1,\"comment_rate\":0,\"vv_week\":5505}],\"code\":\"A00000\"}");
    Json value = (Json) parser.parse(reader, JsonBaseParser::json);
    System.out.println(value);
  }
}
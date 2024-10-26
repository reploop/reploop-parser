package org.reploop.translator.json;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class Json2BeanAppTest {

	@Test
	@Ignore
	public void url() throws IOException {
		String url = "https://cxsj.hnygst.com/prod-api/api/serviceList?name=&typeId=&longitude=&latitude=&page=1&limit=10";
		Json2App.main("all", "-n", "org.reploop.json", "--uri", url, "--output",
				"/Users/george/open-source/reploop/reploop-parser/json2bean-standalone/target");

	}

}
package com.qiyi.walle.parser.thrift;


import com.qiyi.walle.parser.thrift.tree.ThriftProgram;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-05 14
 */
public class ThriftParserTest {
    ThriftParser parser;

    @BeforeMethod
    public void setUp() throws Exception {
        parser = new ThriftParser();
    }

    @Test
    public void testCreateProgram() throws Exception {
        URL uri = ClassLoader.getSystemClassLoader().getResource("write_rpc_service.thrift");
        assert uri != null;
        ThriftProgram ThriftProgram = parser.program(Paths.get(uri.toURI()));
        System.out.println(ThriftProgram);
    }

    @Test
    public void testParse() throws Exception {
        File file = new File("/Users/lanlan/Workspace/vrs/vrs-service/trunk/vis-services/vis-ugc/vis-ugc-api/src/main/thrift/model/ugc_video.thrift");
        ThriftProgram ThriftProgram = parser.program(file.toPath());
        System.out.println(ThriftProgram);

    }

    @Test
    public void testService() throws Exception {
        File file = new File("/Users/lanlan/Workspace/vrs/vrs-service/trunk/vis-services/vis-ugc/vis-ugc-api/src/main/thrift/service/ugc_video_service.thrift");
        ThriftProgram ThriftProgram = parser.program(file.toPath());
        System.out.println(ThriftProgram);
    }
}
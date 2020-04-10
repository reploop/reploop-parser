package com.qiyi.walle.parser.thrift.type;

import com.qiyi.walle.parser.QualifiedName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2017-06-15 09
 */
public class WrapperType extends FieldType {
    private static final Logger LOG = LoggerFactory.getLogger(WrapperType.class);

    public WrapperType(String name) {
        super(name);
    }

    public WrapperType(QualifiedName name) {
        super(name);
    }

    public WrapperType(Class type) {
        this(type.getName());
    }
}

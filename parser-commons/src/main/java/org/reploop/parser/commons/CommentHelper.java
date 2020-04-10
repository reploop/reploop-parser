package org.reploop.parser.commons;

import com.google.common.collect.ImmutableList;
import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-10-25 10
 */
public class CommentHelper {
    private static final Logger LOG = LoggerFactory.getLogger(CommentHelper.class);

    public static List<String> comments(Token token, Integer channel,
                                        BiFunction<Token, Integer, List<Token>> supplier) {
        if (null == token || null == channel || null == supplier) {
            return Collections.emptyList();
        }
        List<Token> channels = supplier.apply(token, channel);
        ImmutableList.Builder<String> sb = ImmutableList.builder();
        if (null != channels) {
            channels.forEach(comment -> sb.add(comment.getText()));
        }
        return sb.build();
    }

}

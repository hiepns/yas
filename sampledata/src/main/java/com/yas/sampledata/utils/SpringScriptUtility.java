package com.yas.sampledata.utils;

import java.sql.Connection;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

public class SpringScriptUtility {
    public static void runScript(String path, Connection connection) {
        boolean continueOrError = false;
        boolean ignoreFailedDrops = false;
        String commentPrefix = "--";
        String separator = ";";
        String blockCommentStartDelimiter = "/*";
        String blockCommentEndDelimiter = "*/";

        ScriptUtils.executeSqlScript(
            connection,
            new EncodedResource(new PathResource(path)),
            continueOrError,
            ignoreFailedDrops,
            commentPrefix,
            separator,
            blockCommentStartDelimiter,
            blockCommentEndDelimiter
        );
    }
}

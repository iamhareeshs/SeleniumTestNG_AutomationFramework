package com.basic.utils;

import com.basic.constants.CommonPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ObjectReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectReader.class);

    public static Properties getObjectRepository(String fileName){
        Properties properties = new Properties();
        try {
            File repoPath = new File(CommonPaths.PROPERTIES_PATH + fileName + ".properties");
            FileReader fileReader = new FileReader(repoPath.getAbsolutePath());
            properties.load(fileReader);
            fileReader.close();

        }catch (Exception e){
            LOGGER.error(e.toString());
        }
        return properties;
    }
}

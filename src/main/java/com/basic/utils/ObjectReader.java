package com.basic.utils;

import com.basic.constants.CommonPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ObjectReader {
    private static final Logger LOGGER = LogManager.getLogger(ObjectReader.class);

    public static Properties getObjectRepository(String fileName){
        Properties properties = new Properties();
        try {
            File repoPath = new File(CommonPaths.PROPERTIES_PATH + fileName + ".properties");
            FileReader fileReader = new FileReader(repoPath.getAbsolutePath());
            properties.load(fileReader);
            fileReader.close();

        }catch (Exception e){
            LOGGER.error(e);
        }
        return properties;
    }
}

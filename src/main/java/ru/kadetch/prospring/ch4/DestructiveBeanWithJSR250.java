package ru.kadetch.prospring.ch4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithJSR250 {
    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception{
        System.out.println("Initializing Bean with JSR250");

        if (filePath == null) {
            throw new IllegalArgumentException("You must "
                    + "specify the filePath property of "
                    + DestructiveBeanWithJSR250.class);
        }
        this.file = new File(filePath);
        file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying Bean with JSR250");

        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }

        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

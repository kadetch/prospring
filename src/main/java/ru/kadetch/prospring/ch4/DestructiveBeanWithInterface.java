package ru.kadetch.prospring.ch4;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.File;

public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean {

    private File file;
    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean with interface");

        if (filePath == null) {
            throw new IllegalArgumentException("You must "
                    + "specify the filePath property of "
                    + DestructiveBean.class);
        }
        this.file = new File(filePath);
        file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying Bean with interface");

        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }

        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

}

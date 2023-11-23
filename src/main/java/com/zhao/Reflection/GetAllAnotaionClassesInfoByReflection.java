package com.zhao.Reflection;


import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Enumeration;


/**
 * @description 通过反射获取所有标有指定注解类的信息(通义千问Generate)
 * @version 1.0.0
 * @author 通义千问
 * @date 2023/11/24
 */
public class GetAllAnotaionClassesInfoByReflection {

    public static void main(String[] args) throws IOException {
        // 获取当前类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        // 获取所有可用的类
        Enumeration<URL> resources = classLoader.getResources("");

        while(resources.hasMoreElements()) {
            URL resource = resources.nextElement();

            String directoryPath = resource.getFile().replace("%20", " ");

            File directory = new File(directoryPath);

            if(directory.exists()) {
                searchAnnotationsInDirectory(directory, MyAnnotation.class);
            } else {
                System.err.println("Can't access to the path: " + directoryPath);
            }
        }
    }

    private static void searchAnnotationsInDirectory(File directory, Class<? extends Annotation> annotationClass) {
        File[] files = directory.listFiles();

        if(files != null && files.length > 0) {
            for (File file : files) {
                if(file.isDirectory()) {
                    searchAnnotationsInDirectory(file, annotationClass);
                } else {
                    try {
                        Class<?> clazz = Class.forName(getClassNameFromFile(file));

                        if(clazz.isAnnotationPresent(annotationClass)) {
                            System.out.println("Found class with the annotation: " + clazz.getName());
                        }
                    } catch (ClassNotFoundException e) {
                        System.err.println("Can't load the class: " + getClassNameFromFile(file));
                    }
                }
            }
        }
    }

    private static String getClassNameFromFile(File file) {
        return file.getPath()
                .replace("", "")
                .replace("/", ".")
                .replace("\\", ".")
                .replace(".class", "");
    }
}

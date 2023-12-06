package com.zhao.springboot.util;

import com.google.common.base.CaseFormat;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.MapWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

import java.util.Map;

public class CustomMapWrapperFactory implements ObjectWrapperFactory {
    @Override
    public boolean hasWrapperFor(Object object) {
        return object != null && object instanceof Map;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        return new CustomMapWrapper(metaObject,(Map)object);
    }

    class CustomMapWrapper extends MapWrapper {
        public CustomMapWrapper(MetaObject metaObject, Map<String, Object> map) {
            super(metaObject, map);
        }
        @Override
        public String findProperty(String name, boolean useCamelCaseMapping) {
            if(useCamelCaseMapping && name!=null && name.contains("_")){
                return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,name);
            }
            return name;
        }
    }
}

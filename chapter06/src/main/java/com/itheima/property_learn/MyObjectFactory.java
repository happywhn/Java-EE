package com.itheima.property_learn;

import com.mysql.cj.xdevapi.Collection;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

public class MyObjectFactory extends DefaultObjectFactory {
    private static final long serialVersionUID = -4114845625429965832L;
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }
}

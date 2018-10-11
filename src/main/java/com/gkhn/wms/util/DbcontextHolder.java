package com.gkhn.wms.util;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 数据源切�?
 * @datatime  2018�?2�?1日上�?9:54:27
 */
public class DbcontextHolder extends AbstractRoutingDataSource {

    public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置当前数据�?
     * @param dbType
     */
    public static void setDbType(String dbType){
        contextHolder.set(dbType);
    }
    /**
     * 获得当前数据�?
     * @return
     */
    public static String getDbType(){
        String dbType = (String)contextHolder.get();
        return dbType;
    }
    /**
     *清除上下�?
     *
     */
    public void clearContext(){
        contextHolder.remove();
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return DbcontextHolder.getDbType();
    }
}



 
//package com.rbx.util;
//
//import java.util.List;
//
///**
// * @author rbx
// * @title
// * @Create 2023-04-26 9:33
// * @Description  德水-国家电网-sql框架
// */
//public class test extends MultipleMethodJavaParse {
//    @Override
//    public void defaultMethod(BackEndDataBean arg0, IconfigData arg1, ResponseResult arg2, QueryBean arg3, IBaseDao arg4, IBaseDao arg5) {
//
//    }
//
//    public void query(BackEndDataBean arg0, IconfigData arg1, ResponseResult res, QueryBean bean, IBaseDao baseDao, IBaseDao arg5) {
//        //使用getArgValue方法获取前端请求参数
//        String keyword = bean.getArgValue("keyword");
//
//        //自定义SQL语句
//        String sql = "SELEDCT batch_id,create_user,id,name,price,status FROM pf_help_test_data where 1=1";
//
//        //定义SQL查询参数数组
//        Object[] obs = null;
//
//        //定义模糊查询SQL，根据用户传递的业务数据进行查询
//        String wh = "ADN (name LIKE ? OR price LIKE ? OR create_user LIKE ?)";
//
//        //拼接模糊查询条件字段
//        String arg = "%" + keyword + "%";
//
//        //如果请求参数不为null也不为空，则处理请求参数
//        if(keyword!=null && !keyword.isEmpty()) {
//            //因为有三个占位符，且都是根据一个关键字查询多个属性，所以数组大小为3且值相同
//            obs = new Object[3];
//            obs[0] = arg;
//            obs[1] = arg;
//            obs[2] = arg;
//        }
//
//        //设置返回值类型
//        res.setFormatType(FormatType.LIST);
//
//        //查询数据总行数SQL，分页方法需要用到总行数
//        String countSql = "SELECT COUNT(*) FROM pf_help_test_data where 1=1";
//
//        //获取分页起始行数，分页方法需要用到
//        int start = bean.getExtParams().getStartInt();
//        //获取分页每次查询的行数，分页方法需要用到
//        int limit = bean.getExtParams().getLimitInt();
//
//        //执行SQL，分别传入SQL语句及参数，并接收结果
//        List list = baseDao.executeSqlQuery(sql+wh, start, limit);
//
//        //获取符合条件的总行数，分页需要使用该参数
//        int ct = baseDao.findForCount(countSql+wh,obs);
//
//        //设置响应给前端的关键字模糊搜索结果
//        res.setListData(list);
//
//        //设置符合条件的分页总数
//        res.setNumbetData(ct);
//    }
//
//    //返回数据库类型的字符串表示形式
//    checkDatabaseType() : String - BaseDao
//
//        //=====存储过程=====
//        //执行指定的存储过程（参数s），并返回Map集合对象。
//    executeProcedure(String s) : Map - IBaseDao
//        //执行指定的存储过程（参数s）并传入参数list，返回值为boolean类型。
//    executeProcedure(String s, List list) : boolean - IBaseDao
//        //执行指定的存储过程（参数s）并传入两个Map类型的参数map和map1，返回值为Map集合对象。
//    executeProcedure(String s, Map map, Map map1) : Map - IBaseDao
//
//        //=====查询操作=====
//        //执行查询操作，查询条件由参数queryconfigbean指定，返回List集合对象
//    executeSqlQuery(QueryConfigBean queryconfigbean) : List - IBaseDao
//        //执行指定的SQL语句（参数s），返回List集合对象。
//    executeSqlQuery(String s) : List - IBaseDao
//        //执行指定的SQL语句并传入参数aobj，返回List集合对象。
//    executeSqlQuery (String s, Object[] aobj) : List - IBaseDao
//        //执行指定的SQL语句并传入分页参数（参数i和j），返回List集合对象。
//    executeSqlQuery(String s, int i, int j) : List - IBaseDao
//        //执行指定的SQL语句并传入参数aobj和标志参数flag，返回List集合对象。
//    executeSqlQuery(String s, Object[] aobj, boolean flag) : List - IBaseDao
//        //执行指定的 SQL 查询语句，传入查询参数 aobj 和查询选项 map，返回查询结果List
//    executeSqlQuery(String s, Object[] aobj, Map<String, String> map) : List - IBaseDao
//        //执行指定的 SQL 查询语句，传入查询参数 aobj 和分页参数 i、j，返回查询结果List️带条件的分页查询常用
//    executeSqlQuery(String s, Object[] aobj, int i, int j) : List - IBaseDao
//        //执行查询操作，返回结果为一个二维 List，其中每一行为一个 List，表示一条记录，其中的每个元素为该记录的字段值（字符串类型）。
//    executeSqlQuery4List(QueryConfigBean queryconfigbean) : List<List<String>> - IBaseDao
//        //执行指定的 SQL 查询语句，传入查询参数 aobj，返回结果 List，其中每个元素为一条记录的字符串表示形式。
//    executeSqlQuery4List(String s, Object[] aobj) : List - IBaseDao
//        //执行查询操作，返回结果为一个 Map 集合，其中的每个元素都是一个键值对，键为字符串类型的字段名，值为该字段对应的所有记录值（List<String>类型）。
//    executeSqlQuery4MapList(QueryConfigBean queryconfigbean) : Map<String,List<String>> - IBaseDao
//        //执行指定的 SQL 查询语句，传入查询参数 aobj，返回结果 Map，其中的每个元素都是一个键值对，键为字符串类型的字段名，值为该字段对应的所有记录值（List类型）。
//    executeSqlQuery4MapList(String s, Object[] aobj) : Map - IBaseDao
//        //执行查询操作，返回结果为一个 List，其中每个元素为一条记录的字符串表示形式。并且会对返回结果进行脱敏处理。
//    executeSqlQueryDesensitization(QueryConfigBean queryconfigbean) : List - IBaseDao
//        //执行指定的 SQL 查询语句，传入查询参数 aobj，返回结果 List，其中每个元素为一条记录的字符串表示形式，并且会对返回结果进行脱敏处理。
//    executeSqlQueryDesensitization(String s, Object[] aobj) : List - IBaseDao
//        //执行指定的 SQL 查询语句，传入查询参数 aobj 和分页参数 i、j，返回结果 List，其中每个元素为一条记录的字符串表示形式，并且会对返回结果进行脱敏处理。
//    executeSqlQueryDesensitization(String s, Object[] aobj, int i, int j) : List - IBaseDao
//        //执行查询操作，返回结果为一个 List，其中每个元素为一条记录的字符串表示形式。并且会对返回结果中的空值进行转换（将null转成空字符串）。
//    executeSqlQueryHasE(QueryConfigBean queryconfigbean) : List - IBaseDao
//        //执行指定的 SQL 查询语句，传入查询参数 aobj 和分页参数 i、j，返回结果 List，其中每个元素为一条记录的字符串表示形式，并且会对返回结果中的空值进行转换。
//    executeSqlQueryHasE(String s, Object[] aobj, int i, int j) : List - IBaseDao
//
//        //=====更新操作=====
//        //执行多个 SQL 更新语句，传入一个 QueryConfigBean 类型的 List，每个对象包含一个 SQL 更新语句和对应的参数值，返回一个整型数组，其中每个元素表示对应 SQL 语句更新的行数。
//    executeSqlUpdate(List<QueryConfigBean> list) : int[] - IBaseDao
//        //执行指定的 SQL 更新语句，返回一个整数表示更新的行数。
//    executeSqlUpdate(String s) : int - IBaseDao
//        //执行带有占位符的 SQL 更新语句，传入占位符对应的参数值，返回一个整数表示更新的行数。
//    executeSqlUpdate(String s, Object[] aobj) : int - IBaseDao
//        //批量执行指定的 SQL 更新语句，传入一个二维 List，其中每个元素为一个数组，表示一个 SQL 更新语句对应的参数值，返回一个整型数组，其中每个元素表示对应 SQL 语句更新的行数。
//    executeSqlUpdateBatch(String s, List<Object[]> list) : int[] - IBaseDao
//
//        //=====其他操作=====
//        //执行查询语句并返回结果行数。
//    findForCount(String s) : int - IBaseDao
//        //执行带占位符的查询语句并返回结果行数。
//    findForCount(String s, Object] aobj) : int - IBaseDao
//        //获取当前数据源
//    getDataSource() : DataSource - IBaseDao
//        //获取查询结果最大行数限制。
//    getMaxResults() : int - IBaseDao
//        //根据传入的 SQL 查询字典项，并将结果放入Map中返回。
//    queryDicWithPre (String s, Object aobj) : Map - IBaseDao
//        //执行指定的 SQL 语句，没有返回值。
//    runSqlString(String s) : void - IBaseDao
//        //设置查询结果最大行数限制。
//    setMaxResults(int i) : void - IBaseDao
//    //常量，表示回滚事务的常量值。
//    ROLLBACK_FLAG : int - IBaseDao
//
//        //=====继承Object的方法=====
//    hashCode(): int - Object
//    notify() : void - Object
//    notifyAll() : void - Object
//    toString() : String - Object
//    wait(): void - Object
//    wait(long timeout) : void - Object
//    wait(long timeout, int nanos) : void - Object
//    getClass() : Class<?> - Object
//}
//
//

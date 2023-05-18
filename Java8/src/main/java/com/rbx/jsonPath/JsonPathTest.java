package com.rbx.jsonPath;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * @author rbx
 * @title
 * @Create 2023-05-16 13:35
 * @Description
 */
@Slf4j
public class JsonPathTest {

    final JSONObject jObject = JSON.parseObject("{\n" +
            "  \"store\": {\n" +
            "    \"book\":[\n" +
            "      { \"category\": \"reference\",\n" +
            "        \"author\": \"Nigel Rees\",\n" +
            "        \"title\": \"Sayings of the Century\",\n" +
            "        \"price\": 8.95\n" +
            "      },\n" +
            "      { \"category\": \"fiction\",\n" +
            "        \"author\": \"J. R. R. Tolkien\",\n" +
            "        \"title\": \"The Lord of the Rings\",\n" +
            "        \"isbn\": \"0-395-19395-8\",\n" +
            "        \"price\": 22.99\n" +
            "      }\n" +
            "    ],\n" +
            "    \"bicycle\": {\n" +
            "      \"color\": \"red\",\n" +
            "      \"price\": 19.95\n" +
            "    }\n" +
            "  }\n" +
            "}\n");


    @Test
    public void Test1(){
        log.info("jPath:{}", jObject);
        //查看store下的bicycle的color属性：
        Object eval = JSONPath.eval(jObject, "$.store.bicycle.color");
        log.info("eval:{} " , eval);

        //输出book节点中包含的所有对象：
        Object eval1 = JSONPath.eval(jObject, "$.store.book[*]");
        log.info("eval:{} " , eval1);

        //输出book节点的第一个对象：
        Object eval2 = JSONPath.eval(jObject, "$.store.book[0]");
        log.info("eval:{}",eval2);

        //输出book节点中所有对象对应的属性title值：
        Object eval3 = JSONPath.eval(jObject, "$.store.book[*].title");
        log.info("eval:{}",eval3);

        //输出book节点中category为fiction的所有对象：
        Object eval4 = JSONPath.eval(jObject, "$.store.book[?(@.category=='fiction')]");
        log.info("eval:{}",eval4);

        //输出book节点中所有价格小于10的对象：
        Object eval5 = JSONPath.eval(jObject, "$.store.book[?(@.price<10)]");
        log.info("eval:{}",eval5);

        //输出book节点中所有含有isbn的对象：
        Object eval6 = JSONPath.eval(jObject, "$.store.book[?(@.isbn)]");
        log.info("eval:{}",eval6);
    }

    @Test
    public void Test2(){
        int a = 10;
        int b = 20;
        /*
            语法格式一:
            assert [boolean 表达式]
               - 如果[boolean表达式]为true，则程序继续执行。
               - 如果为false，则程序抛出AssertionError，并终止执行。
         */
        //assert a>b;

        /*
            语法格式二:
            assert [boolean 表达式 : 错误表达式 （日志）]
                - 如果[boolean表达式]为true，则程序继续执行。
                - 如果为false，则程序抛出java.lang.AssertionError，输出[错误信息]。
         */
        //assert a>b:"错误a不大于b";

        Map root = Collections.singletonMap("company",
                Collections.singletonMap("departs",
                        Arrays.asList(Collections.singletonMap("id", 1001),
                                Collections.singletonMap("id", 1002),
                                Collections.singletonMap("id", 1003))));
        log.info("root:{}",root);
        /*
         * 1.assertEquals(expected,actual)  和 assertNotEquals(expected,actual);
         * 比较实际值与预期值是否一致。如果一致，程序继续运行，否则抛出异常，会打印报错信息。常用断言方法，便于调试。
         */
        Assert.assertEquals(1,root.size());
        log.info("rootSize:{}",root.size());
        Assert.assertNotEquals(3,root.size());
        log.info("rootSize:{}",root.size());


        /*
         * 2.assertTrue(message,condition) 和 assertFalse(message,condition)
         * 如果条件的真假与预期相同，程序继续运行，否则抛出异常，不会打印报错信息。
         */
        Assert.assertTrue("结果为false打印报错信息", root.size()==1);
        Assert.assertFalse("结果为true打印报错信息",root.size() == 0);

        /*
         * 3.assertNull(message,object) 和 assertNotNull(message,object)
         * 判断一个对象是否为空，如果结果与预期相同，程序继续运行，否则抛出异常。
         */
        //Assert.assertNull(root.size());
        Assert.assertNotNull("不为null会报错",root.size());

        /*
         * 4.assertSame(expected,actual) 和 assertNotSame(expected,actual)
         * 判断预期的值和实际的值是否为同一个参数(即判断是否为相同的引用)，如果结果与预期相同，程序继续运行，否则抛出异常。
         * assertSame(expected,actual) 和 assertEquals(expected,actual)的区别；
         * assertSame(A,B)  ————————————> A==B
         * assertEquals(A,B)————————————>A.equals(B)
         */
        //Assert.assertSame(new Object(),new Object());
        Assert.assertNotSame(new Object(),new Object());

        /*
         * 5.fail(message)
         * “fail”断言能使测试立即失败，这种断言通常用于标记某个不应该被到达的分支。例如测试中某个代码块要try  catch，则在catch代码中加入fail(message)方法，否则代码直接进入catch块，无法判断测试结果。
         */
        try {
            System.out.println(1/0);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }
}

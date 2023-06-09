package com.rbx.newFeatures.demo;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class LambdaDemo01 {

    public static void main(String[] args) {
        //创建无限流 迭代：Stream.iterate() 第一个参数为第一个元素大小，第二个参数为后一个元素在前一个元素已知条件下的生成规则
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 1);
        stream2.limit(5).forEach(System.out::print);
        System.out.println();

//        printNum2(value -> value % 2 == 0, value -> value>4);

//        foreachArr(value->System.out.println(value));
//
//        Integer result = typeConver(s->Integer.valueOf(s));
//        System.out.println(result);
//
//
//        printNum(value -> value%2==0);
//
//
//        int i = calculateNum((left, right) -> left + right);
//        System.out.println(i);
//
//        new Thread(() -> System.out.println("你知道吗 我比你想象的 更想在你身边")).start();
    }
    public static void foreachArr(IntConsumer consumer){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }




    public static <R> R typeConver(Function<String,R> function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }



    public static void printNum2(IntPredicate predicate,IntPredicate predicate2){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if(predicate.and(predicate2).test(i)){
                System.out.println(i);
            }
        }
    }

    public static void printNum(IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if(predicate.test(i)){
                System.out.println(i);
            }
        }
    }

    public static int calculateNum(IntBinaryOperator operator){
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
}

package com.jd.wjq;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * @author: wangjiaqi72
 * @date: 2019/12/18 13:58
 * @desc: 
 */
public class TestEquals {
    public static void main(String[] args) {
    }

    @Test
    public  void test1(){
        String str = null;
        if(str.equals("mystr")){

        }else{

        }
    }

    @Test
    public void test2(){
        String [] strings = {"wjq","cqx","zf","sjg"};
        List<String> stringList = Arrays.asList(strings);
        for (String s : stringList) {
            System.out.println(s);
        }
        strings[0] = "wjq2";

        for (String s : stringList) {
            System.out.println(s);
        }

        //不可以使用其他api
        stringList.add("yzy");  //java.lang.UnsupportedOperationException

        for (String s : stringList) {
            System.out.println(s);
        }


        //基本数据类型  数组 转换成 list 集合

        int [] ints = {1,2,3,4};
        List<int[]> list = Arrays.asList(ints); // 使用Alt + Enter 会提示添加变量  变量的泛型为  整个数组作为一个  非基本类型

        List list2 = Arrays.asList(ints);   //如果没有带泛型的 花  其他开发者会误认为这里面 装的是 基本数据类型的int 类型  但是 实际上里面  装的是一个一个的整型的数组  且 集合的大小是1

        System.out.println(list.get(4));  //这样  就会出现数组越界的错误

        list.add(new int[]{2, 3});  //java.lang.UnsupportedOperationException  无法 支持相关集合的操作




    }

    @Test
    public void test3(){
        int [] ints = {1,2,3,4};

        List<int[]> list = Arrays.asList(ints);

        System.out.println(list.getClass());                //class java.util.Arrays$ArrayList

        System.out.println(new ArrayList<>().getClass());  //class java.util.ArrayList


    }

    /**
     * @author: wangjiaqi72
     * @function: 测试 不要再forEach中 使用 集合的 add  remove 等方法
     * @modify: 2019/12/18 15:21
     */
    @Test
    public void test4(){
        List<Integer> list = new ArrayList();  //java.util.ConcurrentModificationException   并发修改异常
        list.add(1);
        list.add(2);
        list.add(3);
        for (Integer integer : list) {
            if(integer == 1){
                list.remove(integer);
            }
        }
    }


    /**
     * @author: wangjiaqi72
     * @function: 正确的迭代中删除元素的方式
     * @modify: 2019/12/18 15:25
     */
    @Test
    public void test5(){
        List<Integer> list = new ArrayList();  //java.util.ConcurrentModificationException   并发修改异常
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next() == 1){
                iterator.remove();
            }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test6(){
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        String str6 = str1 +"ing";
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
        System.out.println((str6 == str5)); //false



    }


    /**
     * @author: wangjiaqi72
     * @date: 2019/12/18 15:10
     * @desc: Java1.8可以使用stream
     */
//    @Test
//    public void test4(){
//        Integer [] myArray = { 1, 2, 3 };
//        List myList = Arrays.stream(myArray).collect(Collectors.toList());
//        //基本类型也可以实现转换（依赖boxed的装箱操作）
//        int [] myArray2 = { 1, 2, 3 };
//        List myList = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
//    }

    /**
     * @author: wangjiaqi72
     * @date: 2019/12/18 15:06
     * @desc: 将一个数组转换成一个ArrayList集合
     */
    private static <T> List<T> arrayToList(final T [] args){
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < args.length; i++) {
            list.add(args[i]);
        }
        return list;
    }





}

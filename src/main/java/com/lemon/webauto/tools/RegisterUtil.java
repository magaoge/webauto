package com.lemon.webauto.tools;

import com.lemon.webauto.pojo.RegisterData;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgg on 2021/9/27
 */

//获取列表中的指定行、列的数据
public class RegisterUtil {
//生成列表容器，存放excel表中的数据，因为我们是针对每张表存放一
// 个list，所以我们要创建对应的实体类RegisterData，来将表中的每行数据封装成对象存入列表中
    public static List<RegisterData> registerDatas = new ArrayList<RegisterData>();
    //初始化指定表格中的数据，存入列表registerDatas中
    static {
        List<RegisterData> list = ExcelUtil.load(ReadProperty.getExcelPath("excelPath"),"Sheet1",RegisterData.class);
        registerDatas.addAll(list);
        for (RegisterData data : registerDatas) {
            System.out.println(data.toString());
        }
    }

    //获取指定“反向”列，哪几列列值的用例的数据
    public static Object[][] getNegativeDatas(String flag,String[] cellName){
        //生成存放第一层筛选，筛选后数据的列表容器
        List<Object> satisfied = new ArrayList<Object>();
        for (RegisterData registerData : registerDatas) {
            if (registerData.getIsNegative().equals(flag)){
                satisfied.add(registerData);
            }
        }
        //获取RegisterData的反射对象，以备后面需要调用反射对象的方法
        Class clazz = RegisterData.class;
        //生成存放筛选出的行，所需列的二维数组
        Object[][] datas = BaseUtil.assembleDatas(satisfied,cellName,clazz);
        return datas;
    }



//    public static void main(String[] args) {
//        String[] cellName = {"IsNegative","Username","Password"};
//        Object[][] datas = RegisterUtil.getNegativeDatas("0",cellName);
//        for (Object[] data : datas) {
//            for (Object datum : data) {
//                System.out.println(datum.toString());
//            }
//            System.out.println("=====================");
//        }
//    }
}

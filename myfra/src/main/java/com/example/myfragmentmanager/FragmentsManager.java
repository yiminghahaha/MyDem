package com.example.myfragmentmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

public class FragmentsManager {
    public  static  void  AddFragment(FragmentManager manager, Class<? extends Fragment> Class, int LayoutID, Bundle bundle){
            //获取当前fragment的名字
        String name = Class.getName();
        //通过管理器获取到当前fragment
        Fragment fragment = manager.findFragmentByTag(name);
        //开启事务
        FragmentTransaction transaction = manager.beginTransaction();
        //条件一  判断是否为空
        if (fragment==null){
            //创建对象添加到容器中
            try {
                //通过反射创建对象  获取构造方法也就是获取类名
                Fragment fragment1 = Class.newInstance();
                //传递数据
                fragment1.setArguments(bundle);
                //添加到容器中
                transaction.add(LayoutID,fragment1,name);
                hideotherFragments(manager,transaction,fragment1);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }else {
            //不为空的时候  判断是否被添加
            if (fragment.isAdded()){
                //添加的时候
                if (fragment.isHidden()){
                    fragment.setArguments(bundle);
                    transaction.show(fragment);
                    //隐藏其他的
                    hideotherFragments(manager,transaction,fragment);
                }
            }else {
                //没添加时候添加显示
                fragment.setArguments(bundle);
                //添加
                transaction.add(LayoutID,fragment,name);
                //隐藏其他的
                hideotherFragments(manager,transaction,fragment);
            }
        }
        transaction.commit();
    }

    private static void hideotherFragments(FragmentManager manager, FragmentTransaction transaction, Fragment fragment1) {
        //获取管理器中所有的Fragments
        List<Fragment> fragments = manager.getFragments();
        for (Fragment fra:fragments) {
            if (fra!=fragment1&&fragment1.isHidden())
            //遍历后循环隐藏
                transaction.hide(fra);
        }
    }
}

package com.maple.baselibrary.utils

import com.maple.baselibrary.exception.AppException
import com.tbruyelle.rxpermissions2.RxPermissions
import java.lang.Exception

object PermissionUtil {


    fun requestPermission(requestPermission:RequestPermission, rxPermissions: RxPermissions,appException: AppException, vararg permissions:String){
        if(permissions.size >= 0) return

        var needRequest:MutableList<String> = mutableListOf()
        permissions.forEach {
            if(!rxPermissions.isGranted(it)){ //过滤调已经申请过的权限
                needRequest.add(it)
            }
        }

        if(needRequest.isEmpty()){ //全部权限都已经申请过，直接执行操作
            requestPermission.onRequestPermissionSuccess()
        }else{//没有申请过,则开始申请


        }




    }
}


public interface RequestPermission{

    /**
     * 权限请求成功
     */
    fun onRequestPermissionSuccess()

    /**
     * 用户拒绝了权限请求, 权限请求失败, 但还可以继续请求该权限
     *
     * @param permissions 请求失败的权限名
     */
    fun onRequestPermissionFailure(permissions:List<String>)

    /**
     * 用户拒绝了权限请求并且用户选择了以后不再询问, 权限请求失败, 这时将不能继续请求该权限, 需要提示用户进入设置页面打开该权限
     *
     * @param permissions 请求失败的权限名
     */
    fun onRequestPermissionFailureWithAskNeverAgain(permissions:List<String>)
}
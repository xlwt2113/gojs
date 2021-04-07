package com.ruoyi.device.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/device/topology2")
public class TopologyController {

    private String prefix = "device/topology";

    @Autowired
    private ISysDictDataService sysDictDataService;

    /**
     * 打开拓扑编辑页面
     * @return
     */
    @RequiresPermissions("device:topology:edit")
    @GetMapping()
    public String event()
    {
        return prefix + "/edit2";
    }

    /**
     * 获取设备字典项
     * @return
     */
    @GetMapping("/getDeviceTypes")
    @ResponseBody
    public AjaxResult getDeviceTypes(){
        SysDictData param = new SysDictData();
        param.setDictType("device_info_type");
        param.setStatus("0");
        List<SysDictData> list = sysDictDataService.selectDictDataList(param);
        return AjaxResult.success(list);
    }
}

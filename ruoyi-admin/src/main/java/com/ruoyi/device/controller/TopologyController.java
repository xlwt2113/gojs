package com.ruoyi.device.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device/topology")
public class TopologyController {

    private String prefix = "device/topology";

    /**
     * 打开拓扑编辑页面
     * @return
     */
    @RequiresPermissions("device:topology:edit")
    @GetMapping()
    public String event()
    {
        return prefix + "/edit";
    }
}

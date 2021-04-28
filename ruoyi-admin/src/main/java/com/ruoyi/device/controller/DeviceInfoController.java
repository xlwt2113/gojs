package com.ruoyi.device.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.device.domain.DeviceStatus;
import com.ruoyi.device.service.IDeviceStatusService;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.device.domain.DeviceInfo;
import com.ruoyi.device.service.IDeviceInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备台账信息Controller
 *
 * @author 王涛
 * @date 2021-04-27
 */
@Controller
@RequestMapping("/device/info")
public class DeviceInfoController extends BaseController
{
    private String prefix = "device/info";

    @Autowired
    private IDeviceInfoService deviceInfoService;

    @Autowired
    private IDeviceStatusService deviceStatusService;

    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("device:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    @RequiresPermissions("device:info:view")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        // 获取设备信息
        DeviceInfo deviceInfo = deviceInfoService.selectDeviceInfoById(id);
        // 获取状态信息
        DeviceStatus param = new DeviceStatus();
        param.setDeviceId(id);
        List<DeviceStatus> list = deviceStatusService.selectDeviceStatusList(param);
        if(!list.isEmpty()){
            mmap.put("deviceStatus",list.get(0));
        }else{
            mmap.put("deviceStatus",new DeviceStatus());
        }
        // 获取部门层级
        String[] deptIds = deviceInfo.getDept().getAncestors().split(",");
        String deptName = "";
        for(String deptId: deptIds){
            if(Long.parseLong(deptId)!=0){
                SysDept dept = deptService.selectDeptById(Long.parseLong(deptId));
                deptName = deptName + dept.getDeptName() + " - ";
            }
        }
        deviceInfo.getDept().setDeptName(deptName + deviceInfo.getDept().getDeptName());
        mmap.put("deviceInfo", deviceInfo);
        return prefix + "/view";
    }

    /**
     * 查询设备台账信息列表
     */
    @RequiresPermissions("device:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DeviceInfo deviceInfo)
    {
        startPage();
        List<DeviceInfo> list = deviceInfoService.selectDeviceInfoList(deviceInfo);
        return getDataTable(list);
    }

    /**
     * 导出设备台账信息列表
     */
    @RequiresPermissions("device:info:export")
    @Log(title = "设备台账信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DeviceInfo deviceInfo)
    {
        List<DeviceInfo> list = deviceInfoService.selectDeviceInfoList(deviceInfo);
        ExcelUtil<DeviceInfo> util = new ExcelUtil<DeviceInfo>(DeviceInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增设备台账信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备台账信息
     */
    @RequiresPermissions("device:info:add")
    @Log(title = "设备台账信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DeviceInfo deviceInfo)
    {
        return toAjax(deviceInfoService.insertDeviceInfo(deviceInfo));
    }

    /**
     * 修改设备台账信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DeviceInfo deviceInfo = deviceInfoService.selectDeviceInfoById(id);
        mmap.put("deviceInfo", deviceInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备台账信息
     */
    @RequiresPermissions("device:info:edit")
    @Log(title = "设备台账信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DeviceInfo deviceInfo)
    {
        return toAjax(deviceInfoService.updateDeviceInfo(deviceInfo));
    }

    /**
     * 删除设备台账信息
     */
    @RequiresPermissions("device:info:remove")
    @Log(title = "设备台账信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(deviceInfoService.deleteDeviceInfoByIds(ids));
    }
}

package com.ruoyi.device.controller;

import java.util.List;
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
import com.ruoyi.device.domain.DeviceStatus;
import com.ruoyi.device.service.IDeviceStatusService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备状态表Controller
 * 
 * @author 王涛
 * @date 2021-04-27
 */
@Controller
@RequestMapping("/device/status")
public class DeviceStatusController extends BaseController
{
    private String prefix = "device/status";

    @Autowired
    private IDeviceStatusService deviceStatusService;

    @RequiresPermissions("device:status:view")
    @GetMapping()
    public String status()
    {
        return prefix + "/status";
    }

    /**
     * 查询设备状态表列表
     */
    @RequiresPermissions("device:status:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DeviceStatus deviceStatus)
    {
        startPage();
        List<DeviceStatus> list = deviceStatusService.selectDeviceStatusList(deviceStatus);
        return getDataTable(list);
    }

    /**
     * 导出设备状态表列表
     */
    @RequiresPermissions("device:status:export")
    @Log(title = "设备状态表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DeviceStatus deviceStatus)
    {
        List<DeviceStatus> list = deviceStatusService.selectDeviceStatusList(deviceStatus);
        ExcelUtil<DeviceStatus> util = new ExcelUtil<DeviceStatus>(DeviceStatus.class);
        return util.exportExcel(list, "status");
    }

    /**
     * 新增设备状态表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备状态表
     */
    @RequiresPermissions("device:status:add")
    @Log(title = "设备状态表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DeviceStatus deviceStatus)
    {
        return toAjax(deviceStatusService.insertDeviceStatus(deviceStatus));
    }

    /**
     * 修改设备状态表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DeviceStatus deviceStatus = deviceStatusService.selectDeviceStatusById(id);
        mmap.put("deviceStatus", deviceStatus);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备状态表
     */
    @RequiresPermissions("device:status:edit")
    @Log(title = "设备状态表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DeviceStatus deviceStatus)
    {
        return toAjax(deviceStatusService.updateDeviceStatus(deviceStatus));
    }

    /**
     * 删除设备状态表
     */
    @RequiresPermissions("device:status:remove")
    @Log(title = "设备状态表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(deviceStatusService.deleteDeviceStatusByIds(ids));
    }
}

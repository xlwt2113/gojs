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
import com.ruoyi.device.domain.DeviceEvent;
import com.ruoyi.device.service.IDeviceEventService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备事件表Controller
 * 
 * @author 王涛
 * @date 2021-04-03
 */
@Controller
@RequestMapping("/device/event")
public class DeviceEventController extends BaseController
{
    private String prefix = "device/event";

    @Autowired
    private IDeviceEventService deviceEventService;

    @RequiresPermissions("device:event:view")
    @GetMapping()
    public String event()
    {
        return prefix + "/event";
    }

    /**
     * 查询设备事件表列表
     */
    @RequiresPermissions("device:event:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DeviceEvent deviceEvent)
    {
        startPage();
        List<DeviceEvent> list = deviceEventService.selectDeviceEventList(deviceEvent);
        return getDataTable(list);
    }

    /**
     * 导出设备事件表列表
     */
    @RequiresPermissions("device:event:export")
    @Log(title = "设备事件表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DeviceEvent deviceEvent)
    {
        List<DeviceEvent> list = deviceEventService.selectDeviceEventList(deviceEvent);
        ExcelUtil<DeviceEvent> util = new ExcelUtil<DeviceEvent>(DeviceEvent.class);
        return util.exportExcel(list, "event");
    }

    /**
     * 新增设备事件表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备事件表
     */
    @RequiresPermissions("device:event:add")
    @Log(title = "设备事件表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DeviceEvent deviceEvent)
    {
        return toAjax(deviceEventService.insertDeviceEvent(deviceEvent));
    }

    /**
     * 修改设备事件表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DeviceEvent deviceEvent = deviceEventService.selectDeviceEventById(id);
        mmap.put("deviceEvent", deviceEvent);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备事件表
     */
    @RequiresPermissions("device:event:edit")
    @Log(title = "设备事件表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DeviceEvent deviceEvent)
    {
        return toAjax(deviceEventService.updateDeviceEvent(deviceEvent));
    }

    /**
     * 删除设备事件表
     */
    @RequiresPermissions("device:event:remove")
    @Log(title = "设备事件表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(deviceEventService.deleteDeviceEventByIds(ids));
    }
}

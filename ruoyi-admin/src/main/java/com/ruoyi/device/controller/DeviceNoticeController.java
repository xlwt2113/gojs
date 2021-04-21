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
import com.ruoyi.device.domain.DeviceNotice;
import com.ruoyi.device.service.IDeviceNoticeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备信息通知Controller
 * 
 * @author 王涛
 * @date 2021-04-21
 */
@Controller
@RequestMapping("/device/notice")
public class DeviceNoticeController extends BaseController
{
    private String prefix = "device/notice";

    @Autowired
    private IDeviceNoticeService deviceNoticeService;

    @RequiresPermissions("device:notice:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/notice";
    }

    /**
     * 查询设备信息通知列表
     */
    @RequiresPermissions("device:notice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DeviceNotice deviceNotice)
    {
        startPage();
        List<DeviceNotice> list = deviceNoticeService.selectDeviceNoticeList(deviceNotice);
        return getDataTable(list);
    }

    /**
     * 导出设备信息通知列表
     */
    @RequiresPermissions("device:notice:export")
    @Log(title = "设备信息通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DeviceNotice deviceNotice)
    {
        List<DeviceNotice> list = deviceNoticeService.selectDeviceNoticeList(deviceNotice);
        ExcelUtil<DeviceNotice> util = new ExcelUtil<DeviceNotice>(DeviceNotice.class);
        return util.exportExcel(list, "notice");
    }

    /**
     * 新增设备信息通知
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备信息通知
     */
    @RequiresPermissions("device:notice:add")
    @Log(title = "设备信息通知", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DeviceNotice deviceNotice)
    {
        return toAjax(deviceNoticeService.insertDeviceNotice(deviceNotice));
    }

    /**
     * 修改设备信息通知
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DeviceNotice deviceNotice = deviceNoticeService.selectDeviceNoticeById(id);
        mmap.put("deviceNotice", deviceNotice);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备信息通知
     */
    @RequiresPermissions("device:notice:edit")
    @Log(title = "设备信息通知", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DeviceNotice deviceNotice)
    {
        return toAjax(deviceNoticeService.updateDeviceNotice(deviceNotice));
    }

    /**
     * 删除设备信息通知
     */
    @RequiresPermissions("device:notice:remove")
    @Log(title = "设备信息通知", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(deviceNoticeService.deleteDeviceNoticeByIds(ids));
    }
}

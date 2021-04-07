package com.ruoyi.device.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.device.domain.DeviceTopology;
import com.ruoyi.device.service.IDeviceTopologyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 拓扑图维护Controller
 *
 * @author 王涛
 * @date 2021-04-06
 */
@Controller
@RequestMapping("/device/topology")
public class DeviceTopologyController extends BaseController
{
    private String prefix = "device/topology";

    @Autowired
    private IDeviceTopologyService deviceTopologyService;

    @RequiresPermissions("device:topology:view")
    @GetMapping()
    public String topology()
    {
        return prefix + "/topology";
    }

    /**
     * 查询拓扑图维护列表
     */
    @RequiresPermissions("device:topology:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DeviceTopology deviceTopology)
    {
        startPage();
        List<DeviceTopology> list = deviceTopologyService.selectDeviceTopologyList(deviceTopology);
        return getDataTable(list);
    }

    /**
     * 导出拓扑图维护列表
     */
    @RequiresPermissions("device:topology:export")
    @Log(title = "拓扑图维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DeviceTopology deviceTopology)
    {
        List<DeviceTopology> list = deviceTopologyService.selectDeviceTopologyList(deviceTopology);
        ExcelUtil<DeviceTopology> util = new ExcelUtil<DeviceTopology>(DeviceTopology.class);
        return util.exportExcel(list, "topology");
    }

    /**
     * 新增拓扑图维护
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存拓扑图维护
     */
    @RequiresPermissions("device:topology:add")
    @Log(title = "拓扑图维护", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DeviceTopology deviceTopology)
    {
        deviceTopology.setImageData("{ \"class\": \"GraphLinksModel\",\n" +
                "  \"linkFromPortIdProperty\": \"fromPort\",\n" +
                "  \"linkToPortIdProperty\": \"toPort\",\n" +
                "  \"nodeDataArray\": [],\n" +
                "  \"linkDataArray\": []}");
        return toAjax(deviceTopologyService.insertDeviceTopology(deviceTopology));
    }

    /**
     * 修改拓扑图维护
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DeviceTopology deviceTopology = deviceTopologyService.selectDeviceTopologyById(id);
        mmap.put("deviceTopology", deviceTopology);
        return prefix + "/edit";
    }

    /**
     * 修改保存拓扑图维护
     */
    @RequiresPermissions("device:topology:edit")
    @Log(title = "拓扑图维护", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DeviceTopology deviceTopology)
    {
        return toAjax(deviceTopologyService.updateDeviceTopology(deviceTopology));
    }

    /**
     * 删除拓扑图维护
     */
    @RequiresPermissions("device:topology:remove")
    @Log(title = "拓扑图维护", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(deviceTopologyService.deleteDeviceTopologyByIds(ids));
    }


    /**
     * 打开拓扑维护界面
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/design/{id}")
    public String design(@PathVariable("id") Long id, ModelMap mmap)
    {
        DeviceTopology deviceTopology = deviceTopologyService.selectDeviceTopologyById(id);
        mmap.put("deviceTopology", deviceTopology);
        return prefix + "/design";
    }

    /**
     * 保存拓扑数据
     * @param imageJson
     * @param id
     * @return
     */
    @RequiresPermissions("device:topology:edit")
    @Log(title = "拓扑图维护", businessType = BusinessType.UPDATE)
    @PostMapping("/saveImageJson")
    @ResponseBody
    public AjaxResult saveImageJson(@RequestParam("imageJson") String imageJson,@RequestParam("id") Long id){
        DeviceTopology deviceTopology = deviceTopologyService.selectDeviceTopologyById(id);
        deviceTopology.setImageData(imageJson);
        return toAjax(this.deviceTopologyService.updateDeviceTopology(deviceTopology));
    }

}

package com.ruoyi.device.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.device.mapper.DeviceStatusMapper;
import com.ruoyi.device.domain.DeviceStatus;
import com.ruoyi.device.service.IDeviceStatusService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备状态表Service业务层处理
 * 
 * @author 王涛
 * @date 2021-04-03
 */
@Service
public class DeviceStatusServiceImpl implements IDeviceStatusService 
{
    @Autowired
    private DeviceStatusMapper deviceStatusMapper;

    /**
     * 查询设备状态表
     * 
     * @param id 设备状态表ID
     * @return 设备状态表
     */
    @Override
    public DeviceStatus selectDeviceStatusById(Long id)
    {
        return deviceStatusMapper.selectDeviceStatusById(id);
    }

    /**
     * 查询设备状态表列表
     * 
     * @param deviceStatus 设备状态表
     * @return 设备状态表
     */
    @Override
    public List<DeviceStatus> selectDeviceStatusList(DeviceStatus deviceStatus)
    {
        return deviceStatusMapper.selectDeviceStatusList(deviceStatus);
    }

    /**
     * 新增设备状态表
     * 
     * @param deviceStatus 设备状态表
     * @return 结果
     */
    @Override
    public int insertDeviceStatus(DeviceStatus deviceStatus)
    {
        return deviceStatusMapper.insertDeviceStatus(deviceStatus);
    }

    /**
     * 修改设备状态表
     * 
     * @param deviceStatus 设备状态表
     * @return 结果
     */
    @Override
    public int updateDeviceStatus(DeviceStatus deviceStatus)
    {
        deviceStatus.setUpdateTime(DateUtils.getNowDate());
        return deviceStatusMapper.updateDeviceStatus(deviceStatus);
    }

    /**
     * 删除设备状态表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDeviceStatusByIds(String ids)
    {
        return deviceStatusMapper.deleteDeviceStatusByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备状态表信息
     * 
     * @param id 设备状态表ID
     * @return 结果
     */
    @Override
    public int deleteDeviceStatusById(Long id)
    {
        return deviceStatusMapper.deleteDeviceStatusById(id);
    }
}

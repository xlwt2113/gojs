package com.ruoyi.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.device.mapper.DeviceEventMapper;
import com.ruoyi.device.domain.DeviceEvent;
import com.ruoyi.device.service.IDeviceEventService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备事件表Service业务层处理
 * 
 * @author 王涛
 * @date 2021-04-03
 */
@Service
public class DeviceEventServiceImpl implements IDeviceEventService 
{
    @Autowired
    private DeviceEventMapper deviceEventMapper;

    /**
     * 查询设备事件表
     * 
     * @param id 设备事件表ID
     * @return 设备事件表
     */
    @Override
    public DeviceEvent selectDeviceEventById(Long id)
    {
        return deviceEventMapper.selectDeviceEventById(id);
    }

    /**
     * 查询设备事件表列表
     * 
     * @param deviceEvent 设备事件表
     * @return 设备事件表
     */
    @Override
    public List<DeviceEvent> selectDeviceEventList(DeviceEvent deviceEvent)
    {
        return deviceEventMapper.selectDeviceEventList(deviceEvent);
    }

    /**
     * 新增设备事件表
     * 
     * @param deviceEvent 设备事件表
     * @return 结果
     */
    @Override
    public int insertDeviceEvent(DeviceEvent deviceEvent)
    {
        return deviceEventMapper.insertDeviceEvent(deviceEvent);
    }

    /**
     * 修改设备事件表
     * 
     * @param deviceEvent 设备事件表
     * @return 结果
     */
    @Override
    public int updateDeviceEvent(DeviceEvent deviceEvent)
    {
        return deviceEventMapper.updateDeviceEvent(deviceEvent);
    }

    /**
     * 删除设备事件表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDeviceEventByIds(String ids)
    {
        return deviceEventMapper.deleteDeviceEventByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备事件表信息
     * 
     * @param id 设备事件表ID
     * @return 结果
     */
    @Override
    public int deleteDeviceEventById(Long id)
    {
        return deviceEventMapper.deleteDeviceEventById(id);
    }
}

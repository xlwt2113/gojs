package com.ruoyi.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.device.mapper.DeviceInfoMapper;
import com.ruoyi.device.domain.DeviceInfo;
import com.ruoyi.device.service.IDeviceInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备台账信息Service业务层处理
 *
 * @author 王涛
 * @date 2021-04-27
 */
@Service
public class DeviceInfoServiceImpl implements IDeviceInfoService
{
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    /**
     * 查询设备台账信息
     *
     * @param id 设备台账信息ID
     * @return 设备台账信息
     */
    @Override
    public DeviceInfo selectDeviceInfoById(Long id)
    {
        return deviceInfoMapper.selectDeviceInfoById(id);
    }

    /**
     * 查询设备台账信息列表
     *
     * @param deviceInfo 设备台账信息
     * @return 设备台账信息
     */
    @Override
    public List<DeviceInfo> selectDeviceInfoList(DeviceInfo deviceInfo)
    {
        return deviceInfoMapper.selectDeviceInfoList(deviceInfo);
    }

    /**
     * 新增设备台账信息
     *
     * @param deviceInfo 设备台账信息
     * @return 结果
     */
    @Override
    public int insertDeviceInfo(DeviceInfo deviceInfo)
    {
        return deviceInfoMapper.insertDeviceInfo(deviceInfo);
    }

    /**
     * 修改设备台账信息
     *
     * @param deviceInfo 设备台账信息
     * @return 结果
     */
    @Override
    public int updateDeviceInfo(DeviceInfo deviceInfo)
    {
        return deviceInfoMapper.updateDeviceInfo(deviceInfo);
    }

    /**
     * 删除设备台账信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDeviceInfoByIds(String ids)
    {
        return deviceInfoMapper.deleteDeviceInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备台账信息信息
     *
     * @param id 设备台账信息ID
     * @return 结果
     */
    @Override
    public int deleteDeviceInfoById(Long id)
    {
        return deviceInfoMapper.deleteDeviceInfoById(id);
    }
}

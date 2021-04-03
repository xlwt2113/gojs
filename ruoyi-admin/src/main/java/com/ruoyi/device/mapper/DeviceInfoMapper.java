package com.ruoyi.device.mapper;

import java.util.List;
import com.ruoyi.device.domain.DeviceInfo;

/**
 * 设备台账信息Mapper接口
 * 
 * @author 王涛
 * @date 2021-04-03
 */
public interface DeviceInfoMapper 
{
    /**
     * 查询设备台账信息
     * 
     * @param id 设备台账信息ID
     * @return 设备台账信息
     */
    public DeviceInfo selectDeviceInfoById(Integer id);

    /**
     * 查询设备台账信息列表
     * 
     * @param deviceInfo 设备台账信息
     * @return 设备台账信息集合
     */
    public List<DeviceInfo> selectDeviceInfoList(DeviceInfo deviceInfo);

    /**
     * 新增设备台账信息
     * 
     * @param deviceInfo 设备台账信息
     * @return 结果
     */
    public int insertDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 修改设备台账信息
     * 
     * @param deviceInfo 设备台账信息
     * @return 结果
     */
    public int updateDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 删除设备台账信息
     * 
     * @param id 设备台账信息ID
     * @return 结果
     */
    public int deleteDeviceInfoById(Integer id);

    /**
     * 批量删除设备台账信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDeviceInfoByIds(String[] ids);
}

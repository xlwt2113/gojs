package com.ruoyi.device.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.device.mapper.DeviceTopologyMapper;
import com.ruoyi.device.domain.DeviceTopology;
import com.ruoyi.device.service.IDeviceTopologyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 拓扑图维护Service业务层处理
 * 
 * @author 王涛
 * @date 2021-04-06
 */
@Service
public class DeviceTopologyServiceImpl implements IDeviceTopologyService 
{
    @Autowired
    private DeviceTopologyMapper deviceTopologyMapper;

    /**
     * 查询拓扑图维护
     * 
     * @param id 拓扑图维护ID
     * @return 拓扑图维护
     */
    @Override
    public DeviceTopology selectDeviceTopologyById(Long id)
    {
        return deviceTopologyMapper.selectDeviceTopologyById(id);
    }

    /**
     * 查询拓扑图维护列表
     * 
     * @param deviceTopology 拓扑图维护
     * @return 拓扑图维护
     */
    @Override
    public List<DeviceTopology> selectDeviceTopologyList(DeviceTopology deviceTopology)
    {
        return deviceTopologyMapper.selectDeviceTopologyList(deviceTopology);
    }

    /**
     * 新增拓扑图维护
     * 
     * @param deviceTopology 拓扑图维护
     * @return 结果
     */
    @Override
    public int insertDeviceTopology(DeviceTopology deviceTopology)
    {
        deviceTopology.setCreateTime(DateUtils.getNowDate());
        return deviceTopologyMapper.insertDeviceTopology(deviceTopology);
    }

    /**
     * 修改拓扑图维护
     * 
     * @param deviceTopology 拓扑图维护
     * @return 结果
     */
    @Override
    public int updateDeviceTopology(DeviceTopology deviceTopology)
    {
        deviceTopology.setUpdateTime(DateUtils.getNowDate());
        return deviceTopologyMapper.updateDeviceTopology(deviceTopology);
    }

    /**
     * 删除拓扑图维护对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDeviceTopologyByIds(String ids)
    {
        return deviceTopologyMapper.deleteDeviceTopologyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除拓扑图维护信息
     * 
     * @param id 拓扑图维护ID
     * @return 结果
     */
    @Override
    public int deleteDeviceTopologyById(Long id)
    {
        return deviceTopologyMapper.deleteDeviceTopologyById(id);
    }
}

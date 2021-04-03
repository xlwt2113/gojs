package com.ruoyi.device.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备状态表对象 device_status
 * 
 * @author 王涛
 * @date 2021-04-03
 */
public class DeviceStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 设备Id */
    @Excel(name = "设备Id")
    private Long deviceId;

    /** 设备实时状态 */
    @Excel(name = "设备实时状态")
    private Long deviceStatus;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }
    public void setDeviceStatus(Long deviceStatus) 
    {
        this.deviceStatus = deviceStatus;
    }

    public Long getDeviceStatus() 
    {
        return deviceStatus;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("deviceStatus", getDeviceStatus())
            .append("updateTime", getUpdateTime())
            .append("note", getNote())
            .toString();
    }
}

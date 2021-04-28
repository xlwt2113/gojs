package com.ruoyi.device.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 设备状态表对象 device_status
 *
 * @author 王涛
 * @date 2021-04-27
 */
public class DeviceStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private DeviceInfo deviceInfo;

    /**  */
    private Long id;

    private String updateTimeBegin,updateTimeEnd;

    /** 设备Id */
    @Excel(name = "设备Id")
    private Long deviceId;

    /** 设备实时状态 */
    @Excel(name = "设备实时状态")
    private Long deviceStatus;

    /** ping平均时延 */
    @Excel(name = "ping平均时延")
    private Long pingAvg;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 最小时延 */
    @Excel(name = "最小时延")
    private Long pingMin;

    /** 最大时延 */
    @Excel(name = "最大时延")
    private Long pingMax;

    /** 丢包率 */
    @Excel(name = "丢包率")
    private Long pingLoss;

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
    public void setPingAvg(Long pingAvg)
    {
        this.pingAvg = pingAvg;
    }

    public Long getPingAvg()
    {
        return pingAvg;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setPingMin(Long pingMin)
    {
        this.pingMin = pingMin;
    }

    public Long getPingMin()
    {
        return pingMin;
    }
    public void setPingMax(Long pingMax)
    {
        this.pingMax = pingMax;
    }

    public Long getPingMax()
    {
        return pingMax;
    }
    public void setPingLoss(Long pingLoss)
    {
        this.pingLoss = pingLoss;
    }

    public Long getPingLoss()
    {
        return pingLoss;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getUpdateTimeBegin() {
        return updateTimeBegin;
    }

    public void setUpdateTimeBegin(String updateTimeBegin) {
        this.updateTimeBegin = updateTimeBegin;
    }

    public String getUpdateTimeEnd() {
        return updateTimeEnd;
    }

    public void setUpdateTimeEnd(String updateTimeEnd) {
        this.updateTimeEnd = updateTimeEnd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("deviceStatus", getDeviceStatus())
            .append("updateTime", getUpdateTime())
            .append("pingAvg", getPingAvg())
            .append("note", getNote())
            .append("pingMin", getPingMin())
            .append("pingMax", getPingMax())
            .append("pingLoss", getPingLoss())
            .toString();
    }
}

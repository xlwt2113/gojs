package com.ruoyi.device.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备台账信息对象 device_info
 *
 * @author 王涛
 * @date 2021-04-27
 */
public class DeviceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private SysDept dept;

    /**  */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String deviceModel;

    /** 设备类型。对应字典表 */
    @Excel(name = "设备类型。对应字典表")
    private String deviceType;

    /** 制造商 */
    @Excel(name = "制造商")
    private String manufacturer;

    /** 设备IP1 */
    @Excel(name = "设备IP1")
    private String deviceIp1;

    /** 设备IP2 */
    @Excel(name = "设备IP2")
    private String deviceIp2;

    /** 设备IP3 */
    @Excel(name = "设备IP3")
    private String deviceIp3;

    /** 设备IP4 */
    @Excel(name = "设备IP4")
    private String deviceIp4;

    /** 设备IP5 */
    @Excel(name = "设备IP5")
    private String deviceIp5;

    /** 设备IP6 */
    @Excel(name = "设备IP6")
    private String deviceIp6;

    /** 设备IP7 */
    @Excel(name = "设备IP7")
    private String deviceIp7;

    /** 设备IP8 */
    @Excel(name = "设备IP8")
    private String deviceIp8;

    /** 安装日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "安装日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date installDate;

    /** 安装位置 */
    @Excel(name = "安装位置")
    private String location;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 所属煤矿 */
    @Excel(name = "所属煤矿")
    private String miningArea;

    /** 所属集团 */
    @Excel(name = "所属集团")
    private String company;

    /** 归属部门 */
    @Excel(name = "归属部门")
    private Long deptId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }
    public void setDeviceModel(String deviceModel)
    {
        this.deviceModel = deviceModel;
    }

    public String getDeviceModel()
    {
        return deviceModel;
    }
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType()
    {
        return deviceType;
    }
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }
    public void setDeviceIp1(String deviceIp1)
    {
        this.deviceIp1 = deviceIp1;
    }

    public String getDeviceIp1()
    {
        return deviceIp1;
    }
    public void setDeviceIp2(String deviceIp2)
    {
        this.deviceIp2 = deviceIp2;
    }

    public String getDeviceIp2()
    {
        return deviceIp2;
    }
    public void setDeviceIp3(String deviceIp3)
    {
        this.deviceIp3 = deviceIp3;
    }

    public String getDeviceIp3()
    {
        return deviceIp3;
    }
    public void setDeviceIp4(String deviceIp4)
    {
        this.deviceIp4 = deviceIp4;
    }

    public String getDeviceIp4()
    {
        return deviceIp4;
    }
    public void setDeviceIp5(String deviceIp5)
    {
        this.deviceIp5 = deviceIp5;
    }

    public String getDeviceIp5()
    {
        return deviceIp5;
    }
    public void setDeviceIp6(String deviceIp6)
    {
        this.deviceIp6 = deviceIp6;
    }

    public String getDeviceIp6()
    {
        return deviceIp6;
    }
    public void setDeviceIp7(String deviceIp7)
    {
        this.deviceIp7 = deviceIp7;
    }

    public String getDeviceIp7()
    {
        return deviceIp7;
    }
    public void setDeviceIp8(String deviceIp8)
    {
        this.deviceIp8 = deviceIp8;
    }

    public String getDeviceIp8()
    {
        return deviceIp8;
    }
    public void setInstallDate(Date installDate)
    {
        this.installDate = installDate;
    }

    public Date getInstallDate()
    {
        return installDate;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return location;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setMiningArea(String miningArea)
    {
        this.miningArea = miningArea;
    }

    public String getMiningArea()
    {
        return miningArea;
    }
    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getCompany()
    {
        return company;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceName", getDeviceName())
            .append("deviceModel", getDeviceModel())
            .append("deviceType", getDeviceType())
            .append("manufacturer", getManufacturer())
            .append("deviceIp1", getDeviceIp1())
            .append("deviceIp2", getDeviceIp2())
            .append("deviceIp3", getDeviceIp3())
            .append("deviceIp4", getDeviceIp4())
            .append("deviceIp5", getDeviceIp5())
            .append("deviceIp6", getDeviceIp6())
            .append("deviceIp7", getDeviceIp7())
            .append("deviceIp8", getDeviceIp8())
            .append("installDate", getInstallDate())
            .append("location", getLocation())
            .append("note", getNote())
            .append("miningArea", getMiningArea())
            .append("company", getCompany())
            .append("deptId", getDeptId())
            .toString();
    }
}

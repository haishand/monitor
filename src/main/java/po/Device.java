package po;

public class Device {
    private Integer code;

    private Integer deviceid;

    private Integer nodeid;

    private Boolean multiflag;

    private String devicename;

    private Integer devicetype;

    private String param1name;

    private String param2name;

    private Integer saveinterval;

    private Float lowalarmlimit1;

    private Float hialarmlimit1;

    private Float lowalarmlimit2;

    private Float hialarmlimit2;

    private Integer onlinestatus;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public Integer getNodeid() {
        return nodeid;
    }

    public void setNodeid(Integer nodeid) {
        this.nodeid = nodeid;
    }

    public Boolean getMultiflag() {
        return multiflag;
    }

    public void setMultiflag(Boolean multiflag) {
        this.multiflag = multiflag;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename == null ? null : devicename.trim();
    }

    public Integer getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(Integer devicetype) {
        this.devicetype = devicetype;
    }

    public String getParam1name() {
        return param1name;
    }

    public void setParam1name(String param1name) {
        this.param1name = param1name == null ? null : param1name.trim();
    }

    public String getParam2name() {
        return param2name;
    }

    public void setParam2name(String param2name) {
        this.param2name = param2name == null ? null : param2name.trim();
    }

    public Integer getSaveinterval() {
        return saveinterval;
    }

    public void setSaveinterval(Integer saveinterval) {
        this.saveinterval = saveinterval;
    }

    public Float getLowalarmlimit1() {
        return lowalarmlimit1;
    }

    public void setLowalarmlimit1(Float lowalarmlimit1) {
        this.lowalarmlimit1 = lowalarmlimit1;
    }

    public Float getHialarmlimit1() {
        return hialarmlimit1;
    }

    public void setHialarmlimit1(Float hialarmlimit1) {
        this.hialarmlimit1 = hialarmlimit1;
    }

    public Float getLowalarmlimit2() {
        return lowalarmlimit2;
    }

    public void setLowalarmlimit2(Float lowalarmlimit2) {
        this.lowalarmlimit2 = lowalarmlimit2;
    }

    public Float getHialarmlimit2() {
        return hialarmlimit2;
    }

    public void setHialarmlimit2(Float hialarmlimit2) {
        this.hialarmlimit2 = hialarmlimit2;
    }

    public Integer getOnlinestatus() {
        return onlinestatus;
    }

    public void setOnlinestatus(Integer onlinestatus) {
        this.onlinestatus = onlinestatus;
    }
}
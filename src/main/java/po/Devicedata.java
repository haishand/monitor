package po;

import java.util.Date;

public class Devicedata {
    private Integer code;

    private Float param1;

    private Float param2;

    private Date recordtime;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Float getParam1() {
        return param1;
    }

    public void setParam1(Float param1) {
        this.param1 = param1;
    }

    public Float getParam2() {
        return param2;
    }

    public void setParam2(Float param2) {
        this.param2 = param2;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }
}
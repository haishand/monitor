package po;

import java.util.ArrayList;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Integer value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Integer value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Integer value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Integer value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Integer value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Integer> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Integer> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Integer value1, Integer value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(Integer value) {
            addCriterion("deviceId =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(Integer value) {
            addCriterion("deviceId <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(Integer value) {
            addCriterion("deviceId >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("deviceId >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(Integer value) {
            addCriterion("deviceId <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(Integer value) {
            addCriterion("deviceId <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<Integer> values) {
            addCriterion("deviceId in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<Integer> values) {
            addCriterion("deviceId not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(Integer value1, Integer value2) {
            addCriterion("deviceId between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(Integer value1, Integer value2) {
            addCriterion("deviceId not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andNodeidIsNull() {
            addCriterion("nodeId is null");
            return (Criteria) this;
        }

        public Criteria andNodeidIsNotNull() {
            addCriterion("nodeId is not null");
            return (Criteria) this;
        }

        public Criteria andNodeidEqualTo(Integer value) {
            addCriterion("nodeId =", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidNotEqualTo(Integer value) {
            addCriterion("nodeId <>", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidGreaterThan(Integer value) {
            addCriterion("nodeId >", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("nodeId >=", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidLessThan(Integer value) {
            addCriterion("nodeId <", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidLessThanOrEqualTo(Integer value) {
            addCriterion("nodeId <=", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidIn(List<Integer> values) {
            addCriterion("nodeId in", values, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidNotIn(List<Integer> values) {
            addCriterion("nodeId not in", values, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidBetween(Integer value1, Integer value2) {
            addCriterion("nodeId between", value1, value2, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidNotBetween(Integer value1, Integer value2) {
            addCriterion("nodeId not between", value1, value2, "nodeid");
            return (Criteria) this;
        }

        public Criteria andMultiflagIsNull() {
            addCriterion("multiFlag is null");
            return (Criteria) this;
        }

        public Criteria andMultiflagIsNotNull() {
            addCriterion("multiFlag is not null");
            return (Criteria) this;
        }

        public Criteria andMultiflagEqualTo(Boolean value) {
            addCriterion("multiFlag =", value, "multiflag");
            return (Criteria) this;
        }

        public Criteria andMultiflagNotEqualTo(Boolean value) {
            addCriterion("multiFlag <>", value, "multiflag");
            return (Criteria) this;
        }

        public Criteria andMultiflagGreaterThan(Boolean value) {
            addCriterion("multiFlag >", value, "multiflag");
            return (Criteria) this;
        }

        public Criteria andMultiflagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("multiFlag >=", value, "multiflag");
            return (Criteria) this;
        }

        public Criteria andMultiflagLessThan(Boolean value) {
            addCriterion("multiFlag <", value, "multiflag");
            return (Criteria) this;
        }

        public Criteria andMultiflagLessThanOrEqualTo(Boolean value) {
            addCriterion("multiFlag <=", value, "multiflag");
            return (Criteria) this;
        }

        public Criteria andMultiflagIn(List<Boolean> values) {
            addCriterion("multiFlag in", values, "multiflag");
            return (Criteria) this;
        }

        public Criteria andMultiflagNotIn(List<Boolean> values) {
            addCriterion("multiFlag not in", values, "multiflag");
            return (Criteria) this;
        }

        public Criteria andMultiflagBetween(Boolean value1, Boolean value2) {
            addCriterion("multiFlag between", value1, value2, "multiflag");
            return (Criteria) this;
        }

        public Criteria andMultiflagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("multiFlag not between", value1, value2, "multiflag");
            return (Criteria) this;
        }

        public Criteria andDevicenameIsNull() {
            addCriterion("deviceName is null");
            return (Criteria) this;
        }

        public Criteria andDevicenameIsNotNull() {
            addCriterion("deviceName is not null");
            return (Criteria) this;
        }

        public Criteria andDevicenameEqualTo(String value) {
            addCriterion("deviceName =", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameNotEqualTo(String value) {
            addCriterion("deviceName <>", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameGreaterThan(String value) {
            addCriterion("deviceName >", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameGreaterThanOrEqualTo(String value) {
            addCriterion("deviceName >=", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameLessThan(String value) {
            addCriterion("deviceName <", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameLessThanOrEqualTo(String value) {
            addCriterion("deviceName <=", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameLike(String value) {
            addCriterion("deviceName like", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameNotLike(String value) {
            addCriterion("deviceName not like", value, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameIn(List<String> values) {
            addCriterion("deviceName in", values, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameNotIn(List<String> values) {
            addCriterion("deviceName not in", values, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameBetween(String value1, String value2) {
            addCriterion("deviceName between", value1, value2, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicenameNotBetween(String value1, String value2) {
            addCriterion("deviceName not between", value1, value2, "devicename");
            return (Criteria) this;
        }

        public Criteria andDevicetypeIsNull() {
            addCriterion("deviceType is null");
            return (Criteria) this;
        }

        public Criteria andDevicetypeIsNotNull() {
            addCriterion("deviceType is not null");
            return (Criteria) this;
        }

        public Criteria andDevicetypeEqualTo(Integer value) {
            addCriterion("deviceType =", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeNotEqualTo(Integer value) {
            addCriterion("deviceType <>", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeGreaterThan(Integer value) {
            addCriterion("deviceType >", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("deviceType >=", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeLessThan(Integer value) {
            addCriterion("deviceType <", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeLessThanOrEqualTo(Integer value) {
            addCriterion("deviceType <=", value, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeIn(List<Integer> values) {
            addCriterion("deviceType in", values, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeNotIn(List<Integer> values) {
            addCriterion("deviceType not in", values, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeBetween(Integer value1, Integer value2) {
            addCriterion("deviceType between", value1, value2, "devicetype");
            return (Criteria) this;
        }

        public Criteria andDevicetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("deviceType not between", value1, value2, "devicetype");
            return (Criteria) this;
        }

        public Criteria andParam1nameIsNull() {
            addCriterion("param1Name is null");
            return (Criteria) this;
        }

        public Criteria andParam1nameIsNotNull() {
            addCriterion("param1Name is not null");
            return (Criteria) this;
        }

        public Criteria andParam1nameEqualTo(String value) {
            addCriterion("param1Name =", value, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameNotEqualTo(String value) {
            addCriterion("param1Name <>", value, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameGreaterThan(String value) {
            addCriterion("param1Name >", value, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameGreaterThanOrEqualTo(String value) {
            addCriterion("param1Name >=", value, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameLessThan(String value) {
            addCriterion("param1Name <", value, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameLessThanOrEqualTo(String value) {
            addCriterion("param1Name <=", value, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameLike(String value) {
            addCriterion("param1Name like", value, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameNotLike(String value) {
            addCriterion("param1Name not like", value, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameIn(List<String> values) {
            addCriterion("param1Name in", values, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameNotIn(List<String> values) {
            addCriterion("param1Name not in", values, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameBetween(String value1, String value2) {
            addCriterion("param1Name between", value1, value2, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam1nameNotBetween(String value1, String value2) {
            addCriterion("param1Name not between", value1, value2, "param1name");
            return (Criteria) this;
        }

        public Criteria andParam2nameIsNull() {
            addCriterion("param2Name is null");
            return (Criteria) this;
        }

        public Criteria andParam2nameIsNotNull() {
            addCriterion("param2Name is not null");
            return (Criteria) this;
        }

        public Criteria andParam2nameEqualTo(String value) {
            addCriterion("param2Name =", value, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameNotEqualTo(String value) {
            addCriterion("param2Name <>", value, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameGreaterThan(String value) {
            addCriterion("param2Name >", value, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameGreaterThanOrEqualTo(String value) {
            addCriterion("param2Name >=", value, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameLessThan(String value) {
            addCriterion("param2Name <", value, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameLessThanOrEqualTo(String value) {
            addCriterion("param2Name <=", value, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameLike(String value) {
            addCriterion("param2Name like", value, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameNotLike(String value) {
            addCriterion("param2Name not like", value, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameIn(List<String> values) {
            addCriterion("param2Name in", values, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameNotIn(List<String> values) {
            addCriterion("param2Name not in", values, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameBetween(String value1, String value2) {
            addCriterion("param2Name between", value1, value2, "param2name");
            return (Criteria) this;
        }

        public Criteria andParam2nameNotBetween(String value1, String value2) {
            addCriterion("param2Name not between", value1, value2, "param2name");
            return (Criteria) this;
        }

        public Criteria andSaveintervalIsNull() {
            addCriterion("saveInterval is null");
            return (Criteria) this;
        }

        public Criteria andSaveintervalIsNotNull() {
            addCriterion("saveInterval is not null");
            return (Criteria) this;
        }

        public Criteria andSaveintervalEqualTo(Integer value) {
            addCriterion("saveInterval =", value, "saveinterval");
            return (Criteria) this;
        }

        public Criteria andSaveintervalNotEqualTo(Integer value) {
            addCriterion("saveInterval <>", value, "saveinterval");
            return (Criteria) this;
        }

        public Criteria andSaveintervalGreaterThan(Integer value) {
            addCriterion("saveInterval >", value, "saveinterval");
            return (Criteria) this;
        }

        public Criteria andSaveintervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("saveInterval >=", value, "saveinterval");
            return (Criteria) this;
        }

        public Criteria andSaveintervalLessThan(Integer value) {
            addCriterion("saveInterval <", value, "saveinterval");
            return (Criteria) this;
        }

        public Criteria andSaveintervalLessThanOrEqualTo(Integer value) {
            addCriterion("saveInterval <=", value, "saveinterval");
            return (Criteria) this;
        }

        public Criteria andSaveintervalIn(List<Integer> values) {
            addCriterion("saveInterval in", values, "saveinterval");
            return (Criteria) this;
        }

        public Criteria andSaveintervalNotIn(List<Integer> values) {
            addCriterion("saveInterval not in", values, "saveinterval");
            return (Criteria) this;
        }

        public Criteria andSaveintervalBetween(Integer value1, Integer value2) {
            addCriterion("saveInterval between", value1, value2, "saveinterval");
            return (Criteria) this;
        }

        public Criteria andSaveintervalNotBetween(Integer value1, Integer value2) {
            addCriterion("saveInterval not between", value1, value2, "saveinterval");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1IsNull() {
            addCriterion("lowAlarmLimit1 is null");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1IsNotNull() {
            addCriterion("lowAlarmLimit1 is not null");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1EqualTo(Float value) {
            addCriterion("lowAlarmLimit1 =", value, "lowalarmlimit1");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1NotEqualTo(Float value) {
            addCriterion("lowAlarmLimit1 <>", value, "lowalarmlimit1");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1GreaterThan(Float value) {
            addCriterion("lowAlarmLimit1 >", value, "lowalarmlimit1");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1GreaterThanOrEqualTo(Float value) {
            addCriterion("lowAlarmLimit1 >=", value, "lowalarmlimit1");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1LessThan(Float value) {
            addCriterion("lowAlarmLimit1 <", value, "lowalarmlimit1");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1LessThanOrEqualTo(Float value) {
            addCriterion("lowAlarmLimit1 <=", value, "lowalarmlimit1");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1In(List<Float> values) {
            addCriterion("lowAlarmLimit1 in", values, "lowalarmlimit1");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1NotIn(List<Float> values) {
            addCriterion("lowAlarmLimit1 not in", values, "lowalarmlimit1");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1Between(Float value1, Float value2) {
            addCriterion("lowAlarmLimit1 between", value1, value2, "lowalarmlimit1");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit1NotBetween(Float value1, Float value2) {
            addCriterion("lowAlarmLimit1 not between", value1, value2, "lowalarmlimit1");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1IsNull() {
            addCriterion("hiAlarmLimit1 is null");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1IsNotNull() {
            addCriterion("hiAlarmLimit1 is not null");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1EqualTo(Float value) {
            addCriterion("hiAlarmLimit1 =", value, "hialarmlimit1");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1NotEqualTo(Float value) {
            addCriterion("hiAlarmLimit1 <>", value, "hialarmlimit1");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1GreaterThan(Float value) {
            addCriterion("hiAlarmLimit1 >", value, "hialarmlimit1");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1GreaterThanOrEqualTo(Float value) {
            addCriterion("hiAlarmLimit1 >=", value, "hialarmlimit1");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1LessThan(Float value) {
            addCriterion("hiAlarmLimit1 <", value, "hialarmlimit1");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1LessThanOrEqualTo(Float value) {
            addCriterion("hiAlarmLimit1 <=", value, "hialarmlimit1");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1In(List<Float> values) {
            addCriterion("hiAlarmLimit1 in", values, "hialarmlimit1");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1NotIn(List<Float> values) {
            addCriterion("hiAlarmLimit1 not in", values, "hialarmlimit1");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1Between(Float value1, Float value2) {
            addCriterion("hiAlarmLimit1 between", value1, value2, "hialarmlimit1");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit1NotBetween(Float value1, Float value2) {
            addCriterion("hiAlarmLimit1 not between", value1, value2, "hialarmlimit1");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2IsNull() {
            addCriterion("lowAlarmLimit2 is null");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2IsNotNull() {
            addCriterion("lowAlarmLimit2 is not null");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2EqualTo(Float value) {
            addCriterion("lowAlarmLimit2 =", value, "lowalarmlimit2");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2NotEqualTo(Float value) {
            addCriterion("lowAlarmLimit2 <>", value, "lowalarmlimit2");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2GreaterThan(Float value) {
            addCriterion("lowAlarmLimit2 >", value, "lowalarmlimit2");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2GreaterThanOrEqualTo(Float value) {
            addCriterion("lowAlarmLimit2 >=", value, "lowalarmlimit2");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2LessThan(Float value) {
            addCriterion("lowAlarmLimit2 <", value, "lowalarmlimit2");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2LessThanOrEqualTo(Float value) {
            addCriterion("lowAlarmLimit2 <=", value, "lowalarmlimit2");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2In(List<Float> values) {
            addCriterion("lowAlarmLimit2 in", values, "lowalarmlimit2");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2NotIn(List<Float> values) {
            addCriterion("lowAlarmLimit2 not in", values, "lowalarmlimit2");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2Between(Float value1, Float value2) {
            addCriterion("lowAlarmLimit2 between", value1, value2, "lowalarmlimit2");
            return (Criteria) this;
        }

        public Criteria andLowalarmlimit2NotBetween(Float value1, Float value2) {
            addCriterion("lowAlarmLimit2 not between", value1, value2, "lowalarmlimit2");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2IsNull() {
            addCriterion("hiAlarmLimit2 is null");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2IsNotNull() {
            addCriterion("hiAlarmLimit2 is not null");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2EqualTo(Float value) {
            addCriterion("hiAlarmLimit2 =", value, "hialarmlimit2");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2NotEqualTo(Float value) {
            addCriterion("hiAlarmLimit2 <>", value, "hialarmlimit2");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2GreaterThan(Float value) {
            addCriterion("hiAlarmLimit2 >", value, "hialarmlimit2");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2GreaterThanOrEqualTo(Float value) {
            addCriterion("hiAlarmLimit2 >=", value, "hialarmlimit2");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2LessThan(Float value) {
            addCriterion("hiAlarmLimit2 <", value, "hialarmlimit2");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2LessThanOrEqualTo(Float value) {
            addCriterion("hiAlarmLimit2 <=", value, "hialarmlimit2");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2In(List<Float> values) {
            addCriterion("hiAlarmLimit2 in", values, "hialarmlimit2");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2NotIn(List<Float> values) {
            addCriterion("hiAlarmLimit2 not in", values, "hialarmlimit2");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2Between(Float value1, Float value2) {
            addCriterion("hiAlarmLimit2 between", value1, value2, "hialarmlimit2");
            return (Criteria) this;
        }

        public Criteria andHialarmlimit2NotBetween(Float value1, Float value2) {
            addCriterion("hiAlarmLimit2 not between", value1, value2, "hialarmlimit2");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusIsNull() {
            addCriterion("onlineStatus is null");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusIsNotNull() {
            addCriterion("onlineStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusEqualTo(Integer value) {
            addCriterion("onlineStatus =", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusNotEqualTo(Integer value) {
            addCriterion("onlineStatus <>", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusGreaterThan(Integer value) {
            addCriterion("onlineStatus >", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("onlineStatus >=", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusLessThan(Integer value) {
            addCriterion("onlineStatus <", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusLessThanOrEqualTo(Integer value) {
            addCriterion("onlineStatus <=", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusIn(List<Integer> values) {
            addCriterion("onlineStatus in", values, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusNotIn(List<Integer> values) {
            addCriterion("onlineStatus not in", values, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusBetween(Integer value1, Integer value2) {
            addCriterion("onlineStatus between", value1, value2, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("onlineStatus not between", value1, value2, "onlinestatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}